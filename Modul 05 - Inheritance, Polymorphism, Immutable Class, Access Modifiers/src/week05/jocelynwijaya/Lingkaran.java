package week05.jocelynwijaya;

public class Lingkaran extends Shape {
	private double radius;
	
	public Lingkaran() {}
	public Lingkaran(double radius, String color) {
		super(color);
		this.radius = radius;
	}
	public double keliling() { 
		return Math.PI * 2 * this.radius; 
	}
	public double luas() {
		return Math.PI * this.radius * this.radius;
	}
}
