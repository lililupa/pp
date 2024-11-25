
import javax.xml.parsers.DocumentBuilder; // для создания объектов Document
import javax.xml.parsers.DocumentBuilderFactory; // фабрика объектов
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource; // класс представляющий данные в виде DOM
import javax.xml.transform.stream.StreamResult; // класс, опр куда запишем рез преобр
import org.w3c.dom.Document; // интерфейс для представления DOM
import org.w3c.dom.Element; // интерфейс представл эл-т XML
import org.xml.sax.SAXException;
import java.io.File; // +
import java.io.IOException;


public class XmlFileHandler {

    // Чтение XML файла с использованием DOM API
    public static void readXmlFile(String filePath) {
        try {
            // Создаем фабрику и билдер для документа
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Чтение XML файла
            Document document = builder.parse(new File(filePath));

            // Получение корневого элемента
            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            // Пример получения элемента "user"
            Element user = (Element) document.getElementsByTagName("user").item(0);
            String id = user.getAttribute("id");
            String name = user.getElementsByTagName("name").item(0).getTextContent();
            String email = user.getElementsByTagName("email").item(0).getTextContent();

            // Вывод данных
            System.out.println("User ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Запись XML файла с использованием DOM API
    public static void writeXmlFile(String filePath) {
        try {
            // Создаем фабрику и билдер для документа
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Создаем новый документ XML
            Document document = builder.newDocument();

            // Создаем корневой элемент
            Element root = document.createElement("users");
            document.appendChild(root);

            // Создаем элемент user
            Element user = document.createElement("user");
            user.setAttribute("id", "1");
            root.appendChild(user);

            // Вложенные элементы
            Element name = document.createElement("name");
            name.appendChild(document.createTextNode("John Doe"));
            user.appendChild(name);

            Element email = document.createElement("email");
            email.appendChild(document.createTextNode("john.doe@example.com"));
            user.appendChild(email);

            // Настройка трансформации документа в файл
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));

            // Запись в файл
            transformer.transform(source, result);

            System.out.println("XML файл успешно записан!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Пример записи файла
        String outputFilePath = "output.xml";
        writeXmlFile(outputFilePath);

        // Пример чтения файла
        String inputFilePath = "output.xml";
        readXmlFile(inputFilePath);
    }
}
