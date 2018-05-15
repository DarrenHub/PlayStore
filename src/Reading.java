
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

	public String getGenre() {
		return this.genre;
	}
}
