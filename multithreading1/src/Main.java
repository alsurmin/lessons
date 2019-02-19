public class Main {

    public static void main(String[] args) throws Exception{
        Resource.i = 5;
        Resource resource = new Resource();
        resource.setI(5);
        MyThread myThread = new MyThread();
        myThread.setName("one");
        MyThread myThread2 = new MyThread();
//        myThread.setResource(resource);
//        myThread2.setResource(resource);
        myThread.start();
        myThread2.start();
        myThread.join();
        myThread2.join();
        System.out.println(Resource.i);
    }
}
    class MyThread extends Thread {
        Resource resource;

        public void setResource(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            Resource.changeStaticI();
            new Resource().changeI();
        }
    }

    class Resource {
    static int i;

        public int getI() {
            return i;
        }

        public synchronized void setI(int i) {
            this.i = i;
        }

        public synchronized static void changeStaticI(){
            int i = Resource.i;
            if(Thread.currentThread().getName().equals("one")){
                Thread.yield();
            }

            i++;
            Resource.i = i;
        }

        public synchronized void changeI(){
        int i = Resource.i;
        if(Thread.currentThread().getName().equals("one")){
            Thread.yield();
        }

        i++;
        Resource.i = i;
    }
}

