import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class WinPanel extends JPanel {
	public static JButton quit, titleB;
	Color brown = new Color(194, 178, 128);
	public WinPanel() {
		setLayout(null);
		Color color = new Color(152, 133, 88);
		setBackground(color);
		URL urlW = DesertOfDoom.class.getResource("/images/you win.png");
		ImageIcon w = new ImageIcon(urlW);
		JLabel title = new JLabel(w);
		title.setBounds(30,180,700,300);
		add(title);
		
		quit = new JButton("Quit");
		titleB = new JButton("Title Screen");
		
		quit.setBounds(140, 20, 100, 30);
		titleB.setBounds(10, 20, 120, 30);
		
		quit.setBackground(brown);
		titleB.setBackground(brown);
		
		quit.setForeground(Color.BLACK);
		titleB.setForeground(Color.BLACK);
		
		quit.setFont(new Font("Garamond", Font.PLAIN, 17));
		titleB.setFont(new Font("Garamond", Font.PLAIN, 17));
		
		quit.setBorder(new LineBorder(Color.BLACK));
		titleB.setBorder(new LineBorder(Color.BLACK));
		
		add(quit);
		add(titleB);
	}
}
