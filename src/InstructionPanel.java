import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;

public class InstructionPanel extends JPanel {
	
	public static JButton start, quit;
	JLabel title;
	
	public InstructionPanel() {
		setLayout(null);
		JLabel title = new JLabel("Instructions"); //Will be image in future - Stacker just say Desert of Doom in good font
		title.setBounds(200,50,550,75);
		title.setFont(new Font("Garamond", Font.PLAIN, 70));
		add(title);
		
		//Add text for instructions
		ImageIcon sand = new ImageIcon("./images/sand.jpg");
		ImageIcon end = new ImageIcon("./images/end.png");
		ImageIcon quickSand = new ImageIcon("./images/quickSand.png");
		ImageIcon money = new ImageIcon("./images/Money.png");
		ImageIcon portal = new ImageIcon("./images/Portal.png");
		ImageIcon hardSand = new ImageIcon("./images/hardSand.png");
		ImageIcon key = new ImageIcon("./images/key.png");
		ImageIcon lock = new ImageIcon("./images/Lock.png");
		ImageIcon wall = new ImageIcon("./images/wall.png");
		
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
		
		start = new JButton("Start"); // JButtons and labels can be images, so we can design good images so it looks good
		start.setBackground(Color.GREEN);
		start.setBounds(100, 500, 200, 100);
		start.setFont(new Font("Garamond", Font.PLAIN, 30));
		quit = new JButton("Quit");
		quit.setBackground(Color.RED);
		quit.setBounds(450, 500, 200, 100);
		quit.setFont(new Font("Garamond", Font.PLAIN, 30));
		
		setBackground(Color.ORANGE);
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
		
	}

}
