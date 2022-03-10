import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
    JPanel game;
    JLabel level;
    String levelText;
    public static JButton quit, title;
    
	public BackgroundPanel() {
		setLayout(null);
		levelText = "Level " + String.valueOf(GamePanel.level);
		level = new JLabel(levelText, JLabel.CENTER);
		level.setFont(new Font("Garamond", Font.PLAIN, 30));
		level.setBounds(380,10,200,30);
		add(level);
		
		quit = new JButton("Quit");
		title = new JButton("Title Screen");
		
		quit.setBounds(10, 10, 100, 30);
		title.setBounds(120, 10, 120, 30);
		
		add(quit);
		add(title);
	}
}
