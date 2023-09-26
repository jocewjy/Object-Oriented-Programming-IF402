package week02.jocelynwijaya.id.ac.umn;

import java.util.Scanner;

public class Soal3 {

	public static void main(String[] args) {
		int min, max, sum=0;
		boolean pNum;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Masukkan Angka terkecil: ");
        min = scanner.nextInt();
        
        System.out.println("Masukkan Angka terbesar: ");
        max = scanner.nextInt();
        
        for(int ctr = min; ctr <= max; ctr++) {
        	pNum = true;
        	for (int i = 2; i<= ctr/2; i++) {
	    		if (ctr % i == 0) {
	    			pNum = false;
	    			break;
	    		}
        	}
        	if(pNum && ctr != 0 && ctr != 1) {
        		sum += ctr;
        	}
        }
        
        System.out.println(sum);
	}
}
