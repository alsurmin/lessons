public class VolitileMain {
    static int i;

    public static void main (String[] args){
        new MyThreadRead().start();
        new MyThreadWrite().start();
    }

    static class MyThreadWrite extends Thread {
        @Override
        public void run() {
            while(i<5){
                System.out.println("increment i to " + (++i));
            }
        }
    }
    static class MyThreadRead extends Thread {
        @Override
        public void run() {

        }
    }

}
