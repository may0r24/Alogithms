package springpackage.main.sample1project;

public class Students {
	
	private String id;
	private String name;
	private String level;
	private String gender;
	
	
	public Students() {
		super();
	}
	
	public Students(String id, String name, String level, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.gender = gender;
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
