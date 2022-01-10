import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class GamePage extends JPanel {
	int level;
	int[][] level1;
	int[][] level2;
	int[][] level3;
	int[][] level4;
	int[][] level5;
	int[][] level6;
	int[][] level7;
	int[][] level8;
	int[][] level9;
	int[][] level10;
	
	GamePage() {
		level = 1;
		setLayout(new GridLayout(8,8));
		setSize(675,486);
		setLocation(5,70);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel text = new JLabel("Game Goes Here");
		add(text);
		
		// Level Design --> fill each level array with level design, [1][1] corresponds to upper left corner
		// use tile class and just set each array element to corresponding tile
		// level design goes here
	}
	
	public void setLevel(int level) {
		
	}

}
