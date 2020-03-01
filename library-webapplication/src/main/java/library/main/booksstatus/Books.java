package library.main.booksstatus;

public class Books {
	
	private String bookId;
	private String name;
	private String type;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Books() {
		super();
	}
	public Books(String bookId, String name, String type, String status) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.type = type;
		this.status = status;
	}
	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
