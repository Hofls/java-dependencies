package hofls.com.github;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
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

    private void appendTypeFields(PsiType type, StringBuilder sb, String indent, Set<String> visited) {
        if (!(type instanceof PsiClassType classType)) {
            return;
        }

        PsiClass psiClass = classType.resolve();
        if (psiClass == null) {
            return;
        }

        String className = psiClass.getQualifiedName();
        if (className == null || visited.contains(className) || className.startsWith("java.")) {
            return; // skip primitives and cycles
        }

        visited.add(className);
        for (PsiField field : psiClass.getAllFields()) {
            sb.append(indent).append("- ").append(field.getName())
                    .append(": ").append(field.getType().getPresentableText()).append("\n");
            appendTypeFields(field.getType(), sb, indent + "  ", visited);
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
