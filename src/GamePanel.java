import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
	public static int level;
	public static String[][] level2, level3, level4, level5, level6, level7, level8, level9, level10;
	public static String[][] currentLevel;
	boolean play;
	Character character;
	String characterOnBlock;
	boolean move = true;

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
					"sand", "sand", "character", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" } };

	GamePanel() {
		level = 1;
		characterOnBlock = "sand";
		setFocusable(true);
		addKeyListener(this);
		setLayout(new GridLayout(15, 19));
		setSize(762, 602);
		setLocation(5, 70);
		setBorder(BorderFactory.createLineBorder(Color.black));
		character = new Character();
		setLevel(1);
		initializeLevel();

	}

	public void setLevel(int l) {
		level = l;
	}

	public void updateCurrentLevel(String directionMoved) {
		removeAll();
		if (directionMoved.equals("right")) {
			currentLevel[Character.posY][Character.posX] = "character";
			currentLevel[Character.posY][Character.posX - 1] = characterOnBlock;
			characterOnBlock = level1[Character.posY][Character.posX+1];
			System.out.println(characterOnBlock);
			if (characterOnBlock.equals("sand")) {
				currentLevel[Character.posY][Character.posX - 1] = "quick sand";
			}
		} else if (directionMoved.equals("left")) {
			currentLevel[Character.posY][Character.posX] = "character";
			currentLevel[Character.posY][Character.posX + 1] = characterOnBlock;
			characterOnBlock = level1[Character.posY][Character.posX-1];
			System.out.println(characterOnBlock);
			if (characterOnBlock.equals("sand")) {
				currentLevel[Character.posY][Character.posX + 1] = "quick sand";
			}
		} else if (directionMoved.equals("up")) {
			currentLevel[Character.posY][Character.posX] = "character";
			currentLevel[Character.posY][Character.posX - 1] = characterOnBlock;
			characterOnBlock = level1[Character.posY+1][Character.posX];
			System.out.println(characterOnBlock);
			if (characterOnBlock.equals("sand")) {
				currentLevel[Character.posY - 1][Character.posX] = "quick sand";
			}
		} else if (directionMoved.equals("down")) {
			currentLevel[Character.posY][Character.posX] = "character";
			currentLevel[Character.posY][Character.posX + 1] = characterOnBlock;
			characterOnBlock = level1[Character.posY-1][Character.posX];
			System.out.println(characterOnBlock);
			if (characterOnBlock.equals("sand")) {
				currentLevel[Character.posY + 1][Character.posX] = "quick sand";
			}
		} else {
			System.out.println("Error: Failed to render level after movement. Character was moving " + directionMoved);
		}

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 19; j++) {
				if (currentLevel[i][j].equals("character")) {
					add(character);
					Character.setPosX(j);
					Character.setPosY(i);
				} else {
					add(createBlock(currentLevel[i][j]));
				}
			}

		}
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
				if (currentLevel[i][j].equals("character")) {
					add(character);
					Character.setPosX(j);
					Character.setPosY(i);
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
			tile.setText("Srt");
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

	public void keyTyped(KeyEvent event) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent event) {
		character.checkSurroundings();
		if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W) {
			if (character.canUp) {
				Character.posY = Character.posY + 1;
				System.out.println(Character.posY);
				this.updateCurrentLevel("up");
			}
		} else if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
			if (character.canDown) {
				Character.posY = Character.posY - 1;
				System.out.println(Character.posY);
				this.updateCurrentLevel("down");
			}
		} else if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
			if (character.canLeft) {
				Character.posX = Character.posX - 1;
				System.out.println(Character.posX);
				this.updateCurrentLevel("left");
			}
		} else if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
			if (character.canRight) {
				Character.posX = Character.posX + 1;
				System.out.println(Character.posX);
				this.updateCurrentLevel("right");
			}
		}
		this.revalidate();
	}

}
