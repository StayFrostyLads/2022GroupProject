import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TitlePanel extends JPanel {
	public static JButton start, instructions, quit;
	JLabel title;
	
	public TitlePanel() {
		setLayout(null);
		JLabel title = new JLabel("Desert of Doom"); //Will be image in future - Stacker just say Desert of Doom in good font
		title.setBounds(50,50,200,50);
		add(title);
		
		start = new JButton("Start"); // JButtons and labels can be images, so we can design good images so it looks good
		start.setBackground(Color.GREEN);
		start.setBounds(290,250,200,250);
		instructions = new JButton("Instructions");
		instructions.setBackground(Color.CYAN);
		instructions.setBounds(40,250,200,250);
		quit = new JButton("Quit");
		quit.setBackground(Color.RED);
		quit.setBounds(540,250,200,250);
		
		setBackground(Color.ORANGE);
		add(start);
		add(quit);
		add(instructions);
		
	}
}
