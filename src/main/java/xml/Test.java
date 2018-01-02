package xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 三种方式读取xml文件
 * @author wsz
 * @date 2018年1月2日
 */
public class Test extends DefaultHandler{

	public static void main(String[] args) throws Exception {
		readXml();
		readXml2();
		readXml3();
	}
	
	/**
	 * 第一种DOM方式
	 * w3cdom包
	 * @throws Exception
	 */
	private static void readXml() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new File("params.xml"));
		NodeList list = doc.getElementsByTagName("value");
		for (int i = 0; i < list.getLength(); i++) {
			String year  = doc.getElementsByTagName("year").item(i).getFirstChild().getNodeValue();
			String month = doc.getElementsByTagName("month").item(i).getFirstChild().getNodeValue();
			String day   = doc.getElementsByTagName("day").item(i).getFirstChild().getNodeValue();
			System.out.println(year+"-"+month+"-"+day);
		}
	}

	/**
	 * 第2种DOM4J方式
	 * 需要引入domj包
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static void readXml2() throws Exception {
		SAXReader reader       = new SAXReader(); 
		org.dom4j.Document doc = reader.read(new File("params.xml"));
		Element root = doc.getRootElement();
		Element e    = null;
		for (Iterator<Element> i= root.elementIterator("value") ; i.hasNext() ; ) {
			e = (Element) i.next();
			String year  = e.elementText("year");
			String month = e.elementText("month");
			String day   = e.elementText("day");
			System.out.println(year+"-"+month+"-"+day);
		}
	}
	
	/**
	 * 第3种JDOM方式
	 * 需要引入jdom包
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static void readXml3() throws Exception {
		SAXBuilder builder = new SAXBuilder();   
		org.jdom.Document doc = builder.build(new File("params.xml"));
		org.jdom.Element  e   = doc.getRootElement();   
		List<org.jdom.Element> allChildren  = e.getChildren();   
		for (org.jdom.Element el : allChildren) {
			String year  = el.getChild("year").getText();
			String month = el.getChild("month").getText();
			String day   = el.getChild("day").getText();
			System.out.println(year+"-"+month+"-"+day);
		}
	}
	
}
