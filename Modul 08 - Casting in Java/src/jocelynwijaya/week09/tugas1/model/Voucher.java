package jocelynwijaya.week09.tugas1.model;

public class Voucher extends Barang {
	private double pajak;
	public static int total;
	
	public Voucher() {}
	public Voucher(String id, String nama, double harga, int stok, double pajak) {
		super (id, nama, harga);
		this.stok = stok;
		this.pajak = pajak;
	}
	public double getPajak() {
		return this.pajak;
	}
	public double getHargaJual() {
		return this.harga + this.pajak;
	}
	
}
