package scalablenotificationsystem;
import scalablenotificationsystem.channels.EmailNotificationChannel;
import scalablenotificationsystem.channels.SmsNotificationChannel;
import scalablenotificationsystem.channels.WhatsAppNotificationChannel;
import scalablenotificationsystem.models.Notification;
import java.util.HashMap;

public class NotificationDispatcher {

    HashMap<String, NotificationChannel> channelMap = new HashMap<>();
    public NotificationDispatcher() {
        channelMap = new HashMap<>();
        channelMap.put("EMAIL", new EmailNotificationChannel());
        channelMap.put("SMS", new SmsNotificationChannel());
        channelMap.put("WHATSAPP", new WhatsAppNotificationChannel());
    }




    public void dispatch(Notification notification) {
        NotificationChannel channel = channelMap.get(notification.getChannelType());
        if (channel != null) {
            channel.send(notification);
        } else {
            throw new UnsupportedOperationException("Channel not supported: " + notification.getChannelType());
        }
    }
}
