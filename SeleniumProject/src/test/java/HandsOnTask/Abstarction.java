package HandsOnTask;

abstract class User{
	private String name;
	private int Id;
	private int borrowedBooks;	
	
	public User(String name,int Id) {
		this.name=name;
		this.Id=Id;
		this.borrowedBooks=0;
	}
	public abstract int getBorrowingLimit();
	
	public void borrowBooks(){
		if(borrowedBooks<getBorrowingLimit()) {
			borrowedBooks++;
			System.out.println(name + " borrowed a book. Total books borrowed: " + borrowedBooks);
		}else {
			System.out.println(name + " has reached the borrowing limit of " + getBorrowingLimit());
        }		
	}
	public String getName() {
		return name;
	}
}
class Student extends User{
	public Student(String name,int id) {
		super(name,id);
	}
	@Override
	public int getBorrowingLimit() {
		return 3;
	}
}
class Teacher extends User{
	public Teacher(String name,int id) {
		super(name,id);
	}
	@Override
	public int getBorrowingLimit() {
		return 5;
	}
}
public class Abstarction{
	public static void main (String[] args) {
		
		User Student = new Student("Alice",101);
		User Teacher= new Teacher("Paras",108);
		
		Student.borrowBooks();
		Student.borrowBooks();
		Student.borrowBooks();
		Student.borrowBooks();
	}
}
	



