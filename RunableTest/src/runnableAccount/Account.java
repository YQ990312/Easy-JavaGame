package runnableAccount;

public class Account {
	private String AccountName;
	private int AccountBalance;
	public Account(String accountName, int accountBalance) {
		this.AccountName = accountName;
		this.AccountBalance = accountBalance;
	}
	
	
	
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public int getAccountBalance() {
		return AccountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		AccountBalance = accountBalance;
	}
	
	
}
