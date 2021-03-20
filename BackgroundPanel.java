package cs2019_1;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BackgroundPanel extends JPanel {

	public static int INDEX = 0;

	public void initialise() {
		this.getInsets().set(50, 50, 50, 50);

		GridLayout gridLayout = new GridLayout(4, 6, 10, 10);
		this.setLayout(gridLayout);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		try {
			BufferedImage background = ImageIO.read(new File("src/cs2019_1/image/background.jpeg"));
			g.drawImage(background, 0, 0, 1024, 768, null);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
