package cs2016_1;

import java.util.Random;

import javax.swing.*;

public class Model {

	public static final int SIZE = 16;

	private Icon[] images;
	private int[] position;

	public void initialise() {
		images = new Icon[SIZE];
		position = new int[SIZE];
		
		System.out.println(System.getProperty("user.dir"));
		
		for (int i = 0; i < SIZE; i++) {
			Icon icon = new ImageIcon("src/cs2016_1/image/" + i + ".png");
			System.out.println(icon.getIconHeight());
			images[i] = icon;
		}
		this.randomise();
	}

	public void sort() {
		for (int i = 0; i < SIZE; i++) {
			position[i] = i;
		}
	}

	public void randomise() {

		for (int i = 0; i < SIZE; i++) {
			position[i] = -1;
		}

		for (int i = 0; i < SIZE; i++) {
			position[i] = getRandomPosition();
			System.out.println(position[i]);
		}
	}

	private int getRandomPosition() {
		Random random = new Random();
		int randomInt;
		do {
			randomInt = random.nextInt(SIZE);
		} while (exists(randomInt));
		return randomInt;
	}

	private boolean exists(int randomInt) {
		for (int i = 0; i < SIZE; i++) {
			if (position[i] == randomInt) {
				return true;
			}
		}
		return false;
	}

	public Icon getImage(int index) {
		if (index < SIZE) {
			return images[position[index]];
		}
		return null;
	}

	public Icon[] getImages() {
		return images;
	}

	public void setImages(Icon[] images) {
		this.images = images;
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

}
