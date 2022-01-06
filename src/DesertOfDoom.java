import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DesertOfDoom extends JFrame {
	public JPanel cards, title, instruction, background, lose, win;

	public DesertOfDoom() {
		setTitle("MultiPanel Test");
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		CardLayout cL = new CardLayout();
		cards = new JPanel(cL);
		title = new TitlePanel();
		instruction = new InstructionPanel();
		background = new BackgroundPanel();
		lose = new LosePanel();
		win = new WinPanel();

		cards.add(title, "title");
		cards.add(instruction, "instruction");
		cards.add(background, "background");
		cards.add(win, "win");
		cards.add(lose, "lose");
		add(cards);

		cL.show(cards, "title");

		
		//Button Logic
		TitlePanel.start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(cards, "background");
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
			}
		});
		InstructionPanel.quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		BackgroundPanel.quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(cards, "background");
			}
		});
		BackgroundPanel.title.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}

	public static void main(String[] args) {
		new DesertOfDoom();
	}
}
