package XMLParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ReadXML {

	public static List<String> read () {
				
		List <String> blocked = new ArrayList <String>();
		SAXBuilder builder = new SAXBuilder();
				
				try {
					Document readDoc = builder.build(new File ("./src/main/java/blocked.xml"));
					
					Element root = readDoc.getRootElement();
					for ( Element tempElement  : root.getChildren("person")){
						blocked.add(tempElement.getChildText("pesel"));
					}
					
					
				} catch (JDOMException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		return blocked;
	}

}
