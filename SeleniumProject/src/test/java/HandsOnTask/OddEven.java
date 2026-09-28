package HandsOnTask;


public class OddEven {
public static void main (String[] args) {
	int number = 8;
	oddevenChecker(number);
    oddevenChecker(15);
}
public static void oddevenChecker(int number) {
	if(number%2==0) {
		System.out.println("Number is even");
		}else {
			System.out.println("Number is odd");
		}
	
}
}
	

