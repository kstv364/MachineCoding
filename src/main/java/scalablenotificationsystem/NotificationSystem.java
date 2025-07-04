package scalablenotificationsystem;

import scalablenotificationsystem.events.NotificationEvent;
import scalablenotificationsystem.models.Notification;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class NotificationSystem {
    public static void main(String[] args) {
        BlockingQueue<NotificationEvent> queue = new LinkedBlockingQueue<>();
        NotificationDispatcher dispatcher = new NotificationDispatcher();

        // Start multiple workers for parallel processing
        for (int i = 0; i < 5; i++) {
            new Thread(new NotificationWorker(queue, dispatcher)).start();
        }

        OrderService orderService = new OrderService(queue);
        Notification notification = new Notification();
        notification.setUserId("user123");
        notification.setChannelType("EMAIL");
        notification.setContent("Your order has been confirmed!");

        NotificationEvent event = new NotificationEvent();
        event.setEventType("ORDER_CONFIRMED");
        event.setNotification(notification);

        orderService.publish(event);
    }
}

