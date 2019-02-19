import java.io.*;

public class Main {

    static class MyClass implements AutoCloseable {
        @Override
        public void close()  {

        }
    }

    public static void main(String[] args)  {

        try (MyClass myClass = new MyClass()) {
        }
    }
}
