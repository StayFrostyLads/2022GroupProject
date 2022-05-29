import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class LosePanel extends JPanel {
	public LosePanel() {
		setLayout(null);
		JLabel title = new JLabel("YOU LOSE");
		title.setBounds(160,200,600,200);
		title.setFont(new Font("Garamond", Font.PLAIN, 90));
		add(title);
		setBackground(Color.ORANGE);
	}
}
