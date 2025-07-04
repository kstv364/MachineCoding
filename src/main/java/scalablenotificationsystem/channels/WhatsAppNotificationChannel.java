package scalablenotificationsystem.channels;

import scalablenotificationsystem.NotificationChannel;
import scalablenotificationsystem.models.Notification;

public class WhatsAppNotificationChannel implements NotificationChannel {
    @Override
    public void send(Notification notification) {
        // Call WhatsApp API (e.g., Twilio, WhatsApp Business API)
        System.out.println("Sending WhatsApp message to " + notification.getUserId() + " with content: " + notification.getContent());
    }
}
