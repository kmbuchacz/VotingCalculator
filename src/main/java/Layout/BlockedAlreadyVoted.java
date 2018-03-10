package Layout;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlockedAlreadyVoted extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame("You have already gave your vote");

	public BlockedAlreadyVoted() {
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600, 600);

		JLabel notification = new JLabel("You have already gave your vote! Thank you!");
		JButton back = new JButton("back");
		back.addActionListener(this);

		JPanel loginPanel = new JPanel();
		loginPanel.add(notification);
		loginPanel.add(back);

		loginPanel.setLayout(new GridBagLayout());

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
