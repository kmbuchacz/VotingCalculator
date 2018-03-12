package layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Monit extends JFrame {

	JFrame frame = new JFrame();
	JPanel loginPanel = new JPanel();

	public Monit () {
		
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		loginPanel.setLayout(new GridBagLayout());
		GridBagConstraints b = new GridBagConstraints();
		
		JLabel textMonit = new JLabel("PDF was created in localization D://Election Results");
		b.gridx=1;
		b.gridy= 3;
		loginPanel.add(textMonit, b);
		
		
		b= new GridBagConstraints();
		JButton back = new JButton("back");
		b.gridx=1;
		b.gridy=4;
		b.insets = new Insets(20, 0, 0, 0);
		loginPanel.add(back,b);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		
		frame.add(loginPanel);
		frame.setVisible(true);
	}
	
	

	
}
