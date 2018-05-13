import java.util.ArrayList;

public abstract class Content {
	private String id; // Content ID
	private String name; // Content name
	private double price; // Content price
	private int numDownloads; // Number of downloads
	private ArrayList<Comment> review;

	public Content(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.numDownloads = 0;
		this.review = new ArrayList<Comment>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getNumDownloads() {
		return numDownloads;
	}
}
