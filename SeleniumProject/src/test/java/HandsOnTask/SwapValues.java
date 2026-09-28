package HandsOnTask;

public class SwapValues {
public static void main (String[] args) {
	int a = 9;
	int b= 10;
	a = a+b;
	b=a-b;
	System.out.println("b="+b);
	a= a-b;
	System.out.println("a="+a);
}
}
