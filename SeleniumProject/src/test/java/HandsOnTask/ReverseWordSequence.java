package HandsOnTask;

public class ReverseWordSequence {
	public static void main(String[] args) {
String original="India is my Country";
String[] word=original.split(" ");
String reverse="";
for(String words:word) {
	String reverseword="";
	for(int i=words.length()-1;i>=0;i--) {
		reverseword+=words.charAt(i);
	}
	reverse+=reverseword+ " ";
}System.out.println(reverse);

}
}
