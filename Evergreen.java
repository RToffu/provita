/*
 *
 *
 */
import java.util.*;
import java.io.*;

public class Evergreen {

	public static void main(String args[]) {
		int n = 0;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < n; i++) {
			String c1 = new String();
			String c2 = new String();
		       	c1 = scan.nextLine();
			c2 = scan.nextLine();
		//	System.out.println("c1: " + c1);
		//	System.out.println("c2: " + c2);
		       if(c2 != null && c1 != null) {
			       strSolver(c1, c2);
		       }
		}
		scan.close();
	}//END_MAIN	       

	static void strSolver(String c1, String c2) {
		int tam = c1.length();
		String res = new String();
		int cont1 = 0, cont2 = 0;
		for(int i = 1; i<=tam*2; i+=2) {
		//	System.out.println("i: " + i);
			if((i/2)%2 != 0){
				res += c2.charAt(cont2++);
				if(cont2 < c2.length())
					res += c2.charAt(cont2++);
			}else {
				res += c1.charAt(cont1++);
				res += c1.charAt(cont1++);
			}
		}
		System.out.println(res);
	}//END_STRSOLVER

}//END_CLASS

