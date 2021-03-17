package cs2016_1;

import java.awt.event.*;
import javax.swing.*;

public class MouseController extends MouseAdapter {

	JLabel label;

	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);

		JLabel source = (JLabel) e.getSource();
		int button = e.getButton();

		JLabel localLabel = new JLabel();

		if (button == MouseEvent.BUTTON1) {
			System.out.println("Linke Maustaste gedrückt");
			label = source;
		} else if (button == MouseEvent.BUTTON3) {
			System.out.println("Rechte Maustaste gedrückt");
			localLabel = source;
		}

		if (this.label != null) {

			Icon icon = this.label.getIcon();
			Icon localIcon = localLabel.getIcon();

			if (icon != null && localIcon != null) {
				this.label.setIcon(localIcon);
				localLabel.setIcon(icon);
			}
		}
	}
}
