import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class DesertOfDoom extends JFrame {
	private static JPanel cards;
	private JPanel title;
	private JPanel instruction;
	private JPanel background;
	private JPanel lose;
	private JPanel win;
	private static JPanel gamePanel;
	static CardLayout cL = new CardLayout();
	static Object waitObject = new Object();
	
	public DesertOfDoom() {
		setTitle("Desert of Doom");
		setSize(788,716);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setFocusable(false);
		
		cards = new JPanel(cL);
		title = new TitlePanel();
		instruction = new InstructionPanel();
		background = new BackgroundPanel();
		lose = new LosePanel();
		win = new WinPanel();
		gamePanel = new GamePanel(1);
		
		cards.setFocusable(false);
		background.setFocusable(false);
		
		background.add(gamePanel);
		cards.add(title, "title");
		cards.add(instruction, "instruction");
		cards.add(background, "background");
		cards.add(win, "win");
		cards.add(lose, "lose");
		add(cards);
		cL.show(cards, "title");
		
		revalidate();
		
		TitlePanel.start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(cards, "background");
				gamePanel.requestFocusInWindow();
			}
		});
		TitlePanel.instructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(cards, "instruction");
			}
		});
		TitlePanel.quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		InstructionPanel.start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(cards, "background");
				gamePanel.requestFocusInWindow();
			}
		});
		InstructionPanel.quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		BackgroundPanel.quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		BackgroundPanel.title.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(cards,  "title");
			}
		});
		LosePanel.titleB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(cards,  "title");
			}
		});
		LosePanel.quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);;
			}
		});
		WinPanel.titleB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(cards,  "title");
			}
		});
		WinPanel.quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);;
			}
		});
		
	}
	
	static void showScreen(String a) {
		cL.show(cards, a);
	}
	
	public static void main(String[] args) {
		DesertOfDoom game = new DesertOfDoom();
		BackgroundPanel.level.setText("Level: 1");
		synchronized (waitObject) {
			try {
				waitObject.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gamePanel = new GamePanel(2);
		BackgroundPanel.level.setText("Level: 2");
		synchronized (waitObject) {
			try {
				waitObject.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gamePanel = new GamePanel(3);
		BackgroundPanel.level.setText("Level: 3");
		synchronized (waitObject) {
			try {
				waitObject.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gamePanel = new GamePanel(4);
		BackgroundPanel.level.setText("Level: 4");
		synchronized (waitObject) {
			try {
				waitObject.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gamePanel = new GamePanel(5);
		BackgroundPanel.level.setText("Level: 5");
		synchronized (waitObject) {
			try {
				waitObject.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gamePanel = new GamePanel(6);
		BackgroundPanel.level.setText("Level: 6");
		synchronized (waitObject) {
			try {
				waitObject.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gamePanel = new GamePanel(7);
		BackgroundPanel.level.setText("Level: 7");
		synchronized (waitObject) {
			try {
				waitObject.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gamePanel = new GamePanel(8);
		BackgroundPanel.level.setText("Level: 8");
		synchronized (waitObject) {
			try {
				waitObject.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gamePanel = new GamePanel(9);
		BackgroundPanel.level.setText("Level: 9");
		synchronized (waitObject) {
			try {
				waitObject.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gamePanel = new GamePanel(10);
		BackgroundPanel.level.setText("Level: 10");
		synchronized (waitObject) {
			try {
				waitObject.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		showScreen("win");
	}
	
}
