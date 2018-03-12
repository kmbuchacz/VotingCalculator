package layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.json.JSONException;

import XMLParser.ReadXML;
import entity.Candidate;
import entity.Client;

public class VotingSite extends JFrame {

	public JFrame frame = new JFrame("Welcome to 2018 elections. This is voting side");
	JPanel loginPanel = new JPanel();
	List<JCheckBox> candidateCheckBoxList;
	List<Integer> votes = new ArrayList<Integer>();
	Client tempClient = new Client();
	int i = 0;

	public VotingSite(Client tempClient) throws JSONException, IOException {
		this.tempClient = tempClient;
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		loginPanel.setLayout(new GridBagLayout());
		GridBagConstraints b = new GridBagConstraints();
		candidateCheckBoxList = new ArrayList<JCheckBox>();

		for (Candidate tempCandidate : ReadXML.readCandidate()) {
			JCheckBox candidateCheckBox = new JCheckBox(
					tempCandidate.getName() + " from party " + tempCandidate.getParty());
			candidateCheckBoxList.add(candidateCheckBox);
			b = new GridBagConstraints();
			b.gridx = 2;
			b.gridy = 1 + i;
			loginPanel.add(candidateCheckBox, b);
			i++;
		}
		b = new GridBagConstraints();
		JButton vote = new JButton("VOTE!");
		b.gridx = 2;
		b.gridy = 30;
		b.insets = new Insets(50, 0, 0, 0);

		vote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("VOTE!")) {
					List<Integer> indexesThatNeedToGoUp = new ArrayList<Integer>();
					for (int i = 0; i < 13; i++) {
						JCheckBox item = candidateCheckBoxList.get(i);
						if (item.isSelected()) {
							System.out.println("Item was sellected " + i);
							indexesThatNeedToGoUp.add(i + 1);
						}
					}
					frame.setVisible(false);
					new ConfirmationPopup(indexesThatNeedToGoUp, VotingSite.this.tempClient);
				}
			}
		});
		loginPanel.add(vote, b);
		b = new GridBagConstraints();
		JButton back = new JButton("Back to login site");
		b.gridx = 2;
		b.gridy = 30;
		b.insets = new Insets(0, 0, 15, 0);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MainWindow();
			}
		});
		loginPanel.add(back, b);
		frame.add(loginPanel);
		frame.setVisible(true);
	}

}
