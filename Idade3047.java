import java.util.*;
import java.io.*;

public class Idade3047 {

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int mae = 0;
		int[] fil = new int[3];
		
		mae = scan.nextInt();
		fil[0] = scan.nextInt();
		fil[1] = scan.nextInt();
		fil[2] = mae - (fil[0] + fil[1]);
		
		int maior = fil[0];
		for (int i = 1; i < fil.length; i++) {
			if (maior < fil[i])
				maior = fil[i];
		}
		System.out.println(maior);
		scan.close();
	}//END_MAIN

}//END_CLASS
