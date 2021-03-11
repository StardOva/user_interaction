package cs2015;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ResourceBundle;

import javax.swing.*;

public class MasterView extends JFrame {

	JList<Student> list;
	Details details;
	ResourceBundle bundle;
	
	public void initialise(DefaultListModel<Student> model, Controller controller, ResourceBundle bundle) {
		this.setTitle("Student Administration Master View");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);
		
		this.bundle = bundle;
		
		Student student = new Student();
		student.initialise();
		model.addElement(student);
		//String interessen[] = { "Politik", "Autos", "Mode", "Film- und Fernsehen", "Computer", "Tiere", "Sport" };

		list = new JList<Student>(model);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.add(list);
		this.add(list, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		initialisePanel(buttonPanel, controller);
		
		this.details = new Details();
		details.initialise(controller, bundle);
		
		this.setVisible(true);
	}

	private void initialisePanel(JPanel panel, Controller controller) {
		this.add(panel, BorderLayout.SOUTH);

		JButton button1 = new JButton(bundle.getString("add"));
		JButton button2 = new JButton(bundle.getString("edit"));
		JButton button3 = new JButton(bundle.getString("delete"));
		
		button1.addActionListener(controller);
		button2.addActionListener(controller);
		button3.addActionListener(controller);
		
		button1.setActionCommand(Controller.ADD);
		button2.setActionCommand(Controller.EDIT);
		button3.setActionCommand(Controller.DELETE);

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
	}
}
