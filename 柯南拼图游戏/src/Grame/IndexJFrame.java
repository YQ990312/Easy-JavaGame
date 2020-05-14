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
		//�����ʼ���ؼ����Լ�һЩ����
		this.setTitle("����ƴͼ��Ϸ"); //����ͷ����ʾ
		this.setBounds(300, 300, 385, 440);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�����˳���ť
		InitMenu();
		setSuperone(welcomepanel);
		AddListenerMenu();
	}
	public void setPanel(Component superone) {
		this.add(superone,BorderLayout.CENTER);
		this.validate();    //һ��ˢ�µ���˼��
		this.setResizable(false);
		this.setVisible(true);
	}
	public void setSuperone(Component suer) {
		this.superone=suer;
		setPanel(suer);
	}
	public void InitMenu() {
		jmenubar=new JMenuBar();
		jmenu=new JMenu("�˵�");
		itemstart=new JMenuItem("��ʼ��Ϸ");
		itemmost=new JMenuItem("��߷�");
		itemsave=new JMenuItem("����");
		itemexit=new JMenuItem("�˳�");
		jmenu.add(itemstart);
		jmenu.add(itemmost);
		jmenu.add(itemsave);
		jmenu.add(itemexit);
		jmenubar.add(jmenu);
		this.setJMenuBar(jmenubar);
	}
	public void AddListenerMenu() {  //���˵���Ӽ�����
		itemstart.addActionListener(new JFrameListener(this,superone));
		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO �Զ����ɵķ������
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO �Զ����ɵķ������
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO �Զ����ɵķ������
				System.out.println(""+contentPane.getSize());
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO �Զ����ɵķ������
			}
			
		});
	}
	
}
