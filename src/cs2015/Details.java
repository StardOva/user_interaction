package cs2015;

import java.awt.*;
import java.util.ResourceBundle;

import javax.swing.*;

public class Details extends JDialog {

	JTextField lastName;
	JTextField firstName;
	JTextField dayOfBirth;
	JTextField skills;
	
	ResourceBundle bundle;

	public void initialise(Controller controller, ResourceBundle bundle) {
		
		this.bundle = bundle;
		
		lastName = new JTextField();
		firstName = new JTextField();
		dayOfBirth = new JTextField();
		skills = new JTextField();

		JLabel lastNameLabel = new JLabel(bundle.getString("lastName"));
		JLabel firstNameLabel = new JLabel(bundle.getString("firstName"));
		JLabel dayOfBirthLabel = new JLabel(bundle.getString("dayOfBirth"));
		JLabel skillsLabel = new JLabel(bundle.getString("skills"));

		JButton save = new JButton(bundle.getString("save"));
		save.addActionListener(controller);
		save.setActionCommand(Controller.SAVE);

		JButton abort = new JButton(bundle.getString("abort"));
		abort.addActionListener(controller);
		abort.setActionCommand(Controller.ABORT);

		this.setLayout(new GridLayout(5, 2));

		this.add(lastNameLabel);
		this.add(lastName);

		this.add(firstNameLabel);
		this.add(firstName);

		this.add(dayOfBirthLabel);
		this.add(dayOfBirth);

		this.add(skillsLabel);
		this.add(skills);

		this.add(save);
		this.add(abort);

		this.setTitle("Details");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setModal(true);
		this.setSize(new Dimension(250, 200));
	}

	public void open(Student student) {
		this.lastName.setText(student.lastName);
		this.firstName.setText(student.firstName);
		this.dayOfBirth.setText(student.dayOfBirth);
		this.skills.setText(student.skills);
		this.setVisible(true);
	}

	public Student save(Student student) {
		student.lastName = this.lastName.getText();
		student.firstName = this.firstName.getText();
		student.dayOfBirth = this.dayOfBirth.getText();
		student.skills = this.skills.getText();

		this.setVisible(false);
		
		return student;
	}

	public void abort() {
		this.setVisible(false);
	}
}
