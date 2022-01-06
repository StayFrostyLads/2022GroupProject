import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class GamePage extends JPanel {
	
	GamePage() {
		setLayout(new GridLayout());
		setSize(675,486);
		setLocation(5,70);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel text = new JLabel("Game Goes Here");
		add(text);
	}

}
