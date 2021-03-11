package cs2015;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Controller implements ActionListener {

	public static final String ADD = "add";
	public static final String EDIT = "edit";
	public static final String DELETE = "delete";
	public static final String SAVE = "save";
	public static final String ABORT = "abort";

	DefaultListModel<Student> model;
	MasterView view;

	public void initialise(DefaultListModel<Student> model, MasterView view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = (String) ((JButton) e.getSource()).getActionCommand();
		System.out.println(source);
		switch (source) {
		case ADD:
			Student student = new Student();
			student.initialise();
			this.model.addElement(student);
			this.view.list.setSelectedIndex(this.model.getSize() - 1);
			this.view.details.open(student);
			break;

		case EDIT:
			int index = this.view.list.getSelectedIndex();
			if (index < 0) {
				System.err.println("Index ungültig!");
			} else {
				student = (Student) this.model.get(index);
				this.view.details.open(student);
			}
			break;

		case DELETE:
			index = this.view.list.getSelectedIndex();
			if (index < 0) {
				System.err.println("Index ungültig!");
			} else {
				student = (Student) this.model.get(index);
				this.model.removeElement(student);
			}
			break;
			
		case SAVE:
			index = this.view.list.getSelectedIndex();
			if (index < 0) {
				System.err.println("Index ungültig!");
			} else {
				student = (Student) this.model.get(index);
				student = this.view.details.save(student);
				this.view.repaint();
			}
			
			break;
			
		case ABORT:
			this.view.details.abort();
			break;

		default:
			System.err.println("Unbekanntes Source");
			break;
		}
	}

}
