import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Path path;
        Files files;

        path = Paths.get("new.txt");

//        File file = new File("new.txt");
//        path = file.toPath();

//        System.out.println(path.getFileName());
//        System.out.println(path.getParent());
//        System.out.println(path.getRoot());

//        Files.copy(Paths.get("new.txt"), Paths.get("new2.txt"), StandardCopyOption.REPLACE_EXISTING);
//        Files.move(Paths.get("new2.txt"), Paths.get("new3.txt"), StandardCopyOption.REPLACE_EXISTING);
//        Files.deleteIfExists(Paths.get("new3.txt"));

        //System.out.println(Files.size(Paths.get("new.txt")));

//        System.out.println(Files.getAttribute(path, "size", LinkOption.NOFOLLOW_LINKS));

//        BasicFileAttributes basicFileAttributes = Files.readAttributes(path,BasicFileAttributes.class,LinkOption.NOFOLLOW_LINKS);
//        PosixFileAttributes posixFileAttributes = Files.readAttributes(path, PosixFileAttributes.class, LinkOption.NOFOLLOW_LINKS);

//        byte[] bytes = Files.readAllBytes(path);
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.println(bytes[i]);
//        }

//        Files.write(path,"bla\nnew str".getBytes());

//       List<String> list = Files.readAllLines(Paths.get("new.txt"));
//       for (String s : list) {
//           System.out.println(s);
//       }



//        Files.write(path,"bla\nhaha".getBytes());
//        Files.write(path,"bla\nhaha".getBytes(), StandardOpenOption.APPEND);

//        List<String> list1 = new ArrayList<>();
//        list1.add("new");
//        list1.add("bla");
//        Files.write(path,list1);

//        InputStream inputStream = Files.newInputStream(path);
//        OutputStream outputStream = Files.newOutputStream(path);
//        Reader reader = Files.newBufferedReader(path);
//        Writer writer = Files.newBufferedWriter(path);

//        try (DirectoryStream <Path> entires = Files.newDirectoryStream(Paths.get("."))){
//            for (Path path1 : entires) {
//                System.out.println(path1.getFileName());
//            }
//        }

//        Files.walkFileTree(Paths.get("."), new HashSet<FileVisitOption>(), 1, new MyFileVisitor());

        Files.walkFileTree(Paths.get("."), new MyFileVisitor());


    }
}

class MyFileVisitor extends SimpleFileVisitor <Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }
}
