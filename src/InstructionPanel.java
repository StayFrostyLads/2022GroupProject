import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionPanel extends JPanel {
	
	static JButton start, quit;
	JLabel title;
	
	InstructionPanel() {
		//setLayout(null);
		JLabel title = new JLabel("Instructions"); //Will be image in future - Stacker just say Desert of Doom in good font
		title.setBounds(50,50,200,50);
		add(title);
		
		start = new JButton("Start"); // JButtons and labels can be images, so we can design good images so it looks good
		quit = new JButton("Quit");
		
		add(start);
		add(quit);
		
	}

}
