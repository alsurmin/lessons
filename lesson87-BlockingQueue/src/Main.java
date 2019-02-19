
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new PriorityBlockingQueue<String>(){
        };
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(queue.add("this is string"));
            }
        }.start();
    }
}
