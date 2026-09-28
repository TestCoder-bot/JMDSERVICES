package HandsOnTask;

public class MissingNumber {
	public static void main (String[] args){
		int[] arr = {1,2,4,6,7,8,9,5,10};
		int n=  arr.length+1;
		int sum = (n*(n+1))/2;
		for (int i=1;i<arr.length;i++){
		sum=sum-arr[i];
		}
		System.out.println(sum);
		}
}
