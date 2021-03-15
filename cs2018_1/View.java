package cs2018_1;

import java.awt.*;
import javax.swing.*;

public class View extends JFrame {

	JPanel clocks;
	JSpinner counter;

	public void initiliase(Controller controller) {
		this.setTitle("Weltzeituhr");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(1200, 800));
		this.setLocationRelativeTo(null);

		JLabel label = new JLabel("", new ImageIcon("src/cs2018_1/urania-weltzeituhr_alexanderplatz_berlin.jpeg"),
				JLabel.CENTER);
		this.add(label, BorderLayout.WEST);

		JPanel p = new JPanel();

		clocks = new JPanel();
		clocks.setLayout(new BoxLayout(clocks, BoxLayout.Y_AXIS));

		SpinnerNumberModel model = new SpinnerNumberModel();
		model.setMinimum(0);
		model.setMaximum(5);
		model.setStepSize(1);

		int value = 1;
		counter = new JSpinner(model);
		counter.setPreferredSize(new Dimension(400, 100));
		counter.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
		counter.setToolTipText("Erzeugt oder löscht eine Uhr");
		counter.addChangeListener(controller);

		p.add(counter, BorderLayout.SOUTH);
		p.add(clocks, BorderLayout.CENTER);

		this.add(p, BorderLayout.CENTER);

		this.setVisible(true);

	}

}
