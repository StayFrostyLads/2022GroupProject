import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class WinPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JButton quit, titleB;
	Color brown = new Color(194, 178, 128);
	
	public static JLabel pointsLabel = new JLabel();
	public static JLabel levelLabel = new JLabel();
	public static JLabel timeLabel = new JLabel();
	
	
	public WinPanel() {
		setLayout(null);
		Color color = new Color(152, 133, 88);
		setBackground(color);
		URL urlW = DesertOfDoom.class.getResource("/images/youWin.png");
		ImageIcon w = new ImageIcon(urlW);
		JLabel title = new JLabel(w);
		title.setBounds(20,50,700,300);
		add(title);
		
		pointsLabel.setBounds(220,280,350,200);
		pointsLabel.setText("Total Points: 000");
		pointsLabel.setFont(new Font("Garamond", Font.PLAIN, 50));
		pointsLabel.setForeground(Color.BLACK);
		add(pointsLabel);
		
		levelLabel.setBounds(200,380,390,200);
		levelLabel.setText("Level Achieved: 0");
		levelLabel.setFont(new Font("Garamond", Font.PLAIN, 50));
		levelLabel.setForeground(Color.BLACK);
		add(levelLabel);
		
		timeLabel.setBounds(170,480,430,200);
		timeLabel.setText("Total Time: 00:00.00");
		timeLabel.setFont(new Font("Garamond", Font.PLAIN, 50));
		timeLabel.setForeground(Color.BLACK);
		add(timeLabel);
		
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