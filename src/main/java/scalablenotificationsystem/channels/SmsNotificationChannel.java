package scalablenotificationsystem.channels;

import scalablenotificationsystem.NotificationChannel;
import scalablenotificationsystem.models.Notification;

public class SmsNotificationChannel implements NotificationChannel {
    @Override
    public void send(Notification notification) {
        System.out.println("Sending SMS to " + notification.getUserId() + " with message: " + notification.getContent());
    }
}
