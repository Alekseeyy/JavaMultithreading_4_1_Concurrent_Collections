import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {
    private static final Queue<String> phoneCalls = new ConcurrentLinkedQueue<>();
    private static final int PAUSE = 1000;
    private static final int ANSWER = 3000;

    public void call() {
        phoneCalls.offer(Thread.currentThread().getName());
        try {
            Thread.sleep(PAUSE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Звонок " + Thread.currentThread().getName());
    }

    public void takeTheCall() {
        while (!phoneCalls.isEmpty()) {
            try {
                Thread.sleep(ANSWER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String value = phoneCalls.poll();
            if (value == null) break;
            System.out.println("Специалист " + Thread.currentThread().getName() + " ответил на звонок " + value);
        }
    }
}
