
public abstract class Reading extends Content {
	private String publisher;
	private String genre;
	private int numPages; // Number of pages

	public Reading(String id, String name, double price, String publisher, String genre, int numPages) {
		super(id, name, price);
		this.publisher = publisher;
		this.genre = genre;
		this.numPages = numPages;
	}

	public Reading(String id, String name, String publisher, String genre, int numPages) {
		super(id, name, 0); // Default price to 0 (free) when price is not passed as an argument
		this.publisher = publisher;
		this.genre = genre;
		this.numPages = numPages;
	}
}
