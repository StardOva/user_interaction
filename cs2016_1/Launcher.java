package cs2016_1;

public class Launcher {

	public static void main(String[] args) {
		
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller();
		
		model.initialise();
		controller.initialise(model, view);
		view.initialise(model, controller);
	}
}
