import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.net.URL;

public class TitlePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JButton start, instructions, quit;
	JLabel title;
	
	public TitlePanel() {
		Color brown = new Color(194, 178, 128);
		URL urlT = DesertOfDoom.class.getResource("/images/title.png");
		ImageIcon t = new ImageIcon(urlT);
		JLabel title = new JLabel(t);
		setLayout(null);
		title.setBounds(20,25,750,200);
		add(title);
		
		start = new JButton("Start"); 
		start.setFocusable(false);
		start.setBackground(brown);
		start.setBounds(290,250,200,250);
		start.setFont(new Font("Garamond", Font.PLAIN, 30));
		start.setBorder(new LineBorder(Color.BLACK));
		start.setForeground(Color.BLACK);
		instructions = new JButton("Instructions");
		instructions.setFocusable(false);
		instructions.setForeground(Color.BLACK);
		instructions.setBackground(brown);
		instructions.setBounds(40,250,200,250);
		instructions.setFont(new Font("Garamond", Font.PLAIN, 30));
		instructions.setBorder(new LineBorder(Color.BLACK));
		quit = new JButton("Quit");
		quit.setFocusable(false);
		quit.setBackground(brown);
		quit.setForeground(Color.BLACK);
		quit.setBorder(new LineBorder(Color.BLACK));
		quit.setBounds(540,250,200,250);
		quit.setFont(new Font("Garamond", Font.PLAIN, 30));
		
		Color color = new Color(152, 133, 88);
		setBackground(color);
		add(start);
		add(quit);
		add(instructions);
		
	}
}