import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class WinPanel extends JPanel {
	public WinPanel() {
		setBackground(Color.ORANGE);
		setLayout(null);
		JLabel title = new JLabel("YOU WIN");
		title.setBounds(160,200,600,200);
		title.setFont(new Font("Garamond", Font.PLAIN, 90));
		add(title);
	}
}

/*
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WinPanel extends JPanel {
	public static JButton home;
	static CardLayout cL = new CardLayout();
	
	public WinPanel() {
		JLabel title = new JLabel("YOU WIN");
		add(title);
		home = new JButton("Return to Title Screen");
		WinPanel.home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(cards, "home");
			}
		});
	}
}
*/
