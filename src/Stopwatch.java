import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String time = " ";
	long start, stop;
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;
	int realElapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int milliseconds = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes); 
	String milliseconds_string = String.format("%02d", milliseconds); 
	Color background = new Color(152, 133, 88);
	Timer timer = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			elapsedTime += 1000;
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes); 
			timeLabel.setText("Time: " + minutes_string +  ":" + seconds_string);
		}
	});
	
	Stopwatch() {
		
		timeLabel.setText("Time: " + minutes_string +  ":" + seconds_string);
		timeLabel.setBounds(0,0,200,30);
		timeLabel.setFont(new Font("Garamond", Font.PLAIN, 30));
		timeLabel.setForeground(Color.BLACK);
		
		setSize(200,30);
		setLayout(null);
		setBackground(background);
		add(timeLabel);
	}
	
	void start() {
		start = System.nanoTime();
		timer.start();
		started = true;
	}
	
	void stop() {
		stop = System.nanoTime();
		timer.stop();
		long t = (stop - start);
		time = Long.toString(t);
		time = time.substring(0, time.length() - 6);
		int eT = Integer.valueOf(time);
		minutes = (eT/60000) % 60;
		seconds = (eT/1000) % 60;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes); 
		milliseconds_string = time.substring(time.length()-3, time.length());
		time = "Total Time: " + minutes_string + ":" + seconds_string + "." + milliseconds_string;
	}

}
