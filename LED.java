import java.util.*;
import java.io.*;

public class LED {

	public static class HashT {
		private int arr[] = new int[10];
		private int h = 10;

		public HashT(){
			arr[0] = 6;
			arr[1] = 2;
			arr[2] = 5;
			arr[3] = 5;
			arr[4] = 4;
			arr[5] = 5;
			arr[6] = 6;
			arr[7] = 3;
			arr[8] = 7;
			arr[9] = 6;
		}
		private int funH(char c) {
			int num = (int)c-48;
			return num % 10;
		}
		public int getLed(char c) {
			int resp = 0;
			return arr[funH(c)];
		}

	}//END_HASHT

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		HashT h_table = new HashT();
		int n = scan.nextInt();
		scan.nextLine();
		int sum = 0;
		while(n>0) {
			sum = 0;
			String str = scan.nextLine();
			for(int i = 0; i < str.length(); i++) 
				sum += h_table.getLed(str.charAt(i));
			System.out.println(sum + " leds");
			n--;
		}

	}//END_MAIN

}//END_LED
