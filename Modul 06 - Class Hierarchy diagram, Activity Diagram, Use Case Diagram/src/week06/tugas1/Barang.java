package week06.tugas1;

public class Barang {
	protected int id, stok;
    protected double harga;
    protected String nama;
	
	public Barang (int id, String nama, double harga) {
		this.id = id;
		this.nama = nama;
		this.harga = harga;
	}
	public int getID(){
		return this.id;
	}
	public String getNama(){
		return this.nama;
	}
	public double getHarga(){
		return this.harga;
	}
	public int getStok(){
		return this.stok;
	}
	public void minusStok(int jml) {
		this.stok -= jml;
	}
}
