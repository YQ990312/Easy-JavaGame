package flybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BirdGame extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//初始化背景
	private BufferedImage background;
	//初始化开始图片
	private BufferedImage startImage;
	//初始化结束图片
	private BufferedImage overImage;
	//地面
	private Ground ground;
	//柱子
	private Column column1,column2;
	
	private Bird bird;
	
	private int type=0;
	
	private int sorce=0;
	
	public BirdGame() throws IOException {
		background=ImageIO.read(getClass().getResource("../bg.png"));
		startImage=ImageIO.read(getClass().getResource("../start.png"));
		overImage=ImageIO.read(getClass().getResource("../gameover.png"));
		
		ground=new Ground();
		column1=new Column(1);
		column2=new Column(2);
		
		bird=new Bird();
		
		type=FlyBirdData.START;
		
		sorce=0;
		
	}
	
	public void paint(Graphics g){
		 g.drawImage(background, 0, 0, null);
		 
	    // 绘制地面
	    g.drawImage(ground.getBackground(), ground.getX(), ground.getY(), null);
	    
	    //绘制柱子
	    g.drawImage(column1.getImage(), column1.getX()-column1.getWeight()/2, column1.getY()-column1.getHeight()/2, null);
	    g.drawImage(column2.getImage(), column2.getX()-column2.getWeight()/2, column2.getY()-column2.getHeight()/2, null);
	    
//	    g.drawImage(column1.getImage(), column1.getX(), column1.getY(), null);
//	    g.drawImage(column2.getImage(), column2.getX(), column2.getY(), null);
	    
	 // 绘制小鸟（旋转坐标系）
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(-bird.getAlpha(), bird.getX(), bird.getY());
        g.drawImage(bird.getImage(), bird.getX() - bird.getWeight() / 2, bird.getY() - bird.getHeight() / 2, null);
        g2.rotate(bird.getAlpha(), bird.getX(), bird.getY());
	    
	 // 绘制分数
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 40);
        g.setFont(f);
        g.drawString("" + sorce, 40, 60);
        g.setColor(Color.WHITE);
        g.drawString("" + sorce, 40 - 3, 60 - 3);
	    
	 // 绘制开始与结束界面
        switch (type) {
            case FlyBirdData.START:
                g.drawImage(startImage, 0, 0, null);
                break;
            case FlyBirdData.FINAl:
                g.drawImage(overImage, 0, 0, null);
                break;
        }

	}
	
	public void birdAction() throws InterruptedException {
		
	        // 鼠标监听器
	        MouseListener l = new MouseAdapter() {
	            // 鼠标按下事件
	            public void mousePressed(MouseEvent e) {
	                try {
	                    switch (type) {
	                        case FlyBirdData.START:
	                            // 在开始状态，按下鼠标则转为运行状态。
	                        	type = FlyBirdData.RUNNING;
	                            break;
	                        case FlyBirdData.RUNNING:
	                            // 在运行状态，按下鼠标则小鸟向上飞行。
	                            bird.flappy();
	                            break;
	                        case FlyBirdData.FINAl:
	                            // 在结束状态，按下鼠标则重置数据，再次转为开始态。
	                            column1 = new Column(1);
	                            column2 = new Column(2);
	                            bird = new Bird();
	                            sorce = 0;
	                            type = FlyBirdData.START;
	                            break;
	                    }
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        };

	        // 将监听器添加到当前的面板上
	        addMouseListener(l);
		
		
		while(true) {
			 switch (type) {
             case FlyBirdData.START:
                 // 小鸟做出飞行动作
                 bird.birdFly();;
                 // 地面向左移动一步
                 ground.moveStop();
                 break;
             case FlyBirdData.RUNNING:
                 // 地面向左移动一步
            	 ground.moveStop();
                 // 柱子向左移动一步
                 column1.runstep();
                 column2.runstep();
                 // 小鸟做出飞行动作
                 bird.birdFly();
                 // 小鸟上下移动一步
                 bird.step();
                 // 计算分数
                 if (bird.getX() == column1.getY() || bird.getX() == column2.getX()) {
                     sorce++;
                 }
                 // 检测是否发生碰撞
                 if (bird.hit(ground) || bird.hit(column1) || bird.hit(column2)) {
                     type = FlyBirdData.FINAl;
                 }
                 break;
         }
			 repaint();
	            // 休眠 1000/60 毫秒
	        Thread.sleep(1000 / 60);
		}
	}
}
