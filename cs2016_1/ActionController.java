package cs2016_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionController implements ActionListener {

	public static final String EXIT = "exit";
	public static final String SORT = "sort";
	public static final String RANDOMISE = "randomise";
	
	Model model;
	View view;
	
	public ActionController(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
		case EXIT:
			System.exit(0);
			break;

		case SORT:
			this.model.sort();
			this.view.repaint();
			break;

		case RANDOMISE:
			this.model.randomise();
			this.view.repaint();
			break;

		default:
			System.err.println("Unknown command: " + command);
			break;
		}
	}

}
