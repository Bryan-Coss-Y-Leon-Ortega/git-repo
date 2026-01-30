
public class Student {
	
	private String name;
	private String address;
	private int rollno;
	
	public Student() {
		this.name = "Null name";
		this.address = " 1600 Pennsylvania Avenue NW, Washington, DC 20500 ";
		this.rollno = 3;
	}
	
	public Student(String name, String address, int rollno) {
		
		this.name = name;
		this.address = address;
		this.rollno = rollno;
		
	}
	public String getName() {
		return this.name;
	}
	public int getNum() {
		return this.rollno;
	}
	public String getAddy() {
		return this.address;
	}

}
