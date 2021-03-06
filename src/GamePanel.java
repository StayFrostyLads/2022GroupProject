import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class GamePanel extends JPanel implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int level = 1;
	public static String[][] currentLevel = new String[15][19];
	public static String[][] hardSandHelperArray = new String[15][19];
	boolean play;
	Character character;
	String characterOnBlock;
	boolean enteredLevel10 = false;

	final String[][] level1 = {
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "wall", "wall", "wall", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"end", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "character", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "wall", "sand", "sand", "wall", "wall", "wall", "wall", "wall",
					"wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "wall", "wall", "wall", "wall", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank" },
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

	final String[][] level2 = {
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "wall", "wall", "blank", "blank", "blank", "blank", "wall",
					"wall", "wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "wall", "wall", "sand", "sand", "sand", "wall", "blank", "blank", "blank", "blank", "wall",
					"sand", "sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "wall", "sand", "hardSand", "sand", "sand", "wall", "blank", "blank", "blank", "blank", "wall",
					"sand", "sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "wall", "blank", "blank", "wall", "wall", "wall", "sand",
					"sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "wall", "blank", "blank", "wall", "end", "sand",
					"hardSand", "sand", "sand", "sand", "wall", "wall", "wall" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "sand",
					"sand", "sand", "sand", "sand", "sand", "wall" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "sand", "sand", "sand", "wall" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "sand", "sand", "sand", "wall" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "hardSand", "sand", "sand", "wall" },
			{ "blank", "wall", "character", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "sand", "sand",
					"sand", "sand", "sand", "sand", "wall", "wall", "wall" },
			{ "blank", "wall", "wall", "wall", "blank", "blank", "blank", "blank", "wall", "wall", "wall", "wall",
					"wall", "wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" } };

	final String[][] level3 = {
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "wall", "wall",
					"wall", "wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "wall", "wall", "wall", "wall", "blank", "blank", "blank", "blank", "blank", "wall", "sand",
					"money", "sand", "money", "sand", "wall", "blank", "blank" },
			{ "blank", "wall", "end", "sand", "wall", "blank", "blank", "blank", "blank", "blank", "wall", "sand",
					"wall", "wall", "wall", "sand", "wall", "blank", "blank" },
			{ "blank", "wall", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "wall",
					"wall", "wall", "sand", "wall", "blank", "blank" },
			{ "wall", "wall", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "sand", "wall", "blank", "blank" },
			{ "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"wall", "wall", "wall", "wall", "blank", "blank" },
			{ "wall", "sand", "sand", "sand", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "sand",
					"wall", "blank", "blank", "blank", "blank", "blank" },
			{ "wall", "sand", "sand", "sand", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "sand",
					"wall", "blank", "blank", "blank", "blank", "blank" },
			{ "wall", "sand", "sand", "sand", "sand", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"wall", "blank", "blank", "blank", "blank", "blank" },
			{ "wall", "sand", "sand", "sand", "sand", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"wall", "wall", "wall", "wall", "blank", "blank" },
			{ "wall", "sand", "sand", "sand", "wall", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "character", "wall", "blank", "blank" },
			{ "wall", "wall", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" } };

	final String[][] level4 = {
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			// 2
			{ "blank", "wall", "wall", "wall", "blank", "blank", "blank", "blank", "wall", "wall", "wall", "wall",
					"wall", "wall", "wall", "blank", "blank", "blank", "blank" },
			// 3
			{ "blank", "wall", "end", "wall", "wall", "wall", "wall", "wall", "wall", "key", "sand", "sand", "sand",
					"sand", "wall", "blank", "blank", "blank", "blank" },
			// 4
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "wall", "wall", "sand", "sand", "sand", "sand",
					"sand", "wall", "blank", "blank", "blank", "blank" },
			// 5
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "wall", "wall", "sand", "sand", "sand", "sand",
					"sand", "wall", "blank", "blank", "blank", "blank" },
			// 6
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "wall", "wall", "sand", "wall", "wall", "wall",
					"sand", "wall", "blank", "blank", "blank", "blank" },
			// 7
			{ "blank", "wall", "wall", "wall", "wall", "wall", "lock", "wall", "wall", "sand", "wall", "wall", "wall",
					"sand", "wall", "blank", "blank", "blank", "blank" },
			// 8
			{ "blank", "wall", "wall", "wall", "wall", "wall", "sand", "wall", "wall", "sand", "money", "sand", "sand",
					"sand", "wall", "blank", "blank", "blank", "blank" },
			// 9
			{ "blank", "wall", "sand", "sand", "sand", "sand", "hardSand", "hardSand", "hardSand", "sand", "sand",
					"sand", "sand", "sand", "wall", "blank", "blank", "blank", "blank" },
			// 10
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "wall", "sand", "sand", "sand", "sand", "sand",
					"sand", "wall", "blank", "blank", "blank", "blank" },
			// 11
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "wall", "sand", "sand", "sand", "sand", "sand",
					"sand", "wall", "blank", "blank", "blank", "blank" },
			// 12
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "wall", "sand", "sand", "sand", "sand", "sand",
					"sand", "wall", "blank", "blank", "blank", "blank" },
			// 13
			{ "blank", "wall", "character", "sand", "sand", "sand", "sand", "wall", "wall", "wall", "wall", "wall",
					"wall", "wall", "wall", "blank", "blank", "blank", "blank" },
			// 14
			{ "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			// 15
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" } };

	final String[][] level5 = {
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "wall", "wall", "end",
					"wall", "wall", "wall", "wall", "wall", "blank" },
			{ "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "wall", "wall", "sand",
					"wall", "key", "sand", "money", "wall", "blank" },
			{ "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "wall", "wall", "lock",
					"wall", "sand", "wall", "sand", "wall", "blank" },
			{ "blank", "wall", "sand", "sand", "wall", "wall", "wall", "wall", "wall", "sand", "sand", "sand",
					"hardSand", "hardSand", "hardSand", "sand", "sand", "wall", "blank" },
			{ "blank", "wall", "wall", "hardSand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "wall", "wall", "wall", "wall", "blank" },
			{ "blank", "wall", "wall", "hardSand", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"sand", "sand", "wall", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "sand",
					"sand", "wall", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"sand", "sand", "character", "wall", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "money", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "wall", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" } };

	final String[][] level6 = {
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "wall", "wall", "wall", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "wall", "portal", "wall", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"wall", "sand", "wall", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "end", "wall", "wall", "wall", "wall", "wall", "blank", "blank", "wall", "wall",
					"sand", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "sand", "sand", "sand", "sand", "wall", "blank", "blank", "wall",
					"sand", "hardSand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "sand", "sand", "wall", "sand", "wall", "blank", "blank", "wall",
					"sand", "sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "wall", "sand", "wall", "sand", "wall", "blank", "blank", "wall",
					"sand", "sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "wall", "sand", "wall", "sand", "wall", "blank", "blank", "wall",
					"sand", "sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "wall", "sand", "sand", "sand", "wall", "wall", "blank", "wall", "sand",
					"sand", "sand", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "wall", "sand", "sand", "sand", "sand", "wall", "wall", "wall", "wall",
					"wall", "wall", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "sand", "sand", "sand", "sand", "hardSand", "money", "wall", "wall",
					"wall", "wall", "character", "sand", "wall", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "wall", "portal", "wall", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "wall", "wall", "wall", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank" } };

	final String[][] level7 = {
			{ "blank", "blank", "blank", "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "wall", "wall", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "wall", "character", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "hardSand", "key", "wall", "blank", "blank" },
			{ "blank", "blank", "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "sand", "wall", "wall", "blank", "blank" },
			{ "blank", "blank", "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"wall", "sand", "wall", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "sand",
					"wall", "sand", "wall", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "sand",
					"wall", "sand", "wall", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "sand",
					"wall", "sand", "wall", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall",
					/* row 8 col 12 */"portal", "sand", "wall", "sand", "wall", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "wall", "lock", "hardSand", /* row 9 col 7 */ "portal", "wall", "wall", "wall",
					"wall", "sand", "money", "wall", "sand", "wall", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "wall", "wall", "hardSand", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "wall", "sand", "wall", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "wall", "end", "hardSand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "hardSand", "wall", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "money", "wall", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "wall", "wall", "wall", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" } };

	final String[][] level8 = {
			{ "blank", "blank", "blank", "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "wall", "portal", "sand", "sand", "sand", "sand", "sand", "sand",
					"wall", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "hardSand",
					"wall", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "sand", "sand", "sand", "sand", "wall", "sand", "wall", "sand", "wall",
					"blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "wall", "wall", "sand", "sand", "wall", "end", "wall", "sand", "wall",
					"blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "wall", "wall", "sand", "sand", "wall", "wall", "wall", "sand", "wall",
					"blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "wall", "wall", "sand", "sand", "wall", "character", "wall", "sand",
					"wall", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "wall", "wall", "sand", "sand", "wall", "sand", "wall", "sand", "wall",
					"blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "wall", "wall", "sand", "sand", "sand", "portal", "sand", "sand",
					"wall", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "wall", "wall", "hardSand", "sand", "sand", "sand", "hardSand", "sand",
					"wall", "wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "wall", "wall", "sand", "sand", "sand", "sand", "sand", "hardSand",
					"hardSand", "wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "sand", "sand", "sand", "sand", "sand", "wall", "wall", "wall", "wall", "wall",
					"wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" } };

	final String[][] level9 = {
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "blank", "wall",
					"wall", "wall", "wall", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "sand", "wall", "wall", "sand", "sand", "sand", "wall", "blank", "wall",
					"sand", "sand", "wall", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "wall", "sand", "wall", "wall", "sand", "sand", "sand", "wall", "blank", "wall",
					"sand", "sand", "wall", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "hardSand", "hardSand", "wall", "wall", "sand", "hardSand", "sand", "wall",
					"wall", "wall", "sand", "sand", "wall", "wall", "wall", "blank" },
			{ "wall", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "sand", "end", "wall", "blank" },
			{ "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "sand", "sand", "wall", "blank" },
			{ "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "sand", "sand", "wall", "blank" },
			{ "wall", "character", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "hardSand",
					"sand", "sand", "sand", "sand", "sand", "wall", "blank" },
			{ "wall", "wall", "sand", "sand", "sand", "hardSand", "hardSand", "sand", "sand", "sand", "sand", "sand",
					"sand", "sand", "sand", "sand", "sand", "wall", "blank" },
			{ "blank", "wall", "wall", "wall", "wall", "sand", "sand", "wall", "wall", "wall", "sand", "sand", "sand",
					"wall", "wall", "wall", "wall", "wall", "blank" },
			{ "blank", "blank", "blank", "blank", "wall", "sand", "sand", "wall", "blank", "wall", "sand", "sand",
					"sand", "wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "wall", "sand", "sand", "wall", "blank", "wall", "sand", "sand",
					"sand", "wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "wall", "wall", "wall", "wall", "blank", "wall", "wall", "wall",
					"wall", "wall", "blank", "blank", "blank", "blank", "blank" }, };

	final String[][] level10 = {
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "wall", "wall", "wall", "wall", "wall", "wall", "wall" },
			{ "blank", "wall", "wall", "wall", "wall", "wall", "blank", "blank", "blank", "blank", "blank", "blank",
					"wall", "portal", "money", "money", "money", "money", "wall" },
			{ "blank", "wall", "hardSand", "hardSand", "hardSand", "wall", "blank", "blank", "blank", "blank", "blank",
					"blank", "wall", "money", "money", "money", "money", "money", "wall" },
			{ "blank", "wall", "hardSand", "wall", "portal", "wall", "blank", "blank", "blank", "blank", "blank",
					"blank", "wall", "money", "money", "money", "money", "money", "wall" },
			{ "blank", "wall", "hardSand", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"wall", "money", "money", "money", "money", "money", "wall" },
			{ "wall", "wall", "hardSand", "lock", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "key",
					"wall", "wall", "wall", "wall", "wall", "wall" },
			{ "wall", "end", "sand", "wall", "wall", "wall", "wall", "wall", "sand", "sand", "wall", "wall", "sand",
					"wall", "blank", "blank", "blank", "blank", "blank" },
			{ "wall", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "wall", "wall", "sand",
					"wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "sand", "sand", "sand",
					"wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "sand", "hardSand",
					"sand", "wall", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "wall", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "wall",
					"wall", "blank", "blank", "blank", "blank", "blank" },
			{ "wall", "wall", "sand", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "sand", "sand", "wall",
					"blank", "blank", "blank", "blank", "blank", "blank" },
			{ "wall", "character", "hardSand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand", "sand",
					"wall", "blank", "blank", "blank", "blank", "blank", "blank" },
			{ "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall",
					"blank", "blank", "blank", "blank", "blank", "blank" },
			{ "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank",
					"blank", "blank", "blank", "blank", "blank", "blank", "blank", "blank" } };

	GamePanel(int l) {
		level = l;
		characterOnBlock = "sand";
		setFocusable(true);
		addKeyListener(this);
		setLayout(new GridLayout(15, 19));
		setSize(762, 602);
		setLocation(5, 70);
		setBorder(BorderFactory.createLineBorder(Color.black));
		character = new Character();
		initializeLevel();
	}

	public String findCharacterOnBlock() {
		String a = "sand";
		if (level == 1) {
			a = level1[Character.posY][Character.posX];
			if (a.equals("hardSand")) {
				a = hardSandHelperArray[Character.posY][Character.posX];
			}
		} else if (level == 2) {
			a = level2[Character.posY][Character.posX];
			if (a.equals("hardSand")) {
				a = hardSandHelperArray[Character.posY][Character.posX];
			}
		} else if (level == 3) {
			a = level3[Character.posY][Character.posX];
			if (a.equals("hardSand")) {
				a = hardSandHelperArray[Character.posY][Character.posX];
			}
		} else if (level == 4) {
			a = level4[Character.posY][Character.posX];
			if (a.equals("hardSand")) {
				a = hardSandHelperArray[Character.posY][Character.posX];
			}
		} else if (level == 5) {
			a = level5[Character.posY][Character.posX];
			if (a.equals("hardSand")) {
				a = hardSandHelperArray[Character.posY][Character.posX];
			}
		} else if (level == 6) {
			a = level6[Character.posY][Character.posX];
			if (a.equals("hardSand")) {
				a = hardSandHelperArray[Character.posY][Character.posX];
			}
		} else if (level == 7) {
			a = level7[Character.posY][Character.posX];
			if (a.equals("hardSand")) {
				a = hardSandHelperArray[Character.posY][Character.posX];
			}
		} else if (level == 8) {
			a = level8[Character.posY][Character.posX];
			if (a.equals("hardSand")) {
				a = hardSandHelperArray[Character.posY][Character.posX];
			}
		} else if (level == 9) {
			a = level9[Character.posY][Character.posX];
			if (a.equals("hardSand")) {
				a = hardSandHelperArray[Character.posY][Character.posX];
			}
		} else if (level == 10) {
			a = level10[Character.posY][Character.posX];
			if (a.equals("hardSand")) {
				a = hardSandHelperArray[Character.posY][Character.posX];
			}
		}
		return a;
	}

	public void updateCurrentLevel(String directionMoved) {
		removeAll();
		BackgroundPanel.updateVariables();
		BackgroundPanel.points++;
		if (directionMoved.equals("right")) {
			currentLevel[Character.posY][Character.posX] = "character";
			if (characterOnBlock.equals("hardSand")) {
				characterOnBlock = "sand";
				hardSandHelperArray[Character.posY][Character.posX - 1] = "sand";
			} else if (characterOnBlock.equals("sand")) {
				characterOnBlock = "quickSand";
			} else if (characterOnBlock.equals("key")) {
				Character.hasKey = true;
				characterOnBlock = "quickSand";
			} else if (characterOnBlock.equals("lock")) {
				characterOnBlock = "quickSand";
			} else if (characterOnBlock.equals("money")) {
				BackgroundPanel.points += 15;
				BackgroundPanel.updateVariables();
				characterOnBlock = "quickSand";
			}
			currentLevel[Character.posY][Character.posX - 1] = characterOnBlock;
			characterOnBlock = findCharacterOnBlock();
			if (characterOnBlock.equals("portal")) {
				portalEvent(level);
			}
			if (characterOnBlock.equals("end")) {
				characterOnBlock = "sand";
				synchronized (DesertOfDoom.waitObject) {
					DesertOfDoom.waitObject.notify();
				}
			}
		} else if (directionMoved.equals("left")) {
			currentLevel[Character.posY][Character.posX] = "character";
			if (characterOnBlock.equals("hardSand")) {
				characterOnBlock = "sand";
				hardSandHelperArray[Character.posY][Character.posX + 1] = "sand";
			} else if (characterOnBlock.equals("sand")) {
				characterOnBlock = "quickSand";
			} else if (characterOnBlock.equals("key")) {
				Character.hasKey = true;
				characterOnBlock = "quickSand";
			} else if (characterOnBlock.equals("lock")) {
				characterOnBlock = "quickSand";
			} else if (characterOnBlock.equals("money")) {
				BackgroundPanel.points += 15;
				BackgroundPanel.updateVariables();
				characterOnBlock = "quickSand";
			}
			currentLevel[Character.posY][Character.posX + 1] = characterOnBlock;
			characterOnBlock = findCharacterOnBlock();
			if (characterOnBlock.equals("portal")) {
				portalEvent(level);
			}
			if (characterOnBlock.equals("end")) {
				characterOnBlock = "quickSand";
				synchronized (DesertOfDoom.waitObject) {
					DesertOfDoom.waitObject.notify();
				}
			}
		} else if (directionMoved.equals("up")) {
			currentLevel[Character.posY][Character.posX] = "character";
			if (characterOnBlock.equals("hardSand")) {
				characterOnBlock = "sand";
				hardSandHelperArray[Character.posY + 1][Character.posX] = "sand";
			} else if (characterOnBlock.equals("sand")) {
				characterOnBlock = "quickSand";
			} else if (characterOnBlock.equals("key")) {
				Character.hasKey = true;
				characterOnBlock = "quickSand";
			} else if (characterOnBlock.equals("lock")) {
				characterOnBlock = "quickSand";
			} else if (characterOnBlock.equals("money")) {
				BackgroundPanel.points += 15;
				BackgroundPanel.updateVariables();
				characterOnBlock = "quickSand";
			}
			currentLevel[Character.posY + 1][Character.posX] = characterOnBlock;
			characterOnBlock = findCharacterOnBlock();
			if (characterOnBlock.equals("portal")) {
				portalEvent(level);
			}
			if (characterOnBlock.equals("end")) {
				characterOnBlock = "sand";
				synchronized (DesertOfDoom.waitObject) {
					DesertOfDoom.waitObject.notify();
				}
			}
		} else if (directionMoved.equals("down")) {
			currentLevel[Character.posY][Character.posX] = "character";
			if (characterOnBlock.equals("hardSand")) {
				characterOnBlock = "sand";
				hardSandHelperArray[Character.posY - 1][Character.posX] = "sand";
			} else if (characterOnBlock.equals("sand")) {
				characterOnBlock = "quickSand";
			} else if (characterOnBlock.equals("key")) {
				Character.hasKey = true;
				characterOnBlock = "quickSand";
			} else if (characterOnBlock.equals("lock")) {
				characterOnBlock = "quickSand";
			} else if (characterOnBlock.equals("money")) {
				BackgroundPanel.points += 15;
				BackgroundPanel.updateVariables();
				characterOnBlock = "quickSand";
			}
			currentLevel[Character.posY - 1][Character.posX] = characterOnBlock;
			characterOnBlock = findCharacterOnBlock();
			if (characterOnBlock.equals("portal")) {
				portalEvent(level);
			}
			if (characterOnBlock.equals("end")) {
				characterOnBlock = "sand";
				synchronized (DesertOfDoom.waitObject) {
					DesertOfDoom.waitObject.notify();
				}
			}
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

//		for (int i = 0; i < 19; i++) {
//			System.out.print(currentLevel[11][i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < 19; i++) {
//			System.out.print(level1[11][i] + " ");
//		}
	}

	public void initializeLevel() {
		removeAll();

		if (level == 1) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					currentLevel[i][j] = level1[i][j];
				}

			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					hardSandHelperArray[i][j] = level1[i][j];
				}

			}
		} else if (level == 2) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					currentLevel[i][j] = level2[i][j];
				}

			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					hardSandHelperArray[i][j] = level2[i][j];
				}

			}
		} else if (level == 3) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					currentLevel[i][j] = level3[i][j];
				}

			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					hardSandHelperArray[i][j] = level3[i][j];
				}

			}
		} else if (level == 4) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					currentLevel[i][j] = level4[i][j];
				}

			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					hardSandHelperArray[i][j] = level4[i][j];
				}

			}
		} else if (level == 5) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					currentLevel[i][j] = level5[i][j];
				}

			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					hardSandHelperArray[i][j] = level5[i][j];
				}

			}
		} else if (level == 6) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					currentLevel[i][j] = level6[i][j];
				}

			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					hardSandHelperArray[i][j] = level6[i][j];
				}

			}
		} else if (level == 7) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					currentLevel[i][j] = level7[i][j];
				}

			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					hardSandHelperArray[i][j] = level7[i][j];
				}

			}
		} else if (level == 8) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					currentLevel[i][j] = level8[i][j];
				}

			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					hardSandHelperArray[i][j] = level8[i][j];
				}

			}
		} else if (level == 9) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					currentLevel[i][j] = level9[i][j];
				}

			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					hardSandHelperArray[i][j] = level9[i][j];
				}

			}
		} else if (level == 10) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					currentLevel[i][j] = level10[i][j];
				}

			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 19; j++) {
					hardSandHelperArray[i][j] = level10[i][j];
				}

			}
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
			URL urlWall = DesertOfDoom.class.getResource("/images/wall.png");
			ImageIcon wall = new ImageIcon(urlWall);
			tile.setIcon(wall);
		} else if (type.equals("sand")) {
			URL urlSand = DesertOfDoom.class.getResource("/images/sand.jpg");
			ImageIcon sand = new ImageIcon(urlSand);
			tile.setIcon(sand);
		} else if (type.equals("quickSand")) {
			URL urlQuickSand = DesertOfDoom.class.getResource("/images/quickSand.png");
			ImageIcon quickSand = new ImageIcon(urlQuickSand);
			tile.setIcon(quickSand);
		} else if (type.equals("end")) {
			URL urlEnd = DesertOfDoom.class.getResource("/images/end.png");
			ImageIcon end = new ImageIcon(urlEnd);
			tile.setIcon(end);
		} else if (type.equals("money")) {
			URL urlMoney = DesertOfDoom.class.getResource("/images/money.png");
			ImageIcon money = new ImageIcon(urlMoney);
			tile.setIcon(money);
		} else if (type.equals("portal")) {
			URL urlPortal = DesertOfDoom.class.getResource("/images/portal.png");
			ImageIcon portal = new ImageIcon(urlPortal);
			tile.setIcon(portal);
		} else if (type.equals("hardSand")) {
			URL urlHardSand = DesertOfDoom.class.getResource("/images/hardSand.png");
			ImageIcon hardSand = new ImageIcon(urlHardSand);
			tile.setIcon(hardSand);
		} else if (type.equals("key")) {
			URL urlKey = DesertOfDoom.class.getResource("/images/key.png");
			ImageIcon key = new ImageIcon(urlKey);
			tile.setIcon(key);
		} else if (type.equals("blank")) {
			URL urlBlank = DesertOfDoom.class.getResource("/images/blank.png");
			ImageIcon blank = new ImageIcon(urlBlank);
			tile.setIcon(blank);
		} else if (type.equals("lock")) {
			URL urlLock = DesertOfDoom.class.getResource("/images/lock.png");
			ImageIcon lock = new ImageIcon(urlLock);
			tile.setIcon(lock);
		} else {
			tile.setText("Error");
			System.out.println("Error: '" + type + "' block unable to render");
		}

		return tile;
	}

	public void portalEvent(int level) {
		if (level == 6) {
			characterOnBlock = "portal";
			currentLevel[13][6] = "character";
			currentLevel[2][13] = "portal";
		} else if (level == 7) {
			characterOnBlock = "portal";
			System.out.println(Character.posX);
			if (Character.posX == 11 && Character.posY == 7) {
				currentLevel[8][6] = "character";
				currentLevel[7][11] = "portal";
			} else {
				currentLevel[8][6] = "portal";
				currentLevel[7][11] = "character";
			}
		} else if (level == 8) {
			characterOnBlock = "portal";
			if (Character.posX == 9 && Character.posY == 8) {
				currentLevel[1][5] = "character";
				currentLevel[8][9] = "portal";
			} else {
				currentLevel[1][5] = "portal";
				currentLevel[8][9] = "character";
			}
		} else if (level == 10) {
			characterOnBlock = "portal";
			if (enteredLevel10) {
				currentLevel[1][13] = "portal";
				currentLevel[3][4] = "character";
			} else {
				currentLevel[3][4] = "portal";
				currentLevel[1][13] = "character";
				enteredLevel10 = true;
			}
		}
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
				Character.posY = Character.posY - 1;
				this.updateCurrentLevel("up");
			}
		} else if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
			if (character.canDown) {
				Character.posY = Character.posY + 1;
				this.updateCurrentLevel("down");
			}
		} else if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
			if (character.canLeft) {
				Character.posX = Character.posX - 1;
				this.updateCurrentLevel("left");
			}
		} else if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
			if (character.canRight) {
				Character.posX = Character.posX + 1;
				this.updateCurrentLevel("right");
			}
		}
		this.revalidate();
	}

}