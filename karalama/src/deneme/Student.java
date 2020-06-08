package deneme;

public class Student {

	
	
	
	
	
	
	
	

	String surname;
	int age;
	
	
	public Student(){
		
	}
	
	public Student(String name,String surname,int age) {
		this.name=name;
		this.surname=surname;
		this.age=age;
	}

	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String toString() {
		
		String print=name+" "+surname+" "+age;
		
		
		return print;
		
	}
	
	
	
}
