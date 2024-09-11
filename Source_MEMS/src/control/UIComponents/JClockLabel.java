package control.UIComponents;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.Timer;

public class JClockLabel extends JLabel {
	public JClockLabel() {
		super("yyy-MM-dd HH:mm:ss");
		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formatterDateTime = now.format(formatter);
				updateText(formatterDateTime);
			}
		});
		timer.start();
	}

	protected void updateText(String text) {
		// TODO Auto-generated method stub
		super.setText(text);
		super.setFont(new Font("Segoe UI", Font.ITALIC, 12));
	}

}
