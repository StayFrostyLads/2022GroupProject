package panel;

import main.Character;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
	public static int level;
	public static String[][] level2, level3, level4, level5, level6, level7, level8, level9, level10;
	public static JLabel character;
	public static String[][] currentLevel;
	boolean play;

	// Level example from thin ice level 1 --> for testing as no levels made yet
	public static String[][] level1 = {
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "end", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "start", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" } };

	GamePanel() {
		level = 1;
		character = new Character(0, 0);
		character.setIcon(new ImageIcon("./images/character.png"));
		setLayout(new GridLayout(15, 19));
		setSize(762, 602);
		setLocation(5, 70);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		setLevel(1);
		initializeLevel();

	}

	public void setLevel(int l) {
		level = l;
	}

	public void initializeLevel() {
		removeAll();

		if (level == 1) {
			currentLevel = level1;
		} else if (level == 2) {
			currentLevel = level2;
		} else if (level == 3) {
			currentLevel = level3;
		} else if (level == 4) {
			currentLevel = level4;
		} else if (level == 5) {
			currentLevel = level5;
		} else if (level == 6) {
			currentLevel = level6;
		} else if (level == 7) {
			currentLevel = level7;
		} else if (level == 8) {
			currentLevel = level8;
		} else if (level == 9) {
			currentLevel = level9;
		} else if (level == 10) {
			currentLevel = level10;
		}

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 19; j++) {
				if (currentLevel[i][j].equals("start")) {
					add(character);
				} else {
					add(createBlock(currentLevel[i][j]));
				}
			}

		}
	}

	private JLabel createBlock(String type) {
		JLabel tile = new JLabel();
		if (type.equals("wall")) {
			tile.setText("III");
		} else if (type.equals("sand")) {
			ImageIcon sand = new ImageIcon("./images/sand.jpg");
			tile.setIcon(sand);
		} else if (type.equals("quick sand")) {
			ImageIcon quickSand = new ImageIcon("./images/spiral.png");
			tile.setIcon(quickSand);
		} else if (type.equals("end")) {
			tile.setText("End");
		} else if (type.equals("start")) {
			tile.setText("Start");
		} else if (type.equals("money")) {
			tile.setText("$$$");
		} else if (type.equals("portal")) {
			tile.setText("port");
		} else if (type.equals("hard sand")) {
			ImageIcon hardSand = new ImageIcon("./images/sand brick.png");
			tile.setIcon(hardSand);
		} else if (type.equals("key")) {
			ImageIcon key = new ImageIcon("./images/key.png");
			tile.setIcon(key);
		} else if (type.equals("blank")) {
			tile.setText(".");
		} else {
			tile.setText("Error");
			System.out.println("Error: '" + type + "' block unable to render");
		}

		return tile;
	}

}
