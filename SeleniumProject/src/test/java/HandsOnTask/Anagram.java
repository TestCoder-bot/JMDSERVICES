package HandsOnTask;

import java.util.Arrays;

public class Anagram {
public static void main (String[] args) {
	String Str1= "Listen";
	String Str2="Silent";
	boolean result = areAnagrams(Str1,Str2);
	if(result) {
		System.out.println(Str1 +" and "+ Str2 +" are anagram ");
	}else {
		System.out.println(Str1+"and"+Str2+"are not anagram");
	}
 }
public static boolean areAnagrams(String str1, String str2) {
    // Remove whitespaces and convert to lowercase
    str1 = str1.replaceAll("\\s", "").toLowerCase();
    str2 = str2.replaceAll("\\s", "").toLowerCase();

    // Check if lengths are different
    if (str1.length() != str2.length()) {
        return false;
    }

    // Convert strings to character arrays and sort them
    char[] array1 = str1.toCharArray();
    char[] array2 = str2.toCharArray();
    

    Arrays.sort(array1);
    Arrays.sort(array2);

    // Compare the sorted arrays
    return Arrays.equals(array1, array2);
   }
 }

