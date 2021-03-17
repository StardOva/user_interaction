package cs2016_1;

public class Controller {
	MouseController mouseController;
	ActionController actionController;
	
	public void initialise(Model model, View view) {
		this.mouseController = new MouseController();
		this.actionController = new ActionController(model, view);
	}
}
