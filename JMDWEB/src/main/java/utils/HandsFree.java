package utils;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class HandsFree {
    public static void main(String[] args) {
   int[] arr = {1,4,7,33,21,54,22};
  int largest = Integer.MIN_VALUE;
  int secondLargest=Integer.MIN_VALUE;
  for(int num:arr) {
	  if(num>largest) {
		  largest=num;
		 secondLargest= largest;
	  }
	  else if(num>secondLargest & num!=largest) {
		  secondLargest=num;
	  }
  }
   System.out.println("Second Largest " + secondLargest);
   
   
   
  
   
//   int largest= Integer.MIN_VALUE;
//   int secondLargest = Integer.MIN_VALUE;

   //   for(int num:arr) {
//	   if(num>largest) {
//		   largest=num;
//		   secondLargest=largest;
//	   
//	   }
//	   else if(num>secondLargest && num!=largest) {
//		   secondLargest=num;
//		  
//	   }
//   }
//   System.out.println("Second Largest number" + secondLargest);  
   
    }
  }
