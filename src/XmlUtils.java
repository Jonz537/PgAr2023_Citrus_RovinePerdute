import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class XmlUtils {

    private static XMLInputFactory xmlIf = null;
    private static XMLStreamReader xmlR = null;
    private static XMLOutputFactory xmlOf = null;
    private static XMLStreamWriter xmlW = null;

    /**
     * Initialize XMLInputFactory and XMLStreamReader
     * @param filename xml file name
     */
    private static void initializeXMLReader(String filename) {
        try {
            xmlIf = XMLInputFactory.newInstance();
            xmlR = xmlIf.createXMLStreamReader(filename, new FileInputStream(filename));
        } catch (Exception e) {
            System.out.println("Error in initializing XML stream reader:\n" + e.getMessage());
        }
    }

    /**
     * Initialize XMLOutputFactory and XMLStreamWriter
     * @param filename save input in this list
     */
    public static ArrayList<City> readMap(String filename) {

        initializeXMLReader(filename);
        ArrayList<City> cities = new ArrayList<>();

        try {
            City city = null;
            while (xmlR.hasNext()) {
                switch (xmlR.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT -> {
                        if (xmlR.getLocalName().equals("city")) {
                            city = new City(Integer.parseInt(xmlR.getAttributeValue(0)),
                                    xmlR.getAttributeValue(1),
                                    new Coordinate(Double.parseDouble(xmlR.getAttributeValue(2)),
                                            Double.parseDouble(xmlR.getAttributeValue(3)),
                                            Double.parseDouble(xmlR.getAttributeValue(4))));
                        } else if (xmlR.getLocalName().equals("link")) {
                            city.addNode(Integer.parseInt(xmlR.getAttributeValue(0)), 0);
                        }
                    }
                    case XMLStreamConstants.END_ELEMENT -> {
                        if (xmlR.getLocalName().equals("city")) {
                            cities.add(city);
                        }
                    }
                    case XMLStreamConstants.START_DOCUMENT -> {
                        System.out.println("Start reading " + filename);
                    }
                    case XMLStreamConstants.END_DOCUMENT -> {
                        System.out.println("End reading " + filename);
                    }
                }
                xmlR.next();
            }
        } catch (XMLStreamException | NoSuchElementException e) {
            System.out.println("Reading error:\n" + e.getMessage());
        }
        return cities;
    }

    /**
     * Initialize XMLOutputFactory and XMLStreamWriter
     * @param filename save input in this list
     */
    private static void initializeWriterFileXml(String filename) {
        try {
            xmlOf = XMLOutputFactory.newInstance();
            xmlW = xmlOf.createXMLStreamWriter(new FileOutputStream(filename), "utf-8");
            xmlW.writeStartDocument("utf-8", "1.0");
        } catch (Exception e) {
            System.out.println("Error\n" + e.getMessage());
            System.out.println("Reading error:\n" + e.getMessage());
        }
    }

    public static void writeMap() {

        String filename = "./Output.xml";

        initializeWriterFileXml(filename);

        try {
            xmlW.writeStartDocument();

            xmlW.writeStartElement("output");

            xmlW.writeAttribute("numero", String.valueOf(3));
            xmlW.writeCharacters("Testo Testoso");

            xmlW.writeEndElement();

            xmlW.writeEndDocument();

            xmlW.flush();
            xmlW.close();

        } catch (XMLStreamException | NoSuchElementException e) {
            System.out.println("Reading error:\n" + e.getMessage());
        }
    }
}
