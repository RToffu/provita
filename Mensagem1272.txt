import java.util.*;
import java.io.*;

public class Mensagem1272 {
	
	public static void mensagemOculta (String str) {
		boolean tog = true;
		for (int i = 0; i < str.length(); i++) {
			if((int)str.charAt(i) == 32) {
				tog = true;
			}else if(tog){
				System.out.printf("%c", str.charAt(i));
				tog = false;
			}

		}
		System.out.println();
		
	}
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();

		for (int i = 0; i < n; i++) {
			String str = scan.nextLine();
			mensagemOculta(str);
		}
		scan.close();
	}//END_MAIN

}//END_CLASS
