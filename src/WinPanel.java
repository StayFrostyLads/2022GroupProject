import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinPanel extends JPanel {
	public WinPanel() {
		JLabel title = new JLabel("YOU WIN");
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
