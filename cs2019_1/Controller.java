package cs2019_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Controller implements ActionListener{

	View view;
	Timer timer;
	
	public void initialise(View view) {
		this.view = view;
		
		this.timer = new Timer(50, this);
		timer.start();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(BackgroundPanel.INDEX < 24) {
			Door door = new Door();
			door.initialise(BackgroundPanel.INDEX);
			this.view.bgPanel.add(door);
			this.view.bgPanel.revalidate();
			
			BackgroundPanel.INDEX++;
		}
		else {
			this.timer.stop();
		}
		
	}

}
