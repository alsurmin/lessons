import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // towel.blinkenlights.nl:23
        try (Socket socket = new Socket()){
//            socket.connect(new InetSocketAddress("towel.blinkenlights.nl",23), 2000);
            socket.connect(new InetSocketAddress("localhost",8190), 2000);
            Scanner scanner = new Scanner(socket.getInputStream());
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }
    }
}
