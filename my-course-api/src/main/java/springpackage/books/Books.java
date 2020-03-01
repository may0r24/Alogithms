package springpackage.books;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books {
	
	@Id
	private String id;
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
	public Books(String id, String name, String type, String status) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}

	public void setBookId(String id) {
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
