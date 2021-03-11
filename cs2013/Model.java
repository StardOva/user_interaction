package example2;

import java.awt.*;
import java.util.Random;

public class Model {

	private Color[] colors = null;
	private Color storedColor = null;
	
	public void initiliase() {
		this.colors = new Color[49];
		this.mixAllColors();
	}

	public Color[] getColours() {
		return colors;
	}

	public void setColours(Color[] colours) {
		this.colors = colours;
	}

	public Color getStoredColor() {
		return storedColor;
	}

	public void setStoredColor(Color storedColor) {
		this.storedColor = storedColor;
	}

	public Color getRandomColor() {

		Random r = new Random();
		return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
	}

	public void mixOneColor(int i) {
		this.colors[i] = getRandomColor();
	}

	public void mixAllColors() {
		for (int i = 0; i < this.colors.length; i++) {
			this.mixOneColor(i);
		}
	}

	public void resetAllColors() {
		for (int i = 0; i < this.colors.length; i++) {
			this.colors[i] = Color.WHITE;
		}
	}
	
	public void copyColor(int i, Color color) {
		this.colors[i] = color;
	}

}
