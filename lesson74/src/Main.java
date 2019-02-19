public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        ThreadB threadB = new ThreadB();
        threadB.start();
        synchronized (threadB){
            threadB.wait();
        }
        System.out.println(threadB.total);
    }

    static class ThreadB extends Thread {
        int total;
        @Override
        public void run() {
            synchronized (this){
                for (int i = 0; i < 5; i++) {
                    total +=i;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName());
                notify();
            }
        }
    }
}
