import java.util.*;
import java.io.*;

public class Solitario2091 {
	public static void bubbleSort (int arr[]) {
		int n = arr.length;
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
				//swap
					int temp =  arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	public static int ficouSozinho (int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i+=2) {
			if(i == n-1) {
				return arr[i];
			}else if(arr[i] != arr[i+1]) {
				if(i == 0)
					return arr[i];
				else
					return arr[i+1];
			}
		}
		return 0;
	}

	//driver
	public static void main (String []args) {
		Scanner scan = new Scanner(System.in);
		int n = 0;
		while ((n = scan.nextInt()) != 0) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) 
				arr[i] = scan.nextInt();
			bubbleSort(arr);
			System.out.println(ficouSozinho(arr));
		}
		scan.close();
	}//END_MAIN

}//END_CLASS
