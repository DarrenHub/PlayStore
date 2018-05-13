import java.util.ArrayList;

public class Comment {
	private User user; // User who wrote the comment
	private String comment; // The actual comment
	private ArrayList<Comment> reply; // The replies to the comment

	public Comment(User user, String comment) {
		this.user = user;
		this.comment = comment;
		this.reply = new ArrayList<Comment>();
	}
}
