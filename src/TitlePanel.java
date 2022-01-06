import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TitlePanel extends JPanel {
	static JButton start, instructions, quit;
	JLabel title;
	
	TitlePanel() {
		//setLayout(null);
		JLabel title = new JLabel("Desert of Doom"); //Will be image in future - Stacker just say Desert of Doom in good font
		title.setBounds(50,50,200,50);
		add(title);
		
		start = new JButton("Start"); // JButtons and labels can be images, so we can design good images so it looks good
		instructions = new JButton("Instrucitons");
		quit = new JButton("Quit");
		
		add(start);
		add(quit);
		add(instructions);	
		
	}
}
