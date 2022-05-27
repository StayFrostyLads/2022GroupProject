import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TitlePanel extends JPanel {
	public static JButton start, instructions, quit;
	JLabel title;
	
	public TitlePanel() {
		setLayout(null);
		JLabel title = new JLabel("Desert of Doom"); //Will be image in future - Stacker just say Desert of Doom in good font
		title.setBounds(100,25,700,200);
		title.setFont(new Font("Garamond", Font.PLAIN, 80));
		add(title);
		
		start = new JButton("Start"); // JButtons and labels can be images, so we can design good images so it looks good
		start.setBackground(Color.GREEN);
		start.setBounds(290,250,200,250);
		start.setFont(new Font("Garamond", Font.PLAIN, 30));
		instructions = new JButton("Instructions");
		instructions.setBackground(Color.CYAN);
		instructions.setBounds(40,250,200,250);
		instructions.setFont(new Font("Garamond", Font.PLAIN, 30));
		quit = new JButton("Quit");
		quit.setBackground(Color.RED);
		quit.setBounds(540,250,200,250);
		quit.setFont(new Font("Garamond", Font.PLAIN, 30));
		
		setBackground(Color.ORANGE);
		add(start);
		add(quit);
		add(instructions);
		
	}
}
