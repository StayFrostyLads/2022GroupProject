import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.*;
import java.net.URL;

public class InstructionPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JButton start, quit;
	JLabel title;
	
	public InstructionPanel() {
		setLayout(null);
		Color brown = new Color(194, 178, 128);
		Color color = new Color(152, 133, 88);
		setBackground(color);
		JLabel title = new JLabel("Instructions"); //Will be image in future - Stacker just say Desert of Doom in good font
		title.setBounds(200,25,550,75);
		title.setFont(new Font("Garamond", Font.PLAIN, 70));
		title.setForeground(Color.BLACK);
		add(title);
		
		URL urlSand = DesertOfDoom.class.getResource("/images/sand.jpg");
		ImageIcon sand = new ImageIcon(urlSand);
		
		URL urlEnd = DesertOfDoom.class.getResource("/images/end.png");
		ImageIcon end = new ImageIcon(urlEnd);
		
		URL urlQSand = DesertOfDoom.class.getResource("/images/quickSand.png");
		ImageIcon quickSand = new ImageIcon(urlQSand);
		
		URL urlMoney = DesertOfDoom.class.getResource("/images/money.png");
		ImageIcon money = new ImageIcon(urlMoney);
		
		URL urlPortal = DesertOfDoom.class.getResource("/images/portal.png");
		ImageIcon portal = new ImageIcon(urlPortal);
		
		URL urlHSand = DesertOfDoom.class.getResource("/images/hardSand.png");
		ImageIcon hardSand = new ImageIcon(urlHSand);
		
		URL urlKey = DesertOfDoom.class.getResource("/images/key.png");
		ImageIcon key = new ImageIcon(urlKey);
		
		URL urlLock = DesertOfDoom.class.getResource("/images/lock.png");
		ImageIcon lock = new ImageIcon(urlLock);
		
		URL urlWall = DesertOfDoom.class.getResource("/images/wall.png");
		ImageIcon wall = new ImageIcon(urlWall);
		
		JLabel sTile = new JLabel();
		sTile.setIcon(sand);
		sTile.setBounds(50, 125, 50, 50);
		JLabel eTile = new JLabel();
		eTile.setIcon(end);
		eTile.setBounds(50,200,50,50);
		JLabel qsTile = new JLabel();
		qsTile.setIcon(quickSand);
		qsTile.setBounds(50,275,50,50);
		JLabel mTile = new JLabel();
		mTile.setIcon(money);
		mTile.setBounds(50,350,50,50);
		JLabel pTile = new JLabel();
		pTile.setIcon(portal);
		pTile.setBounds(50,425,50,50);
		JLabel hsTile = new JLabel();
		hsTile.setIcon(hardSand);
		hsTile.setBounds(400,125,50,50);
		JLabel kTile = new JLabel();
		kTile.setIcon(key);
		kTile.setBounds(400,200,50,50);
		JLabel lTile = new JLabel();
		lTile.setIcon(lock);
		lTile.setBounds(400,275,50,50);
		JLabel wTile = new JLabel();
		wTile.setIcon(wall);
		wTile.setBounds(400,350,50,50);
		
		JLabel sWords = new JLabel("Sand: You can only step on each space once");
		sWords.setFont(new Font("Garamond", Font.PLAIN, 17));
		sWords.setBounds(97,125,300,50);
		sWords.setForeground(Color.BLACK);
		JLabel eWords = new JLabel("End: Reach this point to complete the level");
		eWords.setFont(new Font("Garamond", Font.PLAIN, 17));
		eWords.setForeground(Color.BLACK);
		eWords.setBounds(97,200,300,50);
		JLabel qsWords = new JLabel("<html>Quicksand: You can't step on it and lose <br/>if you get stuck in it</html>");
		qsWords.setFont(new Font("Garamond", Font.PLAIN, 17));
		qsWords.setForeground(Color.BLACK);
		qsWords.setBounds(97,275,300,50);
		JLabel mWords = new JLabel("Money: Collect for extra points");
		mWords.setFont(new Font("Garamond", Font.PLAIN, 17));
		mWords.setBounds(97,350,500,50);
		mWords.setForeground(Color.BLACK);
		JLabel pWords = new JLabel("Portal: Enter one exit the other");
		pWords.setFont(new Font("Garamond", Font.PLAIN, 17));
		pWords.setBounds(97,425,300,50);
		pWords.setForeground(Color.BLACK);
		JLabel hsWords = new JLabel("Hard Sand: You can step on this space twice");
		hsWords.setFont(new Font("Garamond", Font.PLAIN, 17));
		hsWords.setBounds(455,125,300,50);
		hsWords.setForeground(Color.BLACK);
		JLabel kWords = new JLabel("Key: Needed to unlock locks");
		kWords.setFont(new Font("Garamond", Font.PLAIN, 17));
		kWords.setBounds(455,200,300,50);
		kWords.setForeground(Color.BLACK);
		JLabel lWords = new JLabel("<html>Lock: You cannot move past this without <br/>a key</html>");
		lWords.setFont(new Font("Garamond", Font.PLAIN, 17));
		lWords.setBounds(455,275,300,50);
		lWords.setForeground(Color.BLACK);
		JLabel wWords = new JLabel("Wall: You cannot go through walls");
		wWords.setFont(new Font("Garamond", Font.PLAIN, 17));
		wWords.setBounds(455,350,300,50);
		wWords.setForeground(Color.BLACK);
		
		start = new JButton("Start"); // JButtons and labels can be images, so we can design good images so it looks good
		start.setBackground(brown);
		start.setFocusable(false);
		start.setBounds(100, 500, 200, 100);
		start.setFont(new Font("Garamond", Font.PLAIN, 30));
		start.setBorder(new LineBorder(Color.BLACK));
		start.setForeground(Color.BLACK);
		quit = new JButton("Quit");
		quit.setBackground(brown);
		quit.setFocusable(false);
		quit.setForeground(Color.BLACK);
		quit.setBorder(new LineBorder(Color.BLACK));
		quit.setBounds(450, 500, 200, 100);
		quit.setForeground(Color.BLACK);
		quit.setFont(new Font("Garamond", Font.PLAIN, 30));
		
		add(start);
		add(quit);
		add(sTile);
		add(eTile);
		add(qsTile);
		add(mTile);
		add(pTile);
		add(hsTile);
		add(kTile);
		add(lTile);
		add(wTile);
		add(sWords);
		add(eWords);
		add(qsWords);
		add(mWords);
		add(pWords);
		add(hsWords);
		add(kWords);
		add(lWords);
		add(wWords);
		
	}

}