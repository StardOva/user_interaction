package cs2015;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;

public class Launcher {
	public static void main(String[] args) {
		
		Locale locale = new Locale(args[0], args[1]);
		
		ResourceBundle bundle = ResourceBundle.getBundle("labels", locale);
		
		MasterView view = new MasterView();

		DefaultListModel<Student> model = new DefaultListModel<Student>();

		Controller controller = new Controller();
		controller.initialise(model, view);
		
		Details details = new Details();
		details.initialise(controller, bundle);

		view.initialise(model, controller, bundle);

	}
}
