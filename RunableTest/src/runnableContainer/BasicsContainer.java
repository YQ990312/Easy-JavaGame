package runnableContainer;

import java.util.ArrayList;
import java.util.List;

public class BasicsContainer {
	public static void main(String [] ags) {
		List<String> mylist=new ArrayList<String>();
		for(int i=0;i<100;i++) {
			new Thread(()-> {
				mylist.add(Thread.currentThread().getName());
			}).start();
		}
		System.out.println("线程不安全"+mylist.size());
	}
}
