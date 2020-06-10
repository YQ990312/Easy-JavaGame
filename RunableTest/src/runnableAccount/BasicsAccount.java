package runnableAccount;
/*
 * 线程不安全的取钱
 * 
 */
public class BasicsAccount implements Runnable {
	private Account myAccount;
	private int takeOutMoney;
	private int myNowMoney;
	
	public BasicsAccount(Account myAccount, int takeOutMoney) {
		this.myAccount = myAccount;
		this.takeOutMoney = takeOutMoney;
	}
	

	public Account getMyAccount() {
		return myAccount;
	}

	public void setMyAccount(Account myAccount) {
		this.myAccount = myAccount;
	}

	public int getTakeOutMoney() {
		return takeOutMoney;
	}

	public void setTakeOutMoney(int takeOutMoney) {
		this.takeOutMoney = takeOutMoney;
	}

	public int getMyNowMoney() {
		return myNowMoney;
	}

	public void setMyNowMoney(int myNowMoney) {
		this.myNowMoney = myNowMoney;
	}




	@Override
	public void run() {
		if(takeOutMoney>myAccount.getAccountBalance()) {
			System.out.println("余额不足");
			return;
		}

		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		myAccount.setAccountBalance(myAccount.getAccountBalance()-takeOutMoney);
		myNowMoney+=takeOutMoney;
		System.out.println(Thread.currentThread().getName()+"取出了"+takeOutMoney);
		System.out.println("账户剩余"+myAccount.getAccountBalance());
		System.out.println(Thread.currentThread().getName()+"口袋中有"+myNowMoney);
		
	}
	
}
