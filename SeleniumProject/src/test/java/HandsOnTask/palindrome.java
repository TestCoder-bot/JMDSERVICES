package HandsOnTask;

public class palindrome {
public static void main (String[] args) {
	String original = "MADAM";
	String reversed = "";
	for(int i=original.length()-1;i>=0;i--) {
		char character = original.charAt(i);
		System.out.println(character);
		reversed+=character;
	}
	if (original.contentEquals(reversed)) {
		System.out.println("String is palindrome");
	}else {
		System.out.println("String is not palindrome");
	}
}
}
