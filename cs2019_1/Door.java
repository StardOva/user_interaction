package cs2019_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.text.DecimalFormat;

import javax.swing.*;

public class Door extends JPanel implements Serializable, ActionListener {

	public static final String COVER = "cover";
	public static final String CONTENT = "content";

	private JButton cover;
	private JLabel content;
	private transient CardLayout cardLayout;

	public void initialise(int index) {

		cover = new JButton();
		content = new JLabel();
		cardLayout = new CardLayout();

		cover.setBackground(Color.GREEN);
		cover.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
		cover.setText(String.valueOf(index + 1));
		cover.addActionListener(this);

		content.setHorizontalAlignment(getWidth() / 2);
		DecimalFormat df = new DecimalFormat("00");

		ImageIcon icon = new ImageIcon("src/cs2019_1/image/" + df.format(index + 1) + ".png");
		content.setIcon(icon);

		// cardLayout.addLayoutComponent(cover, COVER);
		// cardLayout.addLayoutComponent(content, CONTENT);

		this.add(cover);
		this.add(content);
		this.setLayout(cardLayout);
		this.setBackground(Color.WHITE);
	}

	public Door() {

	}

	public JButton getCover() {
		return cover;
	}

	public void setCover(JButton cover) {
		this.cover = cover;
	}

	public JLabel getContent() {
		return content;
	}

	public void setContent(JLabel content) {
		this.content = content;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.cardLayout.next(this);
		String coverText = this.cover.getText();
		
		if (coverText.equals("6")) {
			JOptionPane pane = new JOptionPane();
			ImageIcon icon = new ImageIcon("src/cs2019_1/image/nikolaus.gif");
			pane.setIcon(icon);
			JOptionPane.showMessageDialog(this, "Es ist Nikolaustag!", "Sankt Nikolaus", JOptionPane.PLAIN_MESSAGE, icon);
		}
	}

}
