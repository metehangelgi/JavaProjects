package pa2;

public class Actor {

	private String name;
	private String surName;

	public Actor(String name, String surName) {
		this.name = name;
		this.surName = surName;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setSurname(String surName) {
		this.surName = surName;
	}

	public String getSurname() {
		return this.surName;
	}
}
