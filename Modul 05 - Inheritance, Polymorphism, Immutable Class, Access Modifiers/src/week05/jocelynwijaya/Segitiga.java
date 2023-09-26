package week05.jocelynwijaya;

public class Segitiga extends Shape{
	private double alas;
	private double tinggi;
	
	public Segitiga (double alas, double tinggi, String color) {
		super(color);
		this.alas = alas;
		this.tinggi = tinggi;
	}
	public double keliling () { 
		double sisiMiring = Math.sqrt((this.alas * this.alas) + (this.tinggi * this.tinggi));
		return sisiMiring + this.alas + this.tinggi;
	}
	public double luas () {
		return this.alas * this.tinggi * 0.5;
	}
}
