package 带进度条的文件操作;
import javax.swing.*;
import java.io.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.filechooser.*;
public class file1 {
	public file1(File file,JFrame frame) {
		try {
			int n;
			byte[]b=new byte[100];
//			file=filechooser.getSelectedFile();
//			dir=filechooser.getCurrentDirectory().toString();
//			name=filechooser.getSelectedFile().getName();
			FileInputStream in=new FileInputStream(file);
//			Jtext.setText(name);
//			Jtext1.setText(dir);
			ProgressMonitorInputStream input=new ProgressMonitorInputStream(frame,"Loading",in);
			while((n=input.read(b, 0, 100))!=-1) {
				String c=new String(b,0,n);
				System.out.println(c);
				//text.setText(text.getText()+c);
				Thread.sleep(1000);
			}
			input.close();
			JOptionPane.showMessageDialog(frame, "加载完成", "提示", JOptionPane.PLAIN_MESSAGE);
		}
		catch(IOException | InterruptedException a) {
			System.out.println(a);
		}
	}
}
