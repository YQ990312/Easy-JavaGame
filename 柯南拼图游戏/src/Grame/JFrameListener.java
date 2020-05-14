package Grame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class JFrameListener implements ActionListener {
	private IndexJFrame indexjframe=null;
	private Component one=null;
	private GamePanel gamepanel=null;
	public JFrameListener(IndexJFrame indexjframe,Component one){
		this.indexjframe=indexjframe;
		this.one=one;
	}
	public JFrameListener() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		System.out.println("点击了"+e.getActionCommand());
		gamepanel=new GamePanel();
		indexjframe.remove(one);
		indexjframe.setSuperone(gamepanel);
		gamepanel.StartGame();
//		indexjframe.validate();
//		gamepanel=new GamePanel();
//		panel.removeAll();
//		panel.add(gamepanel);
//		panel.validate();
	}

}
