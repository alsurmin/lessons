import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) throws TransformerException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("root");
        Element font = document.createElement("font");
        Text text = document.createTextNode("TimesNewRoman");
        document.appendChild(root);
        root.appendChild(font);
        font.appendChild(text);
        font.setAttribute("size", "20");

//        Transformer t = TransformerFactory.newInstance().newTransformer();
//        t.setOutputProperty(OutputKeys.INDENT, "yes");
//        t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("temp.xml")));

        DOMImplementation impl = document.getImplementation();
        DOMImplementationLS implLS = (DOMImplementationLS)impl.getFeature("LS", "3.0");
        LSSerializer ser = implLS.createLSSerializer();
        ser.getDomConfig().setParameter("format-pretty-print", true);
        String str = ser.writeToString(document);
//        System.out.println(str);
        LSOutput output = implLS.createLSOutput();
        output.setEncoding("UTF-8");
        output.setByteStream(Files.newOutputStream(Paths.get("temp1.xml")));
        ser.write(document, output);

    }
}
