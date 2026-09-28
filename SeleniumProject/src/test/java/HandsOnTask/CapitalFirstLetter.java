package HandsOnTask;

public class CapitalFirstLetter {

	    public static void main(String[] args) {

	        String str = "java selenium automation testing";

	        String[] words = str.split(" ");

	        StringBuilder sb = new StringBuilder();

	        for (int i = 0; i < words.length; i++) {

	            sb.append(Character.toLowerCase(words[i].charAt(0)))
	              .append(words[i].substring(1))
	              .append(" ");
	        }

	        System.out.println(sb.toString().trim());
	    }
	}
