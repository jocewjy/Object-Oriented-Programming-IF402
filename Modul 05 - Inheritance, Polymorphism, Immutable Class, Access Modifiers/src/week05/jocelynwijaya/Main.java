package week05.jocelynwijaya;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int opsi;
		String color;
		
		while(true) {
			System.out.println("------Program Menghitung Bangun Ruang------");
			System.out.println("1. Lingkaran");
			System.out.println("2. Persegi");
			System.out.println("3. Persegi Panjang");
			System.out.println("4. Segitiga");
			System.out.println("5. Keluar");			
			System.out.print("Pilihan : ");
			opsi = s.nextInt();
			
			switch(opsi) {
				case 1: 
					System.out.println("------ Lingkaran ------");
					System.out.print("Masukan jari-jari \t: ");
					double radius = s.nextDouble();
					
					System.out.print("Masukan Warna \t: ");
					color = s.next();
					
					Lingkaran circle = new Lingkaran(radius, color);
					
					System.out.println("Jari-jari\t: " + radius);
					System.out.println("Warna\t\t: " + circle.getColor());
					System.out.println("Keliling  \t: "+ circle.keliling());
					System.out.println("Luas \t\t: "+ circle.luas()+"\n");
					break;
				case 2: 
					System.out.println("------ Persegi ------");
					System.out.print("Masukan sisi \t: ");
					double sisi = s.nextDouble();
					
					System.out.print("Masukan Warna \t: ");
					color = s.next();
					
					Persegi square = new Persegi(sisi, color);
					
					System.out.println("Panjang Sisi\t: " + sisi);
					System.out.println("Warna\t\t: " + square.getColor());
					System.out.println("Keliling  \t: "+ square.keliling());
					System.out.println("Luas \t\t: "+ square.luas() +"\n");
					break;
				case 3: 
					System.out.println("------ Persegi Panjang ------");
					System.out.print("Masukan panjang\t: ");
					double panjang = s.nextDouble();
					
					System.out.print("Masukan lebar \t: ");
					double lebar = s.nextDouble();
					
					System.out.print("Masukan Warna \t: ");
					color = s.next();
					
					PersegiPanjang rectangle = new PersegiPanjang(panjang, lebar, color);
					
					System.out.println("Panjang & Lebar\t: " + panjang + " & " + lebar);
					System.out.println("Warna\t\t: " + rectangle.getColor());
					System.out.println("Keliling  \t: "+ rectangle.keliling());
					System.out.println("Luas \t\t: "+ rectangle.luas() +"\n");
					break;
				case 4:
					System.out.println("------ Segitiga Siku-siku ------");
					System.out.print("Masukan alas \t: ");
					double alas = s.nextDouble();
					
					System.out.print("Masukan tinggi \t: ");
					double tinggi = s.nextDouble();
					
					System.out.print("Masukan Warna \t: ");
					color = s.next();
					
					PersegiPanjang triangle = new PersegiPanjang(alas, tinggi, color);
					
					System.out.println("Alas & Tinggi\t: " + alas + " & " + tinggi);
					System.out.println("Warna\t\t: " + triangle.getColor());
					System.out.println("Keliling  \t: "+ triangle.keliling());
					System.out.println("Luas \t\t: "+ triangle.luas()+"\n");
					break;
				case 5: System.out.println("\nKeluar\n"); break;
				default : System.out.println("\nInput tidak valid\n");
			}
			if (opsi==5) break;
		}

	}
}
