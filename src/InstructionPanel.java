import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class InstructionPanel extends JPanel {
	
	public static JButton start, quit;
	JLabel title;
	
	public InstructionPanel() {
		setLayout(null);
		JLabel title = new JLabel("Instructions"); //Will be image in future - Stacker just say Desert of Doom in good font
		title.setBounds(200,50,550,75);
		title.setFont(new Font("", Font.PLAIN, 70));
		add(title);
		
		//Add text for instructions
		
		start = new JButton("Start"); // JButtons and labels can be images, so we can design good images so it looks good
		start.setBackground(Color.GREEN);
		start.setBounds(100, 500, 200, 100);
		start.setFont(new Font("", Font.PLAIN, 30));
		quit = new JButton("Quit");
		quit.setBackground(Color.RED);
		quit.setBounds(450, 500, 200, 100);
		quit.setFont(new Font("", Font.PLAIN, 30));
		
		setBackground(Color.ORANGE);
		add(start);
		add(quit);
		
	}

}
