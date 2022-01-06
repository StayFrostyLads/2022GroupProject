import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EntryPoint {
  public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    frame.setSize(800,600);
	    CardLayout cL = new CardLayout();
	    
	    // Panels
	    JPanel cards = new JPanel(); //we are going to call this a lot so I made name easier
	    cards.setLayout(cL);
	    JPanel titleScreen = new JPanel();
	    JPanel instructionScreen = new JPanel();
	    JPanel level1 = new JPanel();
	    JPanel level2 = new JPanel();
	    JPanel level3 = new JPanel();
	    JPanel level4 = new JPanel();
	    JPanel level5 = new JPanel();
	    JPanel level6 = new JPanel();
	    JPanel level7 = new JPanel();
	    JPanel level8 = new JPanel();
	    JPanel level9 = new JPanel();
	    JPanel level10 = new JPanel();
	    JPanel endScreen = new JPanel();
	    JPanel gameOver = new JPanel();
	    
	    cards.add(titleScreen, "Title Screen");
	    cards.add(instructionScreen, "Instruction Screen");
	    cards.add(level1, "Level 1");
	    cards.add(level2, "Level 2");
	    cards.add(level3, "Level 3");
	    cards.add(level4, "Level 4");
	    cards.add(level5, "Level 5");
	    cards.add(level6, "Level 6");
	    cards.add(level7, "Level 7");
	    cards.add(level8, "Level 8");
	    cards.add(level9, "level 9");
	    cards.add(level10, "Level 10");
	    cards.add(endScreen, "End Screen");
	    cards.add(gameOver, "Game Over");
	    frame.add(cards, null); // If we use GridBagLayout, it might be useful when we start coding game because then it will be easy to implement up, down ... grid movements of thing
	    cL.first(cards);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    // Buttons
      JButton tempLB1 = new JButton("Level 2");
      JButton tempLB2 = new JButton("Level 3");
      JButton tempLB3 = new JButton("Level 4");
      JButton tempLB4 = new JButton("Level 5");
      JButton tempLB5 = new JButton("Level 6");
      JButton tempLB6 = new JButton("Level 7");
      JButton tempLB7 = new JButton("Level 8");
      JButton tempLB8 = new JButton("Level 9");
      JButton tempLB9 = new JButton("Level 10");

	    JButton tStart = new JButton("Start");
      JButton iStart = new JButton("Start");
	    JButton instruct = new JButton("Instructions");
	    JButton lquit = new JButton("Quit");
      JButton wquit = new JButton("Quit");
      JButton equit = new JButton("Quit");
	    JButton playAgain = new JButton("Play Again");
	    
	    titleScreen.add(tStart);
	    titleScreen.add(instruct);
	    level10.add(lquit);
	    // instructions screen
	    instructionScreen.add(iStart);

	    // end screen
	    endScreen.add(playAgain);
	    endScreen.add(wquit);
	    // game over screen
	    gameOver.add(playAgain);
	    gameOver.add(equit);

      // levels 1- 10
      level1.add(tempLB1);
      level2.add(tempLB2);
      level3.add(tempLB3);
      level4.add(tempLB4);
      level5.add(tempLB5);
      level6.add(tempLB6);
      level7.add(tempLB7);
      level8.add(tempLB8);
      level9.add(tempLB9);

	  
	    // Labels
	    JLabel titleScreenText = new JLabel("Title Screen");
	    JLabel instructionScreenText = new JLabel("Instruction Screen");
	    JLabel level1ScreenText = new JLabel("Level 1");
	    JLabel level2ScreenText = new JLabel("Level 2");
	    JLabel level3ScreenText = new JLabel("Level 3");
	    JLabel level4ScreenText = new JLabel("Level 4");
	    JLabel level5ScreenText = new JLabel("Level 5");
	    JLabel level6ScreenText = new JLabel("Level 6");
	    JLabel level7ScreenText = new JLabel("Level 7");
	    JLabel level8ScreenText = new JLabel("Level 8");
	    JLabel level9ScreenText = new JLabel("Level 9");
	    JLabel level10ScreenText = new JLabel("Level 10");
	    JLabel endScreenText = new JLabel("Congratulations! You beat our game.");
	    JLabel loseScreenText = new JLabel("You lose!");

	    titleScreen.add(titleScreenText);
	    instructionScreen.add(instructionScreenText);
	    level1.add(level1ScreenText);
	    level2.add(level2ScreenText);
	    level3.add(level3ScreenText);
	    level4.add(level4ScreenText);
	    level5.add(level5ScreenText);
	    level6.add(level6ScreenText);
	    level7.add(level7ScreenText);
	    level8.add(level8ScreenText);
	    level9.add(level9ScreenText);
	    level10.add(level10ScreenText);
	    endScreen.add(endScreenText);
	    gameOver.add(loseScreenText);

	  
	    // Button Logic
      tStart.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.show(cards, "Level 1");
	        }
	     } );
      iStart.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.show(cards, "Level 1");
	        }
	     } );
	    instruct.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.show(cards, "Instruction Screen");
	        }
	     } );
      // i added 3 different ways of quitting for now, same problem that was happening with the buttons
      equit.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          System.exit(0);
	        }
	     } );
      lquit.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          System.exit(0);
	        }
	     } );
      wquit.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          System.exit(0);
	        }
	     } );
      playAgain.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.show(cards, "Level 1"); // Or go back to title screen??
            // should be title screen imo - JN
	        }
	     } ); 
      tempLB2.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.next(cards);
	        }
	     } );
      tempLB3.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.next(cards);
	        }
	     } );
      tempLB4.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.next(cards);
	        }
	     } );
      tempLB5.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.next(cards);
	        }
	     } );
      tempLB6.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.next(cards);
	        }
	     } );
      tempLB7.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.next(cards);
	        }
	     } );
      tempLB8.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.next(cards);
	        }
	     } );
      tempLB9.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.next(cards);
	        }
	     } );
      tempLB1.addActionListener(new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	          cL.next(cards);
	        }
	     } );
  }
}

// comments from jack
// I ran this at my PC at home and it showed the title without any full screening? must just be the macs
// Good to know - HC
