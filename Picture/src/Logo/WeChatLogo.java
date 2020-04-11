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
	 * @param Icon         ԭͼ�ĵ�ַ
	 * @param newIcon	   ��ˮӡ��ĵ�ַ
	 * @param Logo         ˮӡ��ַ
	 * @param newIconName  ��ˮӡ�������
	 */
	public static void addLogo(String Icon,String Logo,String newIcon,String newIconName) {
		try {
			File FileIcon=new File(Icon);
			File FileLogo=new File(Logo);
			if(!FileIcon.isFile()) {
				System.out.println("�ⲻ��һ��ͼƬ�ļ�");
				return ;
			}
			//��logo���ص��ڴ���
			Image LogeImage=ImageIO.read(FileLogo);
			//logo�ĸ�
			int LogoHeight=LogeImage.getHeight(null);
			//logo�Ŀ�
			int LogoWeight=LogeImage.getWidth(null);
			
			System.out.println("logo���سɹ�");
			//��ԭͼ���ص��ڴ���
			Image IconImage=ImageIO.read(FileIcon);
			//ԭͼ�ĸ�
			int IconHeight=IconImage.getHeight(null);
			//ԭͼ�Ŀ�
			int IconWeight=IconImage.getWidth(null);
			
			System.out.println("ԭͼ���سɹ�");
			//����һ��BufferImage,��ԭͼ�Ŀ�����
			BufferedImage bi=new BufferedImage(IconHeight,IconWeight,BufferedImage.TYPE_INT_RGB);
			//��BufferedImage����һ������
			Graphics2D g=bi.createGraphics();
			
			System.out.println("���ʴ����ɹ�");
			//���߶εľ��״��Ե����
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			 //����һ��ͼ���ڻ���ǰ���д�ͼ��ռ䵽�û��ռ��ת��
		    g.drawImage(IconImage.getScaledInstance(IconWeight,IconHeight,Image.SCALE_SMOOTH),0,0,null);
		    
		  //ˮӡͼ���·�� ˮӡһ��Ϊgif����png�ģ�����������͸����
		    ImageIcon imgIcon = new ImageIcon(Logo);
		      //�õ�Image����
		    Image con = imgIcon.getImage();
		      //͸���ȣ���СֵΪ0�����ֵΪ1
		    float clarity = 0.6f;
		    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,clarity));
		    
		    //��ԭͼ�ϻỰ
		    //conλ�ϵõ���ˮӡʵ��
		    //�м�λ���ص�ԭͼ��λ��
		    //����ͷŻ���
		    int x=IconWeight-LogoWeight;
		    int y=IconHeight-LogoHeight;
		    g.drawImage(con, x, y, null);
		    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
		    g.dispose();
		    //����ͼƬ
		    File sf = new File(newIcon, newIconName+".jpg");
		    ImageIO.write(bi, "jpg", sf); // ����ͼƬ
		    System.out.println("logo���سɹ�");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
