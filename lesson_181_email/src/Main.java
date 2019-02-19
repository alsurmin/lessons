import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {

    public static void main(String[] args) throws IOException, MessagingException {
        final Properties properties = new Properties();
        properties.load(new FileInputStream("mail.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("myemail"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("surmin@bk.ru"));
        message.setSubject("hello");
        message.setText("Hi this is my test message");

        Transport tr = mailSession.getTransport();
        tr.connect("alsurmin@gmail.com", "hwabngusurmin87");
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();
    }
}
