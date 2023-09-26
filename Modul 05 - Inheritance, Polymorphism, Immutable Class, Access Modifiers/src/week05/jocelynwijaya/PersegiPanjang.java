package week05.jocelynwijaya;

public class PersegiPanjang extends Shape {
	private double panjang;
	private double lebar;
	
	public PersegiPanjang (double panjang, double lebar, String color) {
		super(color);
		this.panjang = panjang;
		this.lebar = lebar;
	}
	public double keliling () {
		return (2 * this.panjang) + (2 * this.lebar);
	}
	public double luas () {
		return this.panjang * this.lebar;
	}
}
