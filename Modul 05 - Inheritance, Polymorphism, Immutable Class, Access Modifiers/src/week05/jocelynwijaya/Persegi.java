package week05.jocelynwijaya;

public class Persegi extends Shape{
	private double sisi;
	public Persegi (double sisi, String color) {
		super(color);
		this.sisi = sisi;
	}
	public double keliling() {
		return 4 * this.sisi;
	}
	public double luas () {
		return this.sisi * this.sisi;
	}
}
