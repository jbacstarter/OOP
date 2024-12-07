package Classes;

import Components.PieChart;

public class User {

	private String username = "NULL", password = "NULL";
	private BankAccount account;
	PieChart userChart;
	public User(String user, String pass) {
		username = user;
		password = pass;
		if(user != null && pass != null) {
			account = new BankAccount(username, password);
			userChart = new PieChart("Expenses", account.getExpenses());
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}
}
