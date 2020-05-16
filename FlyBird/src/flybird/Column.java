package flybird;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Column {
	
	private BufferedImage image;
	//宽高
	private int height=0,weight=0;
	
	private int x=0,y=0;
	
	Random random = new Random();
	
	//间隙
	private int gap=0;
	//间隔
	private int distance=0;
	
	public Column() {
		
	}
	
	public Column(int n) throws IOException {
		image=ImageIO.read(getClass().getResource("../column.png"));
		height=image.getHeight();
		weight=image.getWidth();
		gap = 144;
        distance = 245;
        x = 550 + (n - 1) * distance;
        y = random.nextInt(218) + 132;
	}
	
	public void runstep() {
		 x--;
	     if(x == -weight / 2) {
	           x = distance * 2 - weight / 2;
	           y = random.nextInt(218) + 132;
	     }
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
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

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
	
}
