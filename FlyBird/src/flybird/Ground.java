package flybird;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ground {
	
	private BufferedImage background;
	public BufferedImage getBackground() {
		return background;
	}

	public void setBackground(BufferedImage background) {
		this.background = background;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int height=0,weight=0;
	private int x=0,y=0;
	
	public Ground() throws IOException {
		background=ImageIO.read(getClass().getResource("../ground.png"));
		height=background.getHeight();
		weight=background.getWidth();
		x=0;
		y=500;
	}
	
	public void moveStop() {
		x--;
		if(x==-109) x=0;
	}
	
	

}
