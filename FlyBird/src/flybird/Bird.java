package flybird;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird {
	
	private BufferedImage image;
	private int weight,height;
	private int x,y;
	private int size;
	private BufferedImage[] images;
	private int index;
	
	// 重力加速度
    private double g;
    // 位移的间隔时间
    private double t;
    // 最初上抛速度
    private double v0;
    // 当前上抛速度
    private double speed;
    // 经过时间t之后的位移
    private double s;
    // 小鸟的倾角（弧度）
    private double alpha;
	
	public Bird() throws IOException {
		image=ImageIO.read(getClass().getResource("../0.png"));
		weight=image.getWidth();
		height=image.getHeight();
		x = 132;
	    y = 280;
	    size = 40;
	    images=new BufferedImage[8];
	    for(int i=0;i<8;i++) {
	    	images[i]=ImageIO.read(getClass().getResource("../"+i+".png"));
	    }
	    index=0;
	    
	   
	    // 初始化位移参数
        g = 4;
        v0 = 20;
        t = 0.25;
        speed = v0;
        s = 0;
        alpha = 0;
	    
	}
	
	public void birdFly() {
		index++;
		System.out.println("下标"+index);
		image=images[(index/12)%8];
		if(index>=100) index=12;
	}
	
	
	 // 移动一步
    public void step() {
        double v0 = speed;
        // 计算上抛运动位移
        s = v0 * t + g * t * t / 2;
        // 计算鸟的坐标位置
        y = y - (int) s;
        // 计算下次移动速度
        double v = v0 - g * t;
        speed = v;
        // 计算倾角（反正切函数）
        alpha = Math.atan(s / 8);
    }

    // 向上飞行
    public void flappy() {
        // 重置速度
        speed = v0;
    }

    // 检测小鸟是否碰撞到地面
    public boolean hit(Ground ground) {
        boolean hit = y + size / 2 > ground.getY();
        if (hit) {
            y = ground.getY() - size / 2;
            alpha = -3.14159265358979323 / 2;
        }
        return hit;
    }

    // 检测小鸟是否撞到柱子
    public boolean hit(Column column) {
        // 先检测是否在柱子的范围内
        if (x > column.getX() - column.getWeight() / 2 - size / 2
                && x < column.getX() + column.getWeight() / 2 + size / 2) {
            // 再检测是否在柱子的缝隙中
            if (y > column.getY() - column.getGap() / 2 + size / 2
                    && y < column.getY() + column.getGap() / 2 - size / 2) {
                return false;
            }
            return true;
        }
        return false;
    }
	
	

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public BufferedImage[] getImages() {
		return images;
	}

	public void setImages(BufferedImage[] images) {
		this.images = images;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}

	public double getV0() {
		return v0;
	}

	public void setV0(double v0) {
		this.v0 = v0;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getS() {
		return s;
	}

	public void setS(double s) {
		this.s = s;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}
	
	
		
}
