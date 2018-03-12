package layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import DAO.CandidateOperations;
import DAO.InvalidAndInlegalOperations;
import entity.Candidate;
import statistic.VoteShare;

public class BlockedVoterPrompt extends JFrame {

	CandidateOperations candidateOperator = new CandidateOperations();
	InvalidAndInlegalOperations invalidVotesOperator = new InvalidAndInlegalOperations();
	VoteShare operator = new VoteShare();
	JFrame frame = new JFrame("You have no voting right");

	public BlockedVoterPrompt() {
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		GridBagConstraints b = new GridBagConstraints();
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new GridBagLayout());

		JLabel disallowed = new JLabel("Unfortunately you have no voting rights");
		b.gridx = 1;
		b.gridy = 2;
		b.insets = new Insets(50, 0, 50, 0);
		loginPanel.add(disallowed, b);

		b = new GridBagConstraints();
		JLabel information = new JLabel(
				"<html> You are under 18 <br/>or your pesel is blocked and you have lost your voting right</html>");
		b.gridx = 1;
		b.gridy = 3;
		b.insets = new Insets(50, 0, 50, 0);
		loginPanel.add(information, b);

		b = new GridBagConstraints();
		JButton back = new JButton("back");
		b.gridx = 1;
		b.gridy = 35;
		b.insets = new Insets(50, 0, 50, 0);
		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MainWindow();
			}
		});

		loginPanel.add(back, b);

		b = new GridBagConstraints();
		JButton creatPdf = new JButton("click here to create pdf file with election results");
		b.gridx = 1;
		b.gridy = 32;
		b.insets = new Insets(0, 50, 0, 0);
		creatPdf.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {

					VoteShare voteShareOperator = new VoteShare();
					voteShareOperator.creatPdf();

				} catch (Exception t) {
					new MainWindow();
					System.out.println("This is error from PDF creator");
					t.printStackTrace();
				}
			}

		});

		loginPanel.add(creatPdf, b);

		frame.add(loginPanel);
		frame.setVisible(true);

	}

}
