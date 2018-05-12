
public abstract class Content {
	private String id;
	private String name;
	private double price;
	private int numDownloads; // Number of downloads
	// private Array review....

	public Content(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.numDownloads = 0;
		// this.review....
	}
}
