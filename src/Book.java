
public class Book extends Reading {
	private String[] author;

	public Book(String id, String name, double price, String publisher, String genre, int numPages, String[] author) {
		super(id, name, price, publisher, genre, numPages);
		this.author = new String[author.length];
		System.arraycopy(author, 0, this.author, 0, author.length);
	}

	public Book(String id, String name, String publisher, String genre, int numPages, String[] author) {
		super(id, name, publisher, genre, numPages);
		System.arraycopy(author, 0, this.author, 0, author.length);
	}
}
