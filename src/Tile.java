import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Tile {
	String type = "";
	JLabel tile;
	Tile(String type) {
		this.type = type;
		if (type.equals("wall")) {
			tile = new JLabel("wall"); // will be the wall image in future
		} else if (type.equals("hard sand")) {  
			tile = new JLabel("hard sand");  //will be the sand image in future (hard sand = ice in thin ice)
		} else if (type.equals("quick sand")) {
			tile = new JLabel("quick sand"); // image of quick sand in future (quick sand = water in thin ice)
		} else if (type.equals("end point")) {
			tile = new JLabel("end point"); // ^^
		} else if (type.equals("start point")) {
			tile = new JLabel("start point"); // ^^
		}  else if (type.equals("money")) {
			tile = new JLabel("money"); // ^^
		} else if (type.equals("portal")) {
			tile = new JLabel("portal"); // ^^
		} else if (type.equals("extra hard sand")) {
			tile = new JLabel("extra hard sand"); // (extra hard sand = double layer ice in thin ice)
		}
		
	}

}
