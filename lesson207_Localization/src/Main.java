import java.io.UnsupportedEncodingException;
import java.nio.charset.CharsetDecoder;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        ResourceBundle bundleDefault = ResourceBundle.getBundle("resources");
//        ResourceBundle bundleDefaultEn = ResourceBundle.getBundle("resources", new Locale("en", "US"));
//        ResourceBundle bundleDefaultDe = ResourceBundle.getBundle("resources", new Locale("de", "GR"));
//        ResourceBundle bundleDefaultFr = ResourceBundle.getBundle("resources", new Locale("fr"));
//
//        System.out.println(new String(bundleDefault.getString("somevalue").getBytes("ISO-8859-1"),"windows-1251"));
//        System.out.println(bundleDefaultEn.getString("somevalue"));
//        System.out.println(bundleDefaultDe.getString("somevalue"));
//        System.out.println(bundleDefaultFr.getString("somevalue"));

        ResourceBundle bundleDefault = ResourceBundle.getBundle("resources.resource");
        ResourceBundle bundleDefaultEn = ResourceBundle.getBundle("resources.resource", new Locale("en", "US"));
        ResourceBundle bundleDefaultDe = ResourceBundle.getBundle("resources.resource", new Locale("de", "GR"));
        ResourceBundle bundleDefaultFr = ResourceBundle.getBundle("resources.resource", new Locale("fr"));

        System.out.println(bundleDefault.getString("somevalue"));
        System.out.println(bundleDefaultEn.getString("somevalue"));
        System.out.println(bundleDefaultDe.getString("somevalue"));
        System.out.println(bundleDefaultFr.getString("somevalue"));

    }
}
