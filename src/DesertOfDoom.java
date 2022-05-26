import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class DesertOfDoom extends JFrame {
	private JPanel cards, title, instruction, background, lose, win;
	private JPanel gamePanel;
	CardLayout cL = new CardLayout();
	boolean play = false;
	
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
		gamePanel = new GamePanel();
		
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
				play = false;
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
				play = false;
			}
		});
		
	}
	
	private void showScreen(String a) {
		cL.show(cards, a);
	}
	
	public static void main(String[] args) {
		DesertOfDoom game = new DesertOfDoom();
	}
	
}
