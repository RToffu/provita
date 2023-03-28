import java.util.*;
import java.io.*;

public class Figurinhas3129 {
	public static class Sticker {
		private int num;
		private int qnt;
		
		public Sticker (int num) {
			this.num = num;
			this.qnt = 0;
		}

		public int getNum () {
			return num;
		}
		public int getQnt () {
			return qnt;
		}
		public void addQnt () {
			this.qnt++;
		}
	}//END_STICKERS
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = 0;
		boolean tog = false;
		Sticker[] arr = new Sticker[n];
		for (int i = 0; i < n; i++) {
			tog = false;
			int aux = scan.nextInt();
			Sticker temp = new Sticker(aux);
			for (int j = 0; j < index; j++) {
				if (arr[j].getNum() == temp.getNum()) {
					arr[j].addQnt();
					tog = true;
				}

			}
			if (!tog) {
				arr[index] = temp;
				index++;
			}
			
		}
		int sum = 0;
		for (int i = 0; i < index; i++) {
			sum += arr[i].getQnt();
		}
		System.out.println(index);
		System.out.println(sum);
		scan.close();
	}//END_MAIN

}//END_CLASS
