package cs2019_1;

public class Launcher {
	public static void main(String[] args) {
		View view = new View();
		Controller controller = new Controller();
		
		view.initialise();
		controller.initialise(view);
	}
}
