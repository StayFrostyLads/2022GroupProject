import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
	public static int level;
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
					"blank", "wall", "wall", "wall", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "wall", "end", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
						"sand", "sand", "sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "character", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
						"sand", "sand", "sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "wall", "sand", "sand", "wall", "wall", "wall",
					"wall", "wall", "wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "wall", "wall", "wall", "wall", "blank", "blank",
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
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" } };
	public static String[][] level2 = {
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
						"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
							"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "wall", "wall", "blank", "blank", "blank", "blank",
						"wall", "wall", "wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "wall", "wall", "sand", "sand", "sand", "wall", "blank", "blank", "blank", "blank",
					"wall", "sand", "sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "wall", "sand", "hardSand", "sand", "sand", "wall", "blank", "blank", "blank", "blank",
						"wall", "sand", "sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "wall", "blank", "blank", "wall", "wall",
							"wall", "sand", "sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "wall", "blank", "blank", "wall", "end",
								"sand", "hardSand", "sand", "sand", "sand", "wall", "wall", "wall" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "wall", "wall", "wall", "wall", "wall",
									"wall", "sand", "sand", "sand", "sand", "sand", "sand", "wall" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
										"sand", "sand", "sand", "sand", "sand", "sand", "sand", "wall" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
											"sand", "sand", "sand", "sand", "sand", "sand", "sand", "wall" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
												"sand", "sand", "sand", "sand", "hardSand", "sand", "sand", "wall" },
			{ "blank", "wall", "character", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "sand",
								"sand", "sand", "sand", "sand", "sand", "wall", "wall", "wall" },
			{ "blank", "wall", "wall", "wall", "blank", "blank", "blank", "blank", "blank", "wall", "wall",
					"wall", "wall", "wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" } };
	public static String[][] level5 = {
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
						"wall", "wall", "wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "wall",
							"wall", "end", "wall", "wall", "wall", "wall", "wall", "blank" },
			{ "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "wall",
						"wall", "sand", "wall", "key", "sand", "money", "wall", "blank" },
			{ "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "wall",
						"wall", "lock", "wall", "sand", "wall", "sand", "wall", "blank" },
			{ "blank", "wall", "sand", "sand", "wall", "wall", "wall", "wall", "wall", "sand", "sand",
						"sand", "hardSand", "hardSand", "hardSand", "sand", "sand", "wall", "blank" },
			{ "blank", "wall", "wall", "hardSand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
							"sand", "sand", "sand", "wall", "wall", "wall", "wall", "blank" },
			{ "blank", "wall", "wall", "hardSand", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
								"wall", "sand", "sand", "wall", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
									"sand", "sand", "sand", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
										"wall", "wall", "sand", "sand", "character", "wall", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "money", "sand", "sand", "sand", "sand", "sand", "sand",
											"sand", "sand", "sand", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
										"wall", "wall", "wall", "wall", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
											"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
							"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" } };
	
	public static String[][] level10 = {
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall" },
			{ "blank", "wall", "wall", "wall", "wall", "wall", "blank", "blank", "blank", "blank", "blank",
					"blank", "wall", "portal", "money", "money", "money", "money", "wall" },
			{ "blank", "wall", "hardSand", "hardSand", "hardSand", "wall", "blank", "blank", "blank", "blank", "blank",
					"blank", "wall", "money", "money", "money", "money", "money", "wall" },
			{ "blank", "wall", "hardSand", "wall", "portal", "wall", "blank", "blank", "blank", "blank", "blank",
					"blank", "wall", "money", "money", "money", "money", "money", "wall" },
			{ "blank", "wall", "hardSand", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "wall", "money", "money", "money", "money", "money", "wall" },
			{ "wall", "wall", "lock", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "key", "wall", "wall", "wall", "wall", "wall", "wall" },
			{ "wall", "end", "sand", "wall", "wall", "wall", "wall", "wall", "sand", "sand", "wall",
					"wall", "sand", "wall", "blank", "blank", "blank", "blank", "blank" },
			{ "wall", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "wall",
					"wall", "sand", "wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "sand",
					"sand", "sand", "wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "sand",
					"hardSand", "sand", "wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "wall",
					"wall", "blank", "blank", "blank", "blank", "blank" },
			{ "wall", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "sand", "wall",
					"blank", "blank", "blank", "blank", "blank", "blank" },
			{ "wall", "character", "hardSand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "wall",
					"blank", "blank", "blank", "blank", "blank", "blank" },
			{ "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "wall", "blank", "blank", "blank", "blank", "blank", "blank" },
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
		setLevel(5);
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
			ImageIcon wall = new ImageIcon("./images/wall.png");
			tile.setIcon(wall);
		} else if (type.equals("sand")) {
			ImageIcon sand = new ImageIcon("./images/sand.jpg");
			tile.setIcon(sand);
		} else if (type.equals("spiral")) {
			ImageIcon quickSand = new ImageIcon("./images/spiral.png");
			tile.setIcon(quickSand);
		} else if (type.equals("end")) {
			ImageIcon end = new ImageIcon("./images/end.png");
			tile.setIcon(end);
		} else if (type.equals("start")) {
			tile.setText("Srt");
		} else if (type.equals("money")) {
			ImageIcon money = new ImageIcon("./images/money.png");
			tile.setIcon(money);
		} else if (type.equals("portal")) {
			ImageIcon portal = new ImageIcon("./images/portal.png");
			tile.setIcon(portal);
		} else if (type.equals("hardSand")) {
			ImageIcon hardSand = new ImageIcon("./images/hardSand.png");
			tile.setIcon(hardSand);
		} else if (type.equals("key")) {
			ImageIcon key = new ImageIcon("./images/key.png");
			tile.setIcon(key);
		} else if (type.equals("blank")) {
			ImageIcon blank = new ImageIcon("./images/blank.png");
			tile.setIcon(blank);
		} else if (type.equals("lock")) {
			ImageIcon lock = new ImageIcon("./images/lock.png");
			tile.setIcon(lock);
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
