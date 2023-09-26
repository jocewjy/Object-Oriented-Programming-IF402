package week10.jocelynwijaya.tugas1;

public class Tetap extends Karyawan{
	public Tetap() {}
	public Tetap(String id, String nama) {
		super(id,nama);
	}
	
	public String getId() {
		return id;
	}
	public String getNama() {
		return nama;
	}
	public int getGaji() {
		return 3000000;
	}

}
