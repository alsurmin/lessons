import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {
    static long numOfOperations = 10_000_000_000L;
    static int numOfThreads = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) {
//        System.out.println(numOfThreads);
        System.out.println(new Date());
        ForkJoinPool pool = new ForkJoinPool(numOfThreads);
        System.out.println(pool.invoke(new MyFork(0, numOfOperations)));
        System.out.println(new Date());
    }
    static class MyFork extends RecursiveTask<Long> {

        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if (to - from <= numOfOperations/numOfThreads) {
                long j = 0;
                System.out.println();
                for (long i = from; i < to; i++) {
                    j += i;
                }
                System.out.println(this+" От "+from+" до "+to+" j = "+j+" и "+(to - from)+" <= "+numOfOperations/numOfThreads);
                return j;
            } else {
                long middle = (to + from)/2;
                MyFork firstHalf = new MyFork(from, middle);
                System.out.println(this+" from = "+from+" и middle = "+ middle);
                firstHalf.fork();

                MyFork secondHalf = new MyFork(middle+1, to);
                System.out.println(this+" middle+1 = "+middle+1+" и to = "+ to);
                long secondValue = secondHalf.compute();
                System.out.println(firstHalf.join() +" + "+ secondValue);
                return firstHalf.join() + secondValue;
            }
        }
    }
}
