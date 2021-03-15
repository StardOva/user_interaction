package cs2018_1;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ChangeListener {

	View view;

	public void initialise(View view) {
		this.view = view;

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int counter = (int) this.view.counter.getValue();
		int componentCount = this.view.clocks.getComponentCount();

		int diff = counter - componentCount;

		// Neue Uhren müssen hinzugefügt werden
		if (diff > 0) {
			for (int i = 0; i < diff; i++) {
				Display display = new Display();
				this.view.clocks.add(display);
				
				
				System.out.println(this.view.clocks);
				
			}
		}

		// Uhren müssen gelöscht werden
		if (diff < 0) {
			for (int i = 0; i > diff; i--) {
				this.view.clocks.remove(componentCount - i - 1);
			}
		}

		this.view.repaint();

	}
}
