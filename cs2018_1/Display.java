package cs2018_1;

import java.awt.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class Display extends JPanel implements Serializable {

	private transient SimpleDateFormat formatter; // transient verhindert Serialisierung
	private String date;
	private JLabel label;
	private transient Timer timer;

	public Display() {
		formatter = new SimpleDateFormat("d.M.y H:m:s");
		JLabel label = new JLabel();
		label.setForeground(Color.RED);
		label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 48));
		label.setText(date);

		String[] timeZones = { "Asia/Bangkok", "Asia/Beirut", "Asia/Damascus", "Asia/Istanbul", "Asia/Jakarta",
				"Asia/Shanghai", "Asia/Tokyo", "Europe/Berlin", "Europe/Lisbon", "Europe/Moscow" };

		DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<String>(timeZones);
		boxModel.setSelectedItem("Europe/Berlin");

		JComboBox<String> box = new JComboBox<String>(boxModel);

		this.setPreferredSize(new Dimension(600, 120));
		this.setSize(new Dimension(600, 120));

		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

		// i) BorderLayout zuweisen??

		this.add(box, BorderLayout.SOUTH);
		this.add(label, BorderLayout.CENTER);

	}

	public SimpleDateFormat getFormatter() {
		return formatter;
	}

	public void setFormatter(SimpleDateFormat formatter) {
		this.formatter = formatter;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}
