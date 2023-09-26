package week04.jocelynwijaya.id.ac.umn;

public class Order {
	private int id, jumlah, total;
	private String nama;
	public Order(int id, String nama, int jumlah, int total) {
		this.id = id;
		this.nama = nama;
		this.jumlah = jumlah;
		this.total = total;
	}
	public int getId() {
		return this.id;
	}
	public String getNama() {
		return this.nama;
	}
	public int getJumlah() {
		return this.jumlah;
	}
	public int getTotal() {
		return this.total;
	}
}
