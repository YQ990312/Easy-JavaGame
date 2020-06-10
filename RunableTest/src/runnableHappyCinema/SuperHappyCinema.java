package runnableHappyCinema;

import java.util.ArrayList;
import java.util.List;

public class SuperHappyCinema {
	public static void main(String [] ags) {
		List<Integer> list=new ArrayList<Integer> ();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(6);
		list.add(7);
		list.add(8);
		Cinema01 cinema=new Cinema01("星河",list);
		List<Integer> list1=new ArrayList<Integer> ();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		Customer01 customer=new Customer01("杨家齐",list1,cinema);
		new Thread(customer).start();
	}
}

class Customer01 implements Runnable{
	private String name;
	private List<Integer> ticketList;
	private Cinema01 cinema;
	
	
	public Customer01(String name,List<Integer> list,Cinema01 cinema) {
		this.name=name;
		this.ticketList=list;
		this.cinema=cinema;
	}
	
	@Override
	public void run() {
		synchronized(cinema) {
			boolean flag=cinema.bookingTicket(ticketList);
			if(flag) {
				System.out.println("预定成功");
			}else {
				System.out.println("预定失败");
			}
		}
	}
	
}

class Cinema01{
	private String cinemaName;
	private List<Integer> available;
	
	public Cinema01(String name,List<Integer> list) {
		this.cinemaName=name;
		this.available=list;
	}
	
	public boolean bookingTicket(List<Integer> list) {
		if(list.size()==0) return false;
		List<Integer> copy=new ArrayList<Integer>();
		copy.addAll(available);
		
		copy.removeAll(list);
		
		if(available.size()-list.size()!=copy.size()) return false;
		
		return true;
	}
}