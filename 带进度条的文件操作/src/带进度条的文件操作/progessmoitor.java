package 带进度条的文件操作;
import java.awt.FlowLayout;
import java.io.*;
import javax.swing.*;
public class progessmoitor extends JFrame{
	public progessmoitor(){
//		this.setBounds(100, 100, 300, 300);
//		this.setVisible(true);
		byte [] a=new byte[100];
		int n=0;
		this.setVisible(true);
		this.setBounds(300,300,500,500);
		this.setLayout(new FlowLayout());
		File file=new File("score.dat");
		try {
			FileInputStream input=new FileInputStream(file);
			ProgressMonitorInputStream in=new ProgressMonitorInputStream(this,"Loading",input);
			//ProgressMonitor monitor=new ProgressMonitor(null, "Progress of Thread", "Not Started", 100, 100);
			//monitor=in.getProgressMonitor();
//			monitor.setMillisToDecideToPopup(100);
//			in.available();
			while((n=in.read(a,0,100))!=-1) {
				String str=new String(a,0,n);
				System.out.println(str);
				Thread.sleep(1000);
			}
			in.close();
		}
		catch(IOException | InterruptedException e) {
			System.out.println(e);
		}
	}
}
