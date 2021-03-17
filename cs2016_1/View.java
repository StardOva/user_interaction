package cs2016_1;

import java.awt.*;

import javax.swing.*;

public class View extends JFrame {

	private Model model;
	private JLabel[] labels;

	public void initialise(Model model, Controller controller) {
		this.setTitle("Puzzle Game");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.model = model;

		labels = new JLabel[Model.SIZE];

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));

		for (int i = 0; i < Model.SIZE; i++) {
			JLabel label = new JLabel();
			label.setIcon(this.model.getImage(i));
			label.addMouseListener(controller.mouseController);

			labels[i] = label;
			panel.add(label);
		}

		// Toolbar
		JToolBar toolBar = new JToolBar();

		JButton exit = new JButton("Exit");
		exit.setActionCommand(ActionController.EXIT);
		exit.setToolTipText("Closes the program");
		exit.addActionListener(controller.actionController);

		JButton sort = new JButton("Sort");
		sort.setActionCommand(ActionController.SORT);
		sort.setToolTipText("Sorts the puzzle");
		sort.addActionListener(controller.actionController);

		JButton randomise = new JButton("Randomise");
		randomise.setActionCommand(ActionController.RANDOMISE);
		randomise.setToolTipText("Randomises the puzzle");
		randomise.addActionListener(controller.actionController);

		toolBar.add(exit);
		toolBar.addSeparator();
		toolBar.add(sort);
		toolBar.addSeparator();
		toolBar.add(randomise);

		toolBar.setRollover(true);
		this.add(toolBar, BorderLayout.NORTH);

		this.add(panel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < Model.SIZE; i++) {
			JLabel label = labels[i];
			label.setIcon(model.getImage(i));
		}
	}
}
