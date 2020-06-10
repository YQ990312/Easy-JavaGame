package runnableHappyCinema;

public class BasicsHappyCinema {
//	public static void main(String [] ags) {
//		Customer one=new Customer(20);
//		Customer two=new Customer(30);
//		
//		new Cinema(one,"星河").start();
//		new Cinema(two,"星河").start();
//	}
}


class Customer implements Runnable {
	private int needTicket;
	
	public Customer(int ticket) {
		this.needTicket=ticket;
	}

	@Override
	public void run() {buyTicket();
//		synchronized(cinema) {
//			boolean flag=cinema.bookTicket(needTicket);
//			if(flag) {
//				System.out.println(cinema.getCinemaName()+"预定成功还剩余"+cinema.getAvailable());
//			}else {
//				System.out.println(cinema.getCinemaName()+"预定失败"+cinema.getAvailable());
//			}
//		}
	}
	
	public synchronized void buyTicket() {

		Cinema cinema=(Cinema)Thread.currentThread();
		System.out.println("来的用户"+Thread.currentThread().getName()+"需要"+needTicket);
		boolean flag=cinema.bookTicket(needTicket);
		if(flag) {
			System.out.println(cinema.getCinemaName()+"预定成功还剩余"+cinema.getAvailable());
		}else {
			System.out.println(cinema.getCinemaName()+"预定失败"+cinema.getAvailable());
		}
	}
	
	
	
}

class Cinema extends Thread{
	private int available=40; 
	private String cinemaName;
	public Cinema(Runnable run,String name) {
		super(run,name);
		this.cinemaName=name;
	}
	
	public void checkingTicket() {
		
	}
	
	public boolean bookTicket(int needTicket) {
		if(needTicket>available) {
			System.out.println("不足");
			return false;
		}
		
		available-=needTicket;
		return true;
	}
	
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	
	
}