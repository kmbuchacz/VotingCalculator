package layout;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroductionPage extends JFrame {

	// This page is pointing out most important features of application.

	JFrame frame = new JFrame("Introduction Page");
	String[] featuresList = { 
			"- each user can vote only once - program is connected to database by Hibernate",
			"- each pesel is stored in secured hased form in database", "- voting by people below 18 years is blocked",
			"- each user need to pass pesel in proper format to vote - few validators checks length and syntax of pesel",
			"- after each vote aplication update data and shows election results",
			"- aplication allows to export results to external pdf file",
			"- application can be started on one computer as few seperate instances simultaneously",
			"- all person who log out befor voting don't lose thier chance to vote - it is possible to login multiple times",
			"- vote for none or more then one candidate is counted as invalid",
			"- pesels without voiting rights are blocked - list of blocked pesels is pulled from outsource XML file.",};

	public IntroductionPage() {

		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		JPanel login = new JPanel();
		login.setLayout(new GridBagLayout());
		GridBagConstraints b = new GridBagConstraints();
		
		b = new GridBagConstraints();
		JLabel title = new JLabel(" This is simple voting calculator. Short description is placed below");
		title.setForeground(Color.BLUE);
		b.gridx = 1;
		b.gridy = 3;
		b.insets = new Insets(0, 0, 0, 0);
		login.add(title, b);

		b = new GridBagConstraints();
		JLabel descriptor = new JLabel("Calculator features :  ");
		descriptor.setForeground(Color.BLUE);
		b.gridx = 1;
		b.gridy = 4;
		b.insets = new Insets(25, 0, 0, 0);
		login.add(descriptor, b);

		for ( int i = 0; i< featuresList.length; i++) {
			b= new GridBagConstraints();
			JLabel feature = new JLabel( featuresList[i]);
			b.gridx=1;
			b.gridy=5+i;
			b.insets = new Insets(10, 10, 10, 10);
			login.add(feature,b);
		}
			
			
		
		b = new GridBagConstraints();
		JButton next = new JButton("Go to application");
		b.gridx = 1;
		b.gridy = 30;
		b.insets = new Insets(30, 30, 30, 30);
		next.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MainWindow();
			}
		});
		login.add(next, b);
		
		frame.setVisible(true);
		frame.add(login);

	}

}
