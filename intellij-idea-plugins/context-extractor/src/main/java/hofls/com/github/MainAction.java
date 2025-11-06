package hofls.com.github;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class MainAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        var project = e.getProject();
        var logFile = project.getBasePath() != null
                ? Paths.get(project.getBasePath(), "context-extractor.txt")
                : Paths.get(System.getProperty("user.home"), "context-extractor.txt");
        try {
            var message = "Extracted context for LLM INSERT_HERE";
            Files.writeString(logFile, message, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            var notification = new Notification("NotificationGroupId", "Logged", "Context saved to " + logFile, NotificationType.INFORMATION);
            Notifications.Bus.notify(notification, project);
        } catch (IOException ex) {}
    }

    @Override
    public void update(AnActionEvent e) {
        // Only enable when a project is open
        e.getPresentation().setEnabledAndVisible(e.getProject() != null);
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }
}