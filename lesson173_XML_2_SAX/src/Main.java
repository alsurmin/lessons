import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.soap.Text;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XMLStreamException {

//        DefaultHandler handler = new DefaultHandler() {
//            @Override
//            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//                String name = attributes.getValue("name");
//                if (name != null && !name.isEmpty()){
//                    System.out.println(name);
//                }
//            }
//
//            @Override
//            public void characters(char[] ch, int start, int length) throws SAXException {
//                String str = "";
//                for (int i = 0; i < length; i++) {
//                    str += ch[start + i];
//                }
//                if (!str.contains("\n")) {
//                    System.out.println(str);
//                }
//            }
//        };
//
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
//        parser.parse(new File("work.xml"),handler);


        XMLInputFactory factory2 = XMLInputFactory.newInstance();
        XMLStreamReader parser2 = factory2.createXMLStreamReader(new FileInputStream("work.xml"));
        while (parser2.hasNext()) {
            int event = parser2.next();
            if (event == XMLStreamReader.START_ELEMENT) {
                System.out.println(parser2.getLocalName());
            }

        }


    }
}
