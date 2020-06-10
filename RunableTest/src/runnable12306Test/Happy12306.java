package runnable12306Test;

public class Happy12306 {
	public static void main(String [] ags) {
		Web12306 web12306=new Web12306();
		new Person(web12306,"杨家齐",4).start();
		new Person(web12306,"祝庆江",2).start();
		new Person(web12306,"丁志强",4).start();
	}
}
/**
 * 算继承Thread方法，重写Thread实现功能
 * @author DELL
 *
 */
class Person extends Thread{
	private int Ticket;
	
	public Person(Runnable run,String name,int ticket) {
		super(run,name);
		this.Ticket=ticket;
	}

	public int getTicket() {
		return Ticket;
	}

	public void setTicket(int ticket) {
		Ticket = ticket;
	}
	
}

class Web12306 implements Runnable{
	private int available=8; 
	@Override
	public void run() {
		Person p=(Person)Thread.currentThread();
		System.out.println(Thread.currentThread().getName()+"来买票了,需要"+p.getTicket()+"张票");
		boolean flag=getSeat(p.getTicket());
		if(flag) {
			System.out.println(Thread.currentThread().getName()+"购票成功,还剩余"+available);
		}else {
			System.out.println(Thread.currentThread().getName()+"需要"+p.getTicket()+"余票不足");
			
		}
	}
	public synchronized boolean getSeat(int ticket) {
		if(available<ticket) return false;
		available-=ticket;
		return true;
	}
}
