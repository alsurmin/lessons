import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getGlobal();
    public static void main(String[] args) throws FileNotFoundException {
        method();
        new Date().getDate();
    }

    private static void method() throws FileNotFoundException {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //save to file;
            }
        });
    }
}
