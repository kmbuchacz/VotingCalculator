package XMLParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import Entity.Candidate;

public class ReadXML {

	public static List<String> read() {

		List<String> blocked = new ArrayList<String>();
		SAXBuilder builder = new SAXBuilder();
		try {
			Document readDoc = builder.build(new File("./src/main/java/blocked.xml"));
			Element root = readDoc.getRootElement();
			for (Element tempElement : root.getChildren("person")) {
				blocked.add(tempElement.getChildText("pesel"));
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return blocked;
	}

	public static List<Candidate> readCandidate() {

		List<Candidate> candidateList = new ArrayList<Candidate>();
		SAXBuilder builder = new SAXBuilder();
		try {
			Document readDoc = builder.build(new File("./src/main/java/candidates.xml"));
			Element root = readDoc.getRootElement();
			for (Element tempElement : root.getChildren("candidate")) {
				Candidate tempCandidate = new Candidate();
				tempCandidate.setName(tempElement.getChildText("name"));
				tempCandidate.setParty(tempElement.getChildText("party"));
				candidateList.add(tempCandidate);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return candidateList;
	}
}
