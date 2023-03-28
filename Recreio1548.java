import java.util.*;
import java.io.*;

public class Recreio1548 {
	public static void bubbleSort (int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] < arr[j+1]) {
				//swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	public static int compareArray (int arr[], int arr_og[]) {
		int sum = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] == arr_og[i])
				sum++;
		}
		return sum;
	}
	//driver
	public static void main (String []args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while (n > 0) {
			n--;
			int tcs = scan.nextInt();
			int[] arr = new int[tcs];
			int[] arr_og = new int[tcs];
			for (int i = 0; i < tcs; i++) {
				arr[i] = scan.nextInt();
				arr_og[i] = arr[i];
			}
			bubbleSort(arr);
			System.out.println(compareArray(arr, arr_og));	
		}
		scan.close();
	}//END_MAIN

}//END_CLASS
