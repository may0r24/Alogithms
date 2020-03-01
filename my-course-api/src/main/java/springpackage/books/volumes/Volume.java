package springpackage.books.volumes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import springpackage.books.Books;

@Entity
public class Volume {
	
	@Id
	private String id;
	private String name;
	private String type;
	private String status;
	private Books book;
	@ManyToOne
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Volume() {
		super();
	}
	public Volume(String id, String name, String type, String status, String book) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
		this.book = new Books(book, "", "", "");
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
