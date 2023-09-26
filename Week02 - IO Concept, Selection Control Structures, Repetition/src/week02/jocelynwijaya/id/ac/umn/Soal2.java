package week02.jocelynwijaya.id.ac.umn;

import java.util.Scanner;

public class Soal2 {

	public static void main(String[] args) {
		int num;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Masukkan Angka: ");
        num = scanner.nextInt();
        
        if(num == 1 | num == 0) {
        	System.out.println("Angka " + num + " bukan bilangan prima");
        } else {
        	for(int i = 2; i<= num/2; i++) {
        		if (num % i == 0) {
        			System.out.println("Angka " + num + " bukan bilangan prima");
        		} else {
        			System.out.println("Angka " + num + " adalah bilangan prima");
        		}
        		break;
        	}
        }
        
	}

}
