package Layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

import DAO.CandidateOperations;
import DAO.InvalidAndInlegalOperations;
import Entity.Candidate;
import Statistic.VoteShare;

public class ElectionResults extends JFrame implements ActionListener {
	JFrame frame = new JFrame("Welcome to 2018 elections. This is voting side");
	VoteShare operator = new VoteShare();
	List<Candidate> candidate = new ArrayList<Candidate>();
	CandidateOperations candidateOperator = new CandidateOperations();
	int i = 1;
	InvalidAndInlegalOperations invalidVotesOperator = new InvalidAndInlegalOperations();


	public ElectionResults() {

		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		GridBagConstraints b = new GridBagConstraints();

		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new GridBagLayout());

		// lables

		for (Map.Entry<String, Integer> entry : operator.partyVoteShare().entrySet()) {
			
			JLabel party = new JLabel("General result for party "+entry.getKey()+" is : " + entry.getValue());
			b = new GridBagConstraints();
			i++;
			b.gridx = 1;
			b.gridy = 0+i;
			b.insets = new Insets(0, 75, 0, 0);

			loginPanel.add(party, b);
	
		}
		
		for (Candidate tempCandidate : candidateOperator.getCandidateList()) {

			b = new GridBagConstraints();
			JLabel candidateLabel = new JLabel("Candidate: " + tempCandidate.getName() + " from party: "
					+ tempCandidate.getParty() + " reached :" + tempCandidate.getCandidateVotes() + " votes");
			i++;
			b.gridx = 1;
			b.gridy = 4 + i;
			b.insets = new Insets(5, 10, 5, 5);
			loginPanel.add(candidateLabel, b);

		}
		
		JLabel invalidvotes = new JLabel(
				"Number of invalid votes is equal to: " + invalidVotesOperator.getInvalidVotes()+
				" Number of votes attempt by person without voting rights " + invalidVotesOperator.getInlegalAttemps());
		b = new GridBagConstraints();
		b.gridx = 1;
		b.gridy = 28;
		b.insets = new Insets(0, 50, 10, 0);
		loginPanel.add(invalidvotes, b);
		
		b = new GridBagConstraints();
		JButton createPDF = new JButton("Click here to creat PDF with results on your hard drive");
		b.gridx = 1;
		b.gridy = 29;
		b.insets = new Insets(50, 50, 50, 0);
		loginPanel.add(createPDF, b);
		createPDF.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Monit();
				operator.creatPdf();
				
				
				
			}
		});
		

		b = new GridBagConstraints();
		JButton back = new JButton("Back to login site");
		b.gridx = 1;
		b.gridy = 30;
		b.insets = new Insets(0, 50, 0, 0);
		loginPanel.add(back, b);
		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MainWindow();
			}
		});

		frame.add(loginPanel);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent u) {

	}

}
