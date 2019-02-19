import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        Properties defaultProperties = new Properties();
        defaultProperties.setProperty("one1", "my default");

        Properties properties = new Properties(defaultProperties);
//        properties.setProperty("one","1");
//        System.out.println(properties.getProperty("one"));
//
//        FileOutputStream out = new FileOutputStream("my.properties");
//        properties.store(out, "my comments");
        FileInputStream in = new FileInputStream("my.properties");
        properties.load(in);
        System.out.println(properties.getProperty("one1"));


    }
}
