
public class User {
	private String id; // User ID
	private String name; // User name
	private String phone; // Phone number
	private double balance; // User account balance
	private OS os; // Operating System of the user

	public User(String id, String name, String phone, double balance, OS os) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.balance = balance;
		this.os = os;
	}

	public User(String id, String name, String phone, OS os) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.balance = 0; // Default balance to 0 when balance is not passed as an argument
		this.os = os;
	}
}
