package 带进度条的文件操作;
import javax.swing.*;
import java.io.*;
public class progressmoitor{
	public static void main(String[] args){
		// TODO 自动生成的方法存根
//		byte [] a=new byte[100];
//		int n=0;
//		File file=new File("score.dat");
//		try {
//			FileInputStream input=new FileInputStream(file);
//			ProgressMonitorInputStream in=new ProgressMonitorInputStream(null,"Loading",input);
//			ProgressMonitor monitor=in.getProgressMonitor();
//			while((n=input.read(a,0,100))!=-1) {
//				String str=new String(a,0,n);
//				System.out.println(str);
//				Thread.sleep(1000);
//			}
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
		progessmoitor progress=new progessmoitor();
	}

}
