package scalablenotificationsystem.channels;

import scalablenotificationsystem.NotificationChannel;
import scalablenotificationsystem.models.Notification;

public class EmailNotificationChannel implements NotificationChannel {
    @Override
    public void send(Notification notification) {
        // Call email API (e.g., SendGrid, SES)
        System.out.println("Sending Email to " + notification.getUserId() + " with message: " + notification.getContent());
    }
}
