import java.util.*;
import java.io.*;

public class Telefonica1211 {
	public static int countChar (String[] arr) {
		int n = arr.length;
		boolean tog = true;
		int sum = 0;
		for (int i = 0; i < n-1; i++) {
			tog = true;
			for (int j = 0; j < arr[i].length(); j++) {
				if(arr[i].charAt(j) == arr[i+1].charAt(j) && tog)
					sum++;
				else
					tog = false;
			}
		}
		return sum;
	}
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = 0;
		
		while (scan.hasNext()) {
			n = scan.nextInt();
			scan.nextLine();
			String[] arr = new String[n];
			for (int i = 0; i < n; i++)
				arr[i] = scan.nextLine();
			System.out.println(countChar(arr));
		}

		scan.close();
	}//END_MAIN

}//END_CLASS
