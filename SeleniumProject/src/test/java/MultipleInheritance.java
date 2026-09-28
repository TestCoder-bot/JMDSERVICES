

interface Printable{
	void  print();
}
interface scannable{
	void scan();
}
 class printer implements Printable, scannable{
	@Override
	public void print() {
		System.out.println("Printer is printing the paper");
	}
	@Override
	public void scan() {
		System.out.println("Printer is scanning the paper");
	}
}
   
public class MultipleInheritance {
public static void main (String[] args) {
	printer mypaper= new printer();
	mypaper.print();
	mypaper.scan();
}
}
