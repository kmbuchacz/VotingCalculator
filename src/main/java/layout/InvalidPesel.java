package layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InvalidPesel extends JFrame implements ActionListener {
	JFrame frame = new JFrame("You have alreade gave your vote");
	public InvalidPesel() {

		JPanel loginPanel = new JPanel();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		GridBagConstraints b = new GridBagConstraints();
		loginPanel.setLayout(new GridBagLayout());
		
		
		JLabel notification = new JLabel("Your pesel should contain only numbers. It also have to be 11 digits long");
		b.gridx=1;
		b.gridy=2;
		loginPanel.add(notification, b);
		
		b= new GridBagConstraints();
		JButton back = new JButton("back");
		b.gridx=1;
		b.gridy=3;
		back.addActionListener(this);

		
		
		loginPanel.add(back,b);

		

		frame.add(loginPanel);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent a) {
		if (a.getActionCommand().equals("back")) {
			frame.dispose();
			new MainWindow();

		}

	}

}
