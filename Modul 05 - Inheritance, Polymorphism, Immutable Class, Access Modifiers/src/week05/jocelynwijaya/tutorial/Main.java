package week05.jocelynwijaya.tutorial;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
			
			Scanner s = new Scanner(System.in);
			
			System.out.print("Masukan jari-jari Lingkaran : ");
			double radius = s.nextDouble();
			System.out.print("Masukan warna : ");
			String color = s.next();
			
			Circle circle = new Circle(radius, color);
			System.out.println("Lingkaran "+circle.getColor());
			System.out.println("Warna \t: "+circle.getColor());
			System.out.println("Jari-jari \t: "+circle.getRadius());
			System.out.println("Keliling Lingkaran \t: "+circle.getPerimeter());
			System.out.println("Luas Lingkaran \t: "+circle.getArea());
			
			System.out.println("\n--------------------------\n");
		}
}
