package Statistic;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import DAO.CandidateOperationsImpl;
import DAO.InvalidAndInlegalOperations;
import Entity.Candidate;

public class VoteShare {

	CandidateOperationsImpl operator = new CandidateOperationsImpl();
	List<Candidate> tempListOfCandidates = operator.getCandidateList();

	InvalidAndInlegalOperations opr = new InvalidAndInlegalOperations();

	Map<String, Integer> votes = new HashMap<String, Integer>();

	public Map<String, Integer> partyVoteShare() {
		// This part should show party result in int.

		for (Candidate tempCandidate : tempListOfCandidates) {
			if (!votes.containsKey(tempCandidate.getParty())) {
				votes.put(tempCandidate.getParty(), tempCandidate.getCandidateVotes());
			} else {
				votes.put(tempCandidate.getParty(), votes.get(tempCandidate.getParty())+tempCandidate.getCandidateVotes());

			}
		}
		return votes;
	}

	public void creatPdf() {

		try {

			BaseFont font = BaseFont.createFont("arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("d:/ElectionResults2.pdf"));

			document.open();

			for (Candidate tempCandidate : operator.getCandidateList()) {
				document.add(
						new Paragraph(
								"Candidate: " + tempCandidate.getName() + " from party: " + tempCandidate.getParty()
										+ " reached :" + tempCandidate.getCandidateVotes() + " votes",
								new Font(font, 12)));
			}

			for (Map.Entry<String, Integer> entry : votes.entrySet()) {
				document.add(new Paragraph("Party " + entry.getKey() + " reached votes equal to :" + entry.getValue(),
						new Font(font, 12)));
			}

			document.add(
					new Paragraph("Number of vote attempt by person without voting rights " + opr.getInlegalAttemps(),
							new Font(font, 12)));
			document.add(
					new Paragraph("Number of invalid votes is equal to: " + opr.getInvalidVotes(), new Font(font, 12)));

			document.close();

		} catch (Exception t) {
			System.out.println("This is error from PDF creator");
			t.printStackTrace();
		}
	}

}
