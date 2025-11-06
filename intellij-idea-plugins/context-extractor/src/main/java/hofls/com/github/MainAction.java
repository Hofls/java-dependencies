package hofls.com.github;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

public class MainAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        PsiFile psiFile = e.getData(LangDataKeys.PSI_FILE);

        if (project == null || editor == null || psiFile == null) {
            return;
        }

        int offset = editor.getCaretModel().getOffset();
        PsiElement element = psiFile.findElementAt(offset);

        PsiMethod method = findEnclosingMethod(element);
        if (method == null) {
            notify(project, "No method found at cursor");
            return;
        }

        StringBuilder context = new StringBuilder();
        context.append("Method: ").append(method.getName()).append("\n\n");

        // Parameters
        context.append("Parameters:\n");
        for (PsiParameter param : method.getParameterList().getParameters()) {
            context.append("  ").append(param.getType().getPresentableText())
                    .append(" ").append(param.getName()).append("\n");
            appendTypeFields(param.getType(), context, "    ", new HashSet<>());
        }

        // Return type
        PsiType returnType = method.getReturnType();
        context.append("\nReturn type:\n");
        if (returnType != null) {
            context.append("  ").append(returnType.getPresentableText()).append("\n");
            appendTypeFields(returnType, context, "    ", new HashSet<>());
        } else {
            context.append("  void\n");
        }

        // Write to file
        Path logFile = project.getBasePath() != null
                ? Paths.get(project.getBasePath(), "context-extractor.txt")
                : Paths.get(System.getProperty("user.home"), "context-extractor.txt");

        try {
            Files.writeString(logFile, context.toString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            notify(project, "Context saved to " + logFile);
        } catch (IOException ex) {
            notify(project, "Error writing file: " + ex.getMessage());
        }
    }

    /**
     * Recursively append fields for a PsiType.
     * Handles:
     *  - arrays
     *  - parameterized collections (List<T>, Set<T>, Collection<T>) -> expand T
     *  - Map<K,V> -> show key/value and expand V
     *  - normal classes -> list fields and recurse
     *
     * visited stores canonical text to avoid infinite recursion (including generics)
     */
    private void appendTypeFields(PsiType type, StringBuilder sb, String indent, Set<String> visited) {
        if (type == null) return;

        // Arrays: recurse into component type
        if (type instanceof PsiArrayType arrayType) {
            PsiType comp = arrayType.getComponentType();
            sb.append(indent).append("- array of: ").append(comp.getPresentableText()).append("\n");
            appendTypeFields(comp, sb, indent + "  ", visited);
            return;
        }

        // Parameterized types & class types
        if (type instanceof PsiClassType classType) {
            // Avoid repeating the same concrete type (including generics) to prevent cycles.
            String canonical = type.getCanonicalText();
            if (visited.contains(canonical)) return;
            visited.add(canonical);

            PsiType[] typeArgs = classType.getParameters(); // generic args like Order in List<Order>
            PsiClass psiClass = classType.resolve();
            String qName = psiClass != null ? psiClass.getQualifiedName() : null;

            // Handle common collection interfaces by expanding their element type
            if ("java.util.List".equals(qName) ||
                    "java.util.Set".equals(qName) ||
                    "java.util.Collection".equals(qName) ||
                    "java.util.Optional".equals(qName)) {
                if (typeArgs.length > 0) {
                    PsiType elementType = typeArgs[0];
                    sb.append(indent).append("- element: ").append(elementType.getPresentableText()).append("\n");
                    appendTypeFields(elementType, sb, indent + "  ", visited);
                } else {
                    sb.append(indent).append("- element: (unknown)\n");
                }
                return;
            }

            // Handle Map<K,V> by showing key/value and expanding value
            if ("java.util.Map".equals(qName)) {
                if (typeArgs.length >= 2) {
                    PsiType keyType = typeArgs[0];
                    PsiType valueType = typeArgs[1];
                    sb.append(indent).append("- key: ").append(keyType.getPresentableText()).append("\n");
                    sb.append(indent).append("- value: ").append(valueType.getPresentableText()).append("\n");
                    appendTypeFields(valueType, sb, indent + "  ", visited);
                } else {
                    sb.append(indent).append("- map: (unknown generics)\n");
                }
                return;
            }

            // For other java.* classes, skip expanding (String, Integer, etc.)
            if (qName != null && qName.startsWith("java.")) {
                return;
            }

            // If we resolved a custom class, iterate its fields
            if (psiClass != null) {
                for (PsiField field : psiClass.getAllFields()) {
                    // skip synthetic/static if desired; currently include all instance fields
                    sb.append(indent).append("- ").append(field.getName())
                            .append(": ").append(field.getType().getPresentableText()).append("\n");
                    appendTypeFields(field.getType(), sb, indent + "  ", visited);
                }
            } else {
                // unresolved generic or type variable - try to print presentable text
                sb.append(indent).append("- ").append(type.getPresentableText()).append("\n");
            }
        }
    }

    private PsiMethod findEnclosingMethod(PsiElement element) {
        while (element != null && !(element instanceof PsiMethod)) {
            element = element.getParent();
        }
        return (PsiMethod) element;
    }

    private void notify(Project project, String message) {
        var notification = new Notification(
                "NotificationGroupId", "Context Extractor", message, NotificationType.INFORMATION
        );
        Notifications.Bus.notify(notification, project);
    }

    @Override
    public void update(AnActionEvent e) {
        e.getPresentation().setEnabledAndVisible(e.getProject() != null);
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }
}
