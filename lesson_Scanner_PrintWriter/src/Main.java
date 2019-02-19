import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new FileReader("temp.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }
        try(PrintWriter writer = new PrintWriter(new FileWriter("temp.txt"))) {
            writer.write("124124");
            writer.write("\n");
            writer.write("qwetsgs");
        }
//        Scanner scanner1 = new Scanner(new FileInputStream("temp.txt"));
//        PrintWriter printWriter = new PrintWriter(new FileOutputStream("temp.txt"));


    }
}
