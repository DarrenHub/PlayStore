import java.util.ArrayList;

public class User {
	private String id; // User ID
	private String name; // User name
	private String phone; // Phone number
	private double balance; // User account balance
	private OS os; // Operating System of the user
	private boolean isPremium; // Whether the user is a premium user

	private ArrayList<String> contentsBought; // List of names of all contents bought

	public User(String id, String name, String phone, double balance, OS os) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.balance = balance;
		this.os = os;
		this.isPremium = false;
		this.contentsBought = new ArrayList<String>();
	}

	public User(String id, String name, String phone, OS os) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.balance = 0; // Default balance to 0 when balance is not passed as an argument
		this.os = os;
		this.isPremium = false;
		this.contentsBought = new ArrayList<String>();
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void becomePremium() {
		// Check if the user is already a premium user.
		if (this.isPremium) {
			System.err.println("This user is already a premium user.");
			return;
		}

		/*
		 * Try to deduct $100 premium fee and set the user to be premium. If an
		 * exception is thrown, the user will stay non-premium.
		 */
		try {
			this.spendMoney(100);
			this.isPremium = true;
		} catch (UserBalanceException ube) {
			System.err.println("Error: " + ube.getReason());
			System.err.println("\nPremium account upgrade failed.\n");
		} finally {
			System.out.println("Premium User Status: " + this.isPremium + "\n");
		}
	}

	public void buyContent(Content item) {
		// If the user is premium user, set the discount to 0.8 (20% off)
		double discount = 1; // default discount is 1 (no discount)
		if (this.isPremium) {
			discount = 0.8;
		}

		// Check OS compatibility if the content is a game.
		if (item instanceof Game) {
			try {
				this.checkCompatibility((Game) item);
			} catch (IncompatibleOsException ioe) {
				System.err.println("Error: " + ioe.getReason());
				System.err.println("\nFailed to buy " + item.getName() + "\n");
				return;
			}
		}

		double cost = item.getPrice() * discount; // Set the final cost of the content
		try {
			this.spendMoney(cost);
			this.contentsBought.add(item.getName()); // Add the content to the user's content list
			item.incrementNumDownloads(); // Increment the number of downloads of the content
			System.out.println("Congrats! " + this.name + " has successfully purchased " + item.getName());
		} catch (UserBalanceException ube) {
			System.err.println("Error: " + ube.getReason());
			System.err.println("\nFailed to buy " + item.getName() + "\n");
		}
	}

	public void showContentsBought() {
		System.out.println(this.name + " has purchased the following items:\n");
		for (int i = 0; i < this.contentsBought.size(); i++) {
			System.out.println(this.contentsBought.get(i));
		}
		System.out.println("End of the list.\n");
	}

	private void checkCompatibility(Game g) throws IncompatibleOsException {
		String userOS = this.os.getType(); // Get the OS type of the user
		String requiredOS = g.getOsReq().getType(); // Get the required OS type of the game

		int userOSVer = this.os.getVersion(); // Get the OS version of the user
		int requiredOSVer = g.getOsReq().getVersion(); // Get the required OS version of the user

		if (userOS.compareTo(requiredOS) != 0) {
			throw new IncompatibleOsException(
					"Mismatched Operating System: \nRequired: " + requiredOS + "\nCurrent: " + userOS + "\n");
		}

		if (userOSVer < requiredOSVer) {
			throw new IncompatibleOsException(
					"OS version too low: \nMinimum Required: " + requiredOSVer + "\nCurrent" + userOSVer + "\n");
		}
	}

	private void spendMoney(double expense) throws UserBalanceException {
		if (expense < 0) {
			throw new UserBalanceException("Negative expense not allowed.");
		}

		if (this.balance < expense) {
			throw new UserBalanceException("Insufficient fund.");
		}

		this.balance -= expense;
	}
}
