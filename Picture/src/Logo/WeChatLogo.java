package Logo;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class WeChatLogo {
	/**
	 * 
	 * @param Icon         原图的地址
	 * @param newIcon	   加水印后的地址
	 * @param Logo         水印地址
	 * @param newIconName  加水印后的名称
	 */
	public static void addLogo(String Icon,String Logo,String newIcon,String newIconName) {
		try {
			File FileIcon=new File(Icon);
			File FileLogo=new File(Logo);
			if(!FileIcon.isFile()) {
				System.out.println("这不是一个图片文件");
				return ;
			}
			//将logo加载到内存中
			Image LogeImage=ImageIO.read(FileLogo);
			//logo的高
			int LogoHeight=LogeImage.getHeight(null);
			//logo的宽
			int LogoWeight=LogeImage.getWidth(null);
			
			System.out.println("logo加载成功");
			//将原图加载到内存中
			Image IconImage=ImageIO.read(FileIcon);
			//原图的高
			int IconHeight=IconImage.getHeight(null);
			//原图的宽
			int IconWeight=IconImage.getWidth(null);
			
			System.out.println("原图加载成功");
			//创建一个BufferImage,用原图的宽高设计
			BufferedImage bi=new BufferedImage(IconHeight,IconWeight,BufferedImage.TYPE_INT_RGB);
			//用BufferedImage创建一个画笔
			Graphics2D g=bi.createGraphics();
			
			System.out.println("画笔创建成功");
			//对线段的锯齿状边缘处理
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			 //呈现一个图像，在绘制前进行从图像空间到用户空间的转换
		    g.drawImage(IconImage.getScaledInstance(IconWeight,IconHeight,Image.SCALE_SMOOTH),0,0,null);
		    
		  //水印图象的路径 水印一般为gif或者png的，这样可设置透明度
		    ImageIcon imgIcon = new ImageIcon(Logo);
		      //得到Image对象。
		    Image con = imgIcon.getImage();
		      //透明度，最小值为0，最大值为1
		    float clarity = 0.6f;
		    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,clarity));
		    
		    //在原图上会话
		    //con位上得到的水印实例
		    //中间位加载到原图的位置
		    //最后释放画笔
		    int x=IconWeight-LogoWeight;
		    int y=IconHeight-LogoHeight;
		    g.drawImage(con, x, y, null);
		    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
		    g.dispose();
		    //保存图片
		    File sf = new File(newIcon, newIconName+".jpg");
		    ImageIO.write(bi, "jpg", sf); // 保存图片
		    System.out.println("logo加载成功");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
