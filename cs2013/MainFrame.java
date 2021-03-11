package example2;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	JLabel[] labels;
	JPopupMenu popup;
	public Model model;
	Controller controller;

	public void buildMenu() {
		this.popup = new JPopupMenu();

		JMenuItem mix = new JMenuItem("Mix");
		JMenuItem reset = new JMenuItem("Reset");
		JMenuItem copy = new JMenuItem("Copy");
		JMenuItem paste = new JMenuItem("Paste");

		mix.setActionCommand(Controller.MIX);
		reset.setActionCommand(Controller.RESET);
		copy.setActionCommand(Controller.COPY);
		paste.setActionCommand(Controller.PASTE);

		mix.addActionListener(this.controller);
		reset.addActionListener(this.controller);
		copy.addActionListener(this.controller);
		paste.addActionListener(this.controller);

		this.popup.add(mix);
		this.popup.add(reset);
		this.popup.add(copy);
		this.popup.add(paste);
	}

	public void initialise() {
		this.model = new Model();
		this.model.initiliase();

		this.controller = new Controller();
		this.controller.model = this.model;
		this.controller.view = this;

		this.labels = new JLabel[49];
		JPanel colourPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		JButton mix = new JButton();
		JButton reset = new JButton();

		Dimension d = new Dimension(400, 400);
		GridLayout gl = new GridLayout(7, 7);

		colourPanel.setPreferredSize(d);
		colourPanel.setBackground(Color.LIGHT_GRAY);
		colourPanel.setLayout(gl);

		JLabel l = null;

		for (int i = 0; i < labels.length; i++) {
			l = new JLabel(String.valueOf(i), JLabel.CENTER);
			l.setOpaque(true);
			l.addMouseListener(this.controller);

			this.labels[i] = l;
			colourPanel.add(l);
		}

		reset.setText("Reset");
		mix.setText("Mix");

		mix.setActionCommand(Controller.MIX);
		reset.setActionCommand(Controller.RESET);

		mix.addActionListener(this.controller);
		reset.addActionListener(this.controller);

		buttonPanel.add(mix);
		buttonPanel.add(reset);

		add(colourPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		setTitle("Mosaic");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.buildMenu();
		
		setVisible(true);

	}

	public void paint(Graphics g) {
		super.paint(g);

		Color[] colors = this.model.getColours();

		for (int i = 0; i < colors.length; i++) {
			this.labels[i].setBackground(colors[i]);
		}

	}

}
