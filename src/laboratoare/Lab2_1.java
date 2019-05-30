/**
 * 
 */
package laboratoare;

/**
 * @author Marius
 *
 */
public final class Lab2_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a Student
		Student stud1 = new Student("Marius", "1943129329123");
		stud1.enroll("Math");
		stud1.enroll("Englesh");
		stud1.enroll("History");
		stud1.showCourses();
		stud1.checkBalance();
		stud1.pay(1000);
		stud1.checkBalance();
		System.out.println(stud1.toString());

		Student stud2 = new Student("Ionut", "1254231291231");
		stud2.setPhone("0747231234");
		System.out.println(stud2.toString());

		Student stud3 = new Student("Andreia", "2143129329123");
		stud3.setCity("Suceava");
		stud3.setState("Romania");
		System.out.println(stud3.toString());
	}

}

class Student {
	// Proprietati
	private static int id = 0;
	private String userID;
	private String name;
	private String cnp;
	private String email;
	private String phone;
	private String city;
	private String state;
	private String courses = "";
	private static final int costofCourse = 800;
	private int balance = 0;

	public Student(String name, String cnp) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.cnp = cnp;
		id++;
		System.out.println("Numele: " + name);
		System.out.println("CNP: " + cnp);
		setEmail();
		setUserID();
	}

	public void setEmail() {
		email = name.toLowerCase() + "." + id + "@student.usv.ro";
		System.out.println("Your email is: " + email);
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setUserID() {
		int max = 9000;
		int min = 1000;
		int randnum = (int) (Math.random() * (max - min));
		randnum = randnum + min;
		System.out.println(randnum);
		userID = id + "" + randnum + "" + cnp.substring(9);
		System.out.println("User ID: " + userID);

	}

	public void enroll(String course) {
		this.courses = this.courses + " " + course;
		balance = balance + costofCourse;
	}

	public void pay(int amount) {
		balance = balance - amount;
		System.out.println("Paid: " + amount + " lei from " + (balance + amount) + " lei");

	}

	public void checkBalance() {
		System.out.println("Balance: " + balance);
	}

	public void showCourses() {
		System.out.println("Courses: " + courses);
	}

	@Override
	public String toString() {
		return "[Name: " + name + " Courses: " + courses + " Balance: " + balance + "]";
	}
}