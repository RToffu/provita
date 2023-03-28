import java.io.*;
import java.util.*;

public class Duendes1 {
	public static class Duende {
		public String nome;
		public int idade;

		public Duende (String nome, int idade) {
			this.nome = nome;
			this.idade = idade;
		}
	}
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		String pattern = new String("[a-zA-z]*");
		int n = 0, qnt_times = 0;
		Duende[] duendes;
		while (scan.hasNext()) {
			n = scan.nextInt();
			scan.nextLine();
			duendes = new Duende[n];
			String str;
			int idade = 0;
			for (int i = 0; i < n; i++) {
				str = scan.next(pattern);
				idade = scan.nextInt();
				duendes[i] = new Duende(str, idade);
			}
			bubbleSort(duendes);
			qnt_times = n/3;
			Duende[][] times = new Duende[qnt_times][3];
			int aux = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < qnt_times; j++) {
					times[j][i] = duendes[aux++];	
				}
			}
			printTimes(times, qnt_times);
		}
		scan.close();
	}//END_MAIN
	public static void printTimes (Duende times[][], int qnt_times) {
		for (int i = 0; i < qnt_times; i++) {
			System.out.println("Time " + (i+1));
			for (int j = 0; j < 3; j++) {
				System.out.println(times[i][j].nome + " " + times[i][j].idade);
			}
			if (i < qnt_times-1)
				System.out.println();
		}
	}
	public static void bubbleSort (Duende arr[]) {
		int tam = arr.length;
		for (int i = 0; i < tam - 1; i++) {
			for (int j = 0; j < tam - 1 - i; j++)
				if (arr[j].idade < arr[j + 1].idade) {
					Duende temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		}
	}//END_BUBBLE
}//END_CLASS
