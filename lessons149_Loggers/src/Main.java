import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class Main {

//    private static final Logger logger = Logger.getGlobal();
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
//        LogManager.getLogManager().readConfiguration();
//        System.out.println(System.getProperty("jre/lib/logging.properties"));
//        logger.log(Level.FINER, "finer");
//        logger.log(Level.INFO, "info");
//        logger.log(Level.WARNING,"warning", new Throwable());

        Handler handler = new FileHandler("%h/myapp.log");
//        Handler handler1 = new StreamHandler();
//        Handler handler2 = new SocketHandler();
        Handler handler3 = new ConsoleHandler();
        handler.setFilter(new MyFilter());
        handler.setFormatter(new MyFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);
        logger.info("info");
        logger.info("info alex");

    }

    static class MyFilter implements Filter {
        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("alex");
        }
    }

    static class MyFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() +": "+ record.getMessage();
        }
    }

}
