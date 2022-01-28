package panel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {
	public static int level;
	public static String[][] level1, level2, level3, level4, level5, level6, level7, level8, level9, level10;
	
	GamePanel() {
		level = 1;
		setLayout(new GridLayout(15,19)); 
		setSize(762,602);
		setLocation(5,70);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		
	}
	
	
	public void setLevel(int level) {
		
	}
	
	private JLabel createBlock(String type) {
		JLabel tile = new JLabel();
		if (type.equals("wall")) {
			
		} else if (type.equals("sand")) {
			ImageIcon sand = new ImageIcon("./images/sand.png");
			tile.setIcon(sand);
		} else if (type.equals("quick sand")) {
			ImageIcon quickSand = new ImageIcon("./images/spiral.png");
			tile.setIcon(quickSand);
		} else if (type.equals("end point")) {
			
		} else if (type.equals("start point")) {
			
		}  else if (type.equals("money")) {
			
		} else if (type.equals("portal")) {
			
		} else if (type.equals("hard sand")) {
			ImageIcon hardSand = new ImageIcon("./images/sand brick.png");
			tile.setIcon(hardSand);
		} else if (type.equals("key")) {
			ImageIcon key = new ImageIcon("./images/key.png");
			tile.setIcon(key);
		} else if (type.equals("blank")) {

		} else {
			tile.setText("Failure");
		}
		
		return tile;
	}

}
