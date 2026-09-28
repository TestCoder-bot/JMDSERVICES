


class calculator{
	int num(int a, int b) {
		return a+b;
	}
   double num(double a, double b) {
		return a+b;
	}
}
public class PolymorphismOverloading {
	public static void main (String[] args) {
		calculator cal = new calculator();
		System.out.println(cal.num(5,5));
		
		System.out.println(cal.num(5.5,8));
	}
			
}
