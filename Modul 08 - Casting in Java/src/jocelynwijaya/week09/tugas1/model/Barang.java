package jocelynwijaya.week09.tugas1.model;

public class Barang {
	protected int stok;
	protected String id, nama;
    protected double harga;
	
    public Barang() {}
	public Barang (String id, String nama, double harga) {
		this.id = id;
		this.nama = nama;
		this.harga = harga;
	}
	public String getID(){
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
