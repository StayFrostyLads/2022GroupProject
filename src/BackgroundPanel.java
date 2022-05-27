import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
    JPanel game;
    static JLabel level;
	static JLabel point;
    static String levelText;
    public static JButton quit, title;
    public static int points;
    
	public BackgroundPanel() {
		setLayout(null);
		points = 0;
		levelText = "Level: ";
		level = new JLabel(levelText, JLabel.CENTER);
		level.setFont(new Font("Garamond", Font.PLAIN, 30));
		level.setBounds(380,10,200,30);
		point = new JLabel("Score: " + points);
		point.setFont(new Font("Garamond", Font.PLAIN, 30));
		point.setBounds(600,10,200,30);
		add(level);
		add(point);
		
		quit = new JButton("Quit");
		title = new JButton("Title Screen");
		
		quit.setBounds(10, 10, 100, 30);
		title.setBounds(120, 10, 120, 30);
		
		add(quit);
		add(title);
	}
	
	public static void updateVariables() {
		point.setText("Score: " + points);

	}
	
}
