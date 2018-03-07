package JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Entity.Candidate;

//This class is providing data from  external links. 

public class JsonReader {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static List<Candidate> candidateDistributor() throws IOException, JSONException {
		
		JSONObject json = readJsonFromUrl("http://webtask.future-processing.com:8069/candidates");
		System.out.println(json.toString());

		System.out.println("------->file content<----------");

		JSONObject candidatesMainList = json.getJSONObject("candidates");
		JSONArray candidateSublist = candidatesMainList.getJSONArray("candidate");
		List<Candidate> candidateList = new ArrayList<Candidate>();
		for (int t = 0; t < candidateSublist.length(); t++) {
			JSONObject candidateITSELF = candidateSublist.getJSONObject(t);
			Candidate tempCandidate = new Candidate();

			tempCandidate.setName(candidateITSELF.getString("name"));
			tempCandidate.setParty(candidateITSELF.getString("party"));
			candidateList.add(tempCandidate);

		}
		return candidateList;
	}

	public static List<String> blockedListDistributor() throws IOException, JSONException {

		JSONObject json = readJsonFromUrl("http://webtask.future-processing.com:8069/blocked");
		System.out.println(json.toString());

		System.out.println("------->file content<----------");

		JSONObject disallowedVoters = json.getJSONObject("disallowed");
		JSONArray personVoter = disallowedVoters.getJSONArray("person");
		List<String> baned = new ArrayList<String>();
		for (int t = 0; t < personVoter.length(); t++) {
			JSONObject bannedPesel = personVoter.getJSONObject(t);

			System.out.println(bannedPesel.getString("pesel"));
			baned.add(bannedPesel.getString("pesel"));

		}

		return baned;
	}

}
