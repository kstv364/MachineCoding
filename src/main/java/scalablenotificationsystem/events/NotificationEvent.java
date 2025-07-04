package scalablenotificationsystem.events;

import scalablenotificationsystem.models.Notification;

public class NotificationEvent {
    private String eventType;
    private Notification notification;

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }
}
