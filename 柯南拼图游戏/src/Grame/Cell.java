package Grame;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *   移动方块的封装类
 * @author DELL
 *
 */
public class Cell extends JButton {
	private static final long serialVersionUID=718623114650657819L;
	public static final int IMAGEWIDTH=117;
	private int place;
	public Cell(Icon icon,int place) {
		this.setIcon(icon);
		this.setBorder(new EmptyBorder(0,0,0,0));
		this.place=place;
		this.setSize(IMAGEWIDTH,IMAGEWIDTH);
		System.out.println("按钮的大小"+this.getSize());
	}
}
