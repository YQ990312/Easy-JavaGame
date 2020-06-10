package runnableAccount;

public class AccountMain {
	public static void main(String []ags) {
		Account account=new Account("旅游的钱",100);
		SynchronizedAccound mySelf=new SynchronizedAccound(account,60);
		SynchronizedAccound myGirlFriends=new SynchronizedAccound(account,40);
		new Thread(mySelf,"杨家齐").start();
		new Thread(myGirlFriends,"李智恩").start();
	}
}
