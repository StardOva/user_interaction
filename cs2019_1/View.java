package cs2019_1;

import javax.swing.*;

public class View extends JFrame {

	BackgroundPanel bgPanel;
	
	public void initialise() {
		this.setTitle("Adventskalender");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);

		this.bgPanel = new BackgroundPanel();
		bgPanel.initialise();

		this.add(bgPanel);

		this.setVisible(true);
	}

}
