package Layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.JSONException;

import DAO.CandidateOperationsImpl;
import DAO.ClientOperationsImpl;
import DAO.InvalidAndInlegalOperations;
import Entity.Client;

public class ConfirmationPopup extends JFrame implements ActionListener {
	ClientOperationsImpl clientOperator = new ClientOperationsImpl();
	List<Integer> indexesThatNeedToGoUp = new ArrayList<Integer>();
	JFrame frame = new JFrame("Confirm your choose");
	Client tempClient = new Client();

	public ConfirmationPopup(List<Integer> indexesThatNeedToGoUp, Client tempClient) {

		this.tempClient = tempClient;
		this.indexesThatNeedToGoUp = indexesThatNeedToGoUp;

		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600, 600);

		GridBagConstraints a = new GridBagConstraints();
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new GridBagLayout());

		JLabel question = new JLabel("Are you sure ?");
		a.gridx = 2;
		a.gridy = 5;
		a.insets = new Insets(0, 0, 50, 0);
		loginPanel.add(question, a);

		a = new GridBagConstraints();
		JButton yes = new JButton("Yes");
		a.gridx = 1;
		a.gridy = 10;
		yes.addActionListener(this);
		a.insets = new Insets(0, 0, 0, 0);
		loginPanel.add(yes, a);

		a = new GridBagConstraints();
		JButton no = new JButton("No");
		a.gridx = 3;
		a.gridy = 10;
		no.addActionListener(this);
		a.insets = new Insets(0, 10, 0, 0);

		loginPanel.add(no, a);

		frame.add(loginPanel);

		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Yes")) {
			System.out.println("bootom yes clicked");

			if (indexesThatNeedToGoUp.size() == 1) {

				CandidateOperationsImpl DBoperation = new CandidateOperationsImpl();
				DBoperation.upDateVotes(indexesThatNeedToGoUp);

				clientOperator.saveClient(tempClient);
				// operator.updatePassedVoteColumn(tempClient);

				frame.dispose();
				new ElectionResults();

			} else {
				InvalidAndInlegalOperations operator = new InvalidAndInlegalOperations();
				operator.saveInvalid();
				clientOperator.saveClient(tempClient);
				System.out.println("Vote invalid");
				frame.dispose();
				new ElectionResults();
			}

		} else if (e.getActionCommand().equals("No")) {
			System.out.println("bootom no clicked");
			try {
				new VotingSite(tempClient);
			} catch (JSONException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			frame.dispose();
		}

	}

}
