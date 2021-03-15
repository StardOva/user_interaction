package cs2018_1;

public class Launcher {
	public static void main(String[] args) {
		View view = new View();
		Controller controller = new Controller();

		view.initiliase(controller);
		controller.initialise(view);
		
	}
}
