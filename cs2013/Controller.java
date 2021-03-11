package example2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class Controller extends MouseAdapter implements ActionListener {

	static final String MIX = "mix";
	static final String RESET = "reset";
	static final String COPY = "copy";
	static final String PASTE = "paste";

	public Model model;
	public MainFrame view;

	private int index;
	private Color color;

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals(Controller.MIX)) {
			this.model.mixAllColors();
		} else if (command.equals(Controller.RESET)) {
			this.model.resetAllColors();
		} else if (command.equals(Controller.COPY)) {
			this.model.setStoredColor(this.color);
		} else if (command.equals(Controller.PASTE)) {
			this.model.copyColor(this.index, this.model.getStoredColor());
		}
		this.view.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		int button = e.getButton();
		int i = 0;
		Color background = null;

		if (o instanceof JLabel) {
			JLabel label = (JLabel) o;
			String text = label.getText();
			 background = label.getBackground();
			i = Integer.valueOf(text);
			
		}
		
		if(button == MouseEvent.BUTTON1) {
			this.model.mixOneColor(i);
			this.view.repaint();
		}
		else if(button == MouseEvent.BUTTON3) {
			
			this.index = i;
			this.color = background;
			
			this.view.popup.show((Component) e.getSource(), e.getX(), e.getY());
		}
		
		
	}

}
