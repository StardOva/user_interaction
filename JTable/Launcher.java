package jtableTest;

import javax.swing.*;

public class Launcher {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Tabelle du Kek");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[][] data = new String[][] { { "a", "b", "c", "d" }, { "e", "f", "g", "h" }, { "i", "j", "k", "l" } };

		// Die Column-Titles
		String[] title = new String[] { "A", "B", "C", "D" };

		JTable table = new JTable(data, title);

		JScrollPane scrollPane = new JScrollPane(table);

		frame.add(scrollPane);

		frame.pack();
		frame.setVisible(true);
	}
}
