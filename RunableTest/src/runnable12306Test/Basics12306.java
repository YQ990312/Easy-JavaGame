package runnable12306Test;

public class Basics12306 implements Runnable {
	private int Ticket=99;
	
	public Basics12306() {
		
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
		while(true) {
			if(Ticket<=0) break;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("线程暂停失败");
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"取走了一张票，还剩下---->"+--Ticket);
		}
	}
	
	
//	public static void main(String []ags) {
//		Basics12306 basic=new Basics12306();
//		basic.setTicket(20);
//		
//		new Thread(basic,"杨家齐").start();
//		new Thread(basic,"祝庆江").start();
//		new Thread(basic,"丁志强").start();
//	}
	
	
}
