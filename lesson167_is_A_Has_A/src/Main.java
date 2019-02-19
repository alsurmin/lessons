import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new FileReader("temp.txt"));
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"));){
//            writer.write("str3");
//            writer.newLine();
//            writer.write("str4");
//        }

//        while (reader.ready()) {
//            System.out.println(reader.readLine());
//        }


//
//        int i = 0;
//        while ((i = reader.read()) != -1) {
//            System.out.print((char)i);
//        }

//        Writer writer;
//        InputStream inputStream;
//        OutputStream outputStream;

//        char[] chars = new char[50];
//        while (reader.read(chars) != -1) {
//            for (int i = 0; i < chars.length; i++) {
//                if (Character.isAlphabetic(chars[i]) || Character.isWhitespace(chars[i])) {
//                    System.out.print(chars[i]);
//                }
//            }
//            System.out.print(chars);
//        }

//        InputStream inputStream = new BufferedInputStream(new FileInputStream("temp.txt"));

//        int i = 0;
//        while ((i = inputStream.read()) != -1) {
//            System.out.println(i);
//        }
//        byte[] bytes = new byte[inputStream.available()];
//        while (inputStream.read(bytes) != -1) {
//            for (byte i = 0; i < bytes.length; i++) {
//                System.out.print(bytes[i]);
//            }
//        }

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("temp.txt"))){
            byte[] bytes = new byte[] {49,10,50};
            outputStream.write(bytes);
        }
    }
}
