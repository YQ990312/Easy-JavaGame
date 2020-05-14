package Grame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private Cell[] cells=new Cell[9];
	public GamePanel() {
		init();
		this.validate();    //一个刷新的意思；
		//this.setVisible(false);
		this.setVisible(true);
	}
	public void init() {
		Cell cell=null;
		int num=0;
		Icon icon=null;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				num=i*3+j;
				icon=new ImageIcon(num+".jpg");
				cell=new Cell(icon,num);
				cell.setLocation(i*Cell.IMAGEWIDTH,j*Cell.IMAGEWIDTH);
				cells[num]=cell;
			}
		}
		for(int i=0;i<9;i++) {
			this.add(cells[i]);
		}
	}
	public void StartGame() {
		int x,y,m,n;
		Random random=new Random();
		m=random.nextInt(cells.length);
		n=random.nextInt(cells.length);
	}
}
