package scalablenotificationsystem;

import scalablenotificationsystem.events.NotificationEvent;

import java.util.concurrent.BlockingQueue;

public class NotificationWorker implements Runnable {
    private final BlockingQueue<NotificationEvent> queue;
    private final NotificationDispatcher dispatcher;

    public NotificationWorker(BlockingQueue<NotificationEvent> queue, NotificationDispatcher dispatcher) {
        this.queue = queue;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        while (true) {
            try {
                NotificationEvent event = queue.take(); // Blocking call
                dispatcher.dispatch(event.getNotification());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                // Handle failure, maybe push to Dead Letter Queue
                System.out.println("Failed to process notification: " + e.getMessage());
            }
        }
    }
}
