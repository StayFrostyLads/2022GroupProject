import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BackgroundPanel extends JPanel {
    JPanel game;
    static JLabel level;
	static JLabel point;
    static String levelText;
    public static JButton quit, title;
    public static int points;
    
	public BackgroundPanel() {
		setLayout(null);
		Color brown = new Color(194, 178, 128);
		Color color = new Color(152, 133, 88);
		setBackground(color);
		points = 0;
		levelText = "Level: ";
		level = new JLabel(levelText, JLabel.CENTER);
		level.setForeground(Color.BLACK);
		level.setFont(new Font("Garamond", Font.PLAIN, 30));
		level.setBounds(280,20,200,30);
		point = new JLabel("Score: " + points);
		point.setFont(new Font("Garamond", Font.PLAIN, 30));
		point.setBounds(500,20,200,30);
		point.setForeground(Color.BLACK);
		add(level);
		add(point);
		
		quit = new JButton("Quit");
		title = new JButton("Title Screen");
		
		quit.setBounds(140, 20, 100, 30);
		title.setBounds(10, 20, 120, 30);
		
		quit.setBackground(brown);
		title.setBackground(brown);
		
		quit.setForeground(Color.BLACK);
		title.setForeground(Color.BLACK);
		
		quit.setFont(new Font("Garamond", Font.PLAIN, 17));
		title.setFont(new Font("Garamond", Font.PLAIN, 17));
		
		quit.setBorder(new LineBorder(Color.BLACK));
		title.setBorder(new LineBorder(Color.BLACK));
		
		add(quit);
		add(title);
	}
	
	public static void updateVariables() {
		point.setText("Score: " + points);

	}
	
}
