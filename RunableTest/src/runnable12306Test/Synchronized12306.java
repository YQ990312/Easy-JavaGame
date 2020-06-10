package runnable12306Test;

public class Synchronized12306 implements Runnable {
	private int Ticket=99;
	private boolean flag=true;
	
	public Synchronized12306() {
		
	}
	

	public int getTicket() {
		return Ticket;
	}

	public void setTicket(int ticket) {
		Ticket = ticket;
	}


	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(flag) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("线程暂停失败");
				e.printStackTrace();
			}
			SynTest2();
		}
	}
	
	
//	public static void main(String []ags) {
//		Synchronized12306 basic=new Synchronized12306();
//		basic.setTicket(20);
//		
//		new Thread(basic,"杨家齐").start();
//		new Thread(basic,"祝庆江").start();
//		new Thread(basic,"丁志强").start();
//	}
	
	public synchronized void SynTest1() {
		if(Ticket<=0) {
			flag=false;
			return ;
		}
		System.out.println(Thread.currentThread().getName()+"取走了一张票，还剩下---->"+--Ticket);
	}
	
	public void SynTest2() {
		//double Checking 
		if(Ticket<=0) {
			flag=false;
			return;
		}
		synchronized(this) {
			if(Ticket<=0) {
				flag=false;
				return ;
			}
			System.out.println(Thread.currentThread().getName()+"取走了一张票，还剩下---->"+--Ticket);
		}
	}
	
}
