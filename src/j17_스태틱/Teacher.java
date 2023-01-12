package j17_스태틱;

public class Teacher {
	
	private String name;
	
	public Teacher(String name) {
		this.name = name; // Allagument..?
	} // requied..? 이려면 name이 final이어야함

	@Override
	public String toString() {
		return "Teacher [name=" + name + "]";
	}
	 
	
}
