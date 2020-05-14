package Grame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {
	private JLabel label=null;
	private JLabel labelIcon=null;
	public WelcomePanel() {
		this.setLayout(new BorderLayout());
		Icon konan=new ImageIcon("konan.jpg");
		label=new JLabel("欢迎您的挑战",JLabel.CENTER);
		labelIcon=new JLabel(konan);
		this.add(label,BorderLayout.NORTH);
		this.add(labelIcon,BorderLayout.CENTER);
		this.setSize(350,410);
		this.validate();    //一个刷新的意思；
		this.setVisible(false);
		this.setVisible(true);
	}
}
