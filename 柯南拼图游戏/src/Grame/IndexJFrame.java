package Grame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class IndexJFrame extends JFrame {
	private JPanel jpanel=null;
	private GamePanel gamepanel=null;
	private JMenu jmenu=null;
	private JMenuBar jmenubar=null;
	private JMenuItem itemstart=null;
	private JMenuItem itemmost=null;
	private JMenuItem itemsave=null;
	private JMenuItem itemexit=null;
	private WelcomePanel welcomepanel=new WelcomePanel();
	private GamePanel gamepanel1=new GamePanel();
	private JFrameListener actionlistener=null;
	private Component superone=null;
	private Container contentPane=this.getContentPane();
	
	public IndexJFrame() {
		//这里初始化控件，以及一些布局
		this.setTitle("柯南拼图游戏"); //设置头部提示
		this.setBounds(300, 300, 385, 440);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置退出按钮
		InitMenu();
		setSuperone(welcomepanel);
		AddListenerMenu();
	}
	public void setPanel(Component superone) {
		this.add(superone,BorderLayout.CENTER);
		this.validate();    //一个刷新的意思；
		this.setResizable(false);
		this.setVisible(true);
	}
	public void setSuperone(Component suer) {
		this.superone=suer;
		setPanel(suer);
	}
	public void InitMenu() {
		jmenubar=new JMenuBar();
		jmenu=new JMenu("菜单");
		itemstart=new JMenuItem("开始游戏");
		itemmost=new JMenuItem("最高分");
		itemsave=new JMenuItem("保存");
		itemexit=new JMenuItem("退出");
		jmenu.add(itemstart);
		jmenu.add(itemmost);
		jmenu.add(itemsave);
		jmenu.add(itemexit);
		jmenubar.add(jmenu);
		this.setJMenuBar(jmenubar);
	}
	public void AddListenerMenu() {  //给菜单添加监听器
		itemstart.addActionListener(new JFrameListener(this,superone));
		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO 自动生成的方法存根
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO 自动生成的方法存根
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO 自动生成的方法存根
				System.out.println(""+contentPane.getSize());
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO 自动生成的方法存根
			}
			
		});
	}
	
}
