package layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONException;
import DAO.ClientOperationsImpl;
import DAO.InvalidAndInlegalOperations;
import entity.Client;
import validator.AgeValidotor;
import validator.BlockedListValidator;
import validator.MultipleClientValidator;

public class MainWindow extends JFrame implements ActionListener {

	ClientOperationsImpl operator = new ClientOperationsImpl();

	MultipleClientValidator operator2 = new MultipleClientValidator();

	Client tempClient = new Client();
	JTextField voterName = new JTextField();
	JTextField voterSurname = new JTextField();
	JTextField voterPesele = new JTextField();
	JFrame frame = new JFrame("Welcome to 2018 elections");

	public MainWindow() {

		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600, 600);

		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new GridBagLayout());
		JLabel header = new JLabel("Welcome to this year election! ");
		JLabel note = new JLabel("Please enter your credentials");

		JLabel textVoterName = new JLabel("Name: ");
		JLabel textVoterSurname = new JLabel("Surname: ");
		JLabel textVoterPesel = new JLabel("Pesel: ");
		JButton submit = new JButton("Submit");
		GridBagConstraints a = new GridBagConstraints();

		a = new GridBagConstraints();
		a.gridx = 1;
		a.gridy = 1;
		loginPanel.add(header, a);

		a = new GridBagConstraints();
		a.gridx = 1;
		a.gridy = 2;
		loginPanel.add(note, a);

		a = new GridBagConstraints();
		a.gridx = 1;
		a.gridy = 4;
		a.ipadx = 250;
		a.insets = new Insets(15, 0, 10, 0);
		loginPanel.add(voterName, a);

		a = new GridBagConstraints();
		a.gridx = 0;
		a.gridy = 4;
		a.insets = new Insets(0, 0, 0, 0);
		loginPanel.add(textVoterName, a);

		a = new GridBagConstraints();

		a.gridx = 1;
		a.gridy = 5;
		a.ipadx = 250;
		a.insets = new Insets(10, 0, 10, 0);
		loginPanel.add(voterSurname, a);

		a = new GridBagConstraints();
		a.gridx = 0;
		a.gridy = 5;
		a.insets = new Insets(0, 0, 0, 0);
		loginPanel.add(textVoterSurname, a);

		a = new GridBagConstraints();

		a.gridx = 1;
		a.gridy = 6;
		a.ipadx = 250;
		a.insets = new Insets(10, 0, 10, 0);
		loginPanel.add(voterPesele, a);

		a = new GridBagConstraints();
		a.gridx = 0;
		a.gridy = 6;
		a.insets = new Insets(0, 0, 0, 0);
		loginPanel.add(textVoterPesel, a);

		a = new GridBagConstraints();
		a.gridx = 1;
		a.gridy = 7;
		submit.addActionListener(this);
		loginPanel.add(submit, a);

		frame.add(loginPanel);

		frame.setVisible(true);
	}

	// Actions

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Submit")) {
			frame.dispose();
			try {
				if (voterName.getText().equals("") || voterSurname.getText().equals("")
						|| voterPesele.getText().equals("")) {
					new InvalidPesel();
				}
				else if (operator2.MulitpleClient(voterPesele.getText())) {
					new BlockedAlreadyVoted();
				}
				else if (!voterPesele.getText().matches("[0-9]+") && voterPesele.getText().length() != 11) {
					System.out.println("Too short pesel or conatin invalid character");
					new InvalidPesel();
					// Here should be few more checks for example checking if Name is different than
					// null.
					// Surname does not contain numbers
				} else if (BlockedListValidator.validateUser(voterPesele.getText())
						|| !AgeValidotor.ageValidator(voterPesele.getText())) {
					frame.dispose();
					InvalidAndInlegalOperations operator = new InvalidAndInlegalOperations();
					operator.saveIllegal();
					new BlockedVoterPrompt();
					System.out.println("This person have no voting rights");
				} else {
					tempClient.setName(voterName.getText());
					tempClient.setSurname(voterSurname.getText());
					tempClient.setPesel(voterPesele.getText());
					tempClient.setPassedVote(1);
					System.out.println("tempclient created");
					frame.dispose();
					new VotingSite(tempClient);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

}
