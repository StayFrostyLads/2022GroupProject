package panel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
    JPanel game;
    JLabel level;
    String levelText;
    public static JButton quit, title;
    int x;
    
	public BackgroundPanel() {
		setLayout(null);
		game = new GamePanel();
		add(game);
		x = 1;
		levelText = "Level " + String.valueOf(x);
		level = new JLabel(levelText);
		level.setBounds(300,10,200,30);
		add(level);
		
		quit = new JButton("Quit");
		title = new JButton("Title Screen");
		
		quit.setBounds(10, 10, 100, 30);
		title.setBounds(120, 10, 120, 30);
		
		add(quit);
		add(title);
	}
}
