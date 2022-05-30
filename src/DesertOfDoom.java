import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class DesertOfDoom extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel cards;
	private JPanel title;
	private JPanel instruction;
	private static JPanel background;
	private JPanel lose;
	private JPanel win;
	private static JPanel gamePanel;
	static CardLayout cL = new CardLayout();
	static Object waitObject = new Object();
	static AudioInputStream gameStream;
	static AudioInputStream titleStream;
	static Clip gameClip;
	static Clip titleClip;
	static URL urlTitleSound = DesertOfDoom.class.getResource("/music/musicTitle.wav");
	static URL urlGameSound = DesertOfDoom.class.getResource("/music/musicGame.wav");

	public DesertOfDoom() {
		setTitle("Desert of Doom");
		setSize(788, 716);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setFocusable(false);
		setResizable(false);
		cards = new JPanel(cL);
		title = new TitlePanel();
		instruction = new InstructionPanel();
		background = new BackgroundPanel();
		lose = new LosePanel();
		win = new WinPanel();

		cards.setFocusable(false);
		background.setFocusable(false);
		gamePanel = new GamePanel(1);
		gamePanel.setFocusable(true);
		background.add(gamePanel);
		background.setFocusable(false);
		instruction.setFocusable(false);
		lose.setFocusable(false);
		win.setFocusable(false);

		cards.add(title, "title");
		cards.add(instruction, "instruction");
		cards.add(background, "background");
		cards.add(win, "win");
		cards.add(lose, "lose");
		add(cards);
		cL.show(cards, "title");

		revalidate();

		try {
			titleStream = AudioSystem.getAudioInputStream(urlTitleSound);
			titleClip = AudioSystem.getClip();
			gameStream = AudioSystem.getAudioInputStream(urlGameSound);
			gameClip = AudioSystem.getClip();
		} catch (Exception exc) {
			System.out.println(exc);
		}

		TitlePanel.start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!BackgroundPanel.stopwatch.started) {
					BackgroundPanel.stopwatch.start();
				}
				cL.show(cards, "background");
				gamePanel.requestFocusInWindow();
				titleClip.stop();
				titleClip.close();
				try {
					gameStream = AudioSystem.getAudioInputStream(urlGameSound);
					gameClip = AudioSystem.getClip();
					gameClip.open(gameStream);
					gameClip.loop(10);
				} catch (Exception exception) {
					System.out.println(exception);
				}
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
				if (!BackgroundPanel.stopwatch.started) {
					BackgroundPanel.stopwatch.start();
				}
				cL.show(cards, "background");
				gamePanel.requestFocusInWindow();
				titleClip.stop();
				titleClip.close();
				try {
					gameStream = AudioSystem.getAudioInputStream(urlGameSound);
					gameClip = AudioSystem.getClip();
					gameClip.open(gameStream);
					gameClip.loop(10);
				} catch (Exception exception) {
					System.out.println(exception);
				}
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
				cL.show(cards, "title");
				gameClip.stop();
				gameClip.close();
				try {
					titleStream = AudioSystem.getAudioInputStream(urlTitleSound);
					titleClip = AudioSystem.getClip();
					titleClip.open(titleStream);
					titleClip.loop(10);
				} catch (Exception exception) {
					System.out.println(exception);
				}
			}
		});
		LosePanel.titleB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(cards, "title");
				gameClip.stop();
				gameClip.close();
				try {
					titleStream = AudioSystem.getAudioInputStream(urlTitleSound);
					titleClip = AudioSystem.getClip();
					titleClip.open(titleStream);
					titleClip.loop(10);
				} catch (Exception exception) {
					System.out.println(exception);
				}
			}
		});
		LosePanel.quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				;
			}
		});
		WinPanel.titleB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(cards, "title");
				gameClip.stop();
				gameClip.close();
				try {
					titleStream = AudioSystem.getAudioInputStream(urlTitleSound);
					titleClip = AudioSystem.getClip();
					titleClip.open(titleStream);
					titleClip.loop(10);
				} catch (Exception exception) {
					System.out.println(exception);
				}

			}
		});
		WinPanel.quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				;
			}
		});

	}

	static void showScreen(String a) {
		cL.show(cards, a);
	}

	public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
		new DesertOfDoom();
		BackgroundPanel.level.setText("Level: 1");

		titleStream = AudioSystem.getAudioInputStream(urlTitleSound);
		titleClip = AudioSystem.getClip();
		titleClip.open(titleStream);
		titleClip.loop(10);
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
		BackgroundPanel.stopwatch.stop();
		WinPanel.pointsLabel.setText("Total Score: " + BackgroundPanel.points);
		WinPanel.levelLabel.setText("Level Achieved: " + GamePanel.level);
		WinPanel.timeLabel.setText(BackgroundPanel.stopwatch.time);
		DesertOfDoom.showScreen("win");
	}

}