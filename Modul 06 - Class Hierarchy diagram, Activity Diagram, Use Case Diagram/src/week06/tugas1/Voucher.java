package week06.tugas1;

public class Voucher extends Barang {
	private double pajak;
	public static int total;
	
	public Voucher(int id, String nama, double harga, int stok, double pajak) {
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
