package myTest;

import java.util.Scanner;

public class AlphabeticalOrder {
public static void main (String[] args) {
	System.out.println("Enter the string to arrange in alphabetical order");

	Scanner scanner = new Scanner(System.in);
	
	String input=scanner.nextLine();
    String[] ip=input.split(" ");
    for(String word:ip) {
    char[] ch= word.toCharArray();
    
    
    for(int i=0;i<ch.length;i++) {
    	for(int j=i+1;j<ch.length;j++) {
    		if(ch[i]>ch[j]) {
    			char temp=ch[i];
    			ch[i]=ch[j];
    			ch[j]=temp;
    			
    			
    			
    		}
    	}
    }
    
    String ch1= String.valueOf(ch);
    
    System.out.print(ch1);
    }
    
 }
}
