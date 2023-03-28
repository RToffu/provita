import java.util.*;
import java.io.*;

public class Biblioteca2137 {

	public static void bubbleSort (String arr[]) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j].compareTo(arr[j+1]) > 0) {
					//swap
					String temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	public static void printArray (String arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main (String []args) {
		Scanner scan = new Scanner(System.in);
		int n = 0;
		while (scan.hasNext()) {
			n = scan.nextInt();
			String[] arr = new String[n];
			scan.nextLine();
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextLine();
			}
			bubbleSort(arr);
			printArray(arr);	
		}
		scan.close();

	}//END_MAIN	
	
}//END_CLASS
