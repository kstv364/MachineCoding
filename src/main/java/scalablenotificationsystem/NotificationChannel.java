package scalablenotificationsystem;

import scalablenotificationsystem.models.Notification;

public interface NotificationChannel {
    void send(Notification notification);
}
