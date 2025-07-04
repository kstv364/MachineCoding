package scalablenotificationsystem;

import scalablenotificationsystem.events.NotificationEvent;

import java.util.concurrent.BlockingQueue;

public class OrderService {


    private final BlockingQueue<NotificationEvent> queue;

    public OrderService(BlockingQueue<NotificationEvent> queue) {
        this.queue = queue;
    }

    public void publish(NotificationEvent event) {
        try {
            queue.put(event); // Publish event to queue
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
