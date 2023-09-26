package week10.jocelynwijaya.tugas1;

public class Magang extends Karyawan {
	public Magang() {}
	public Magang(String id, String nama) {
		super(id,nama);
	}
	
	public String getId() {
		return id;
	}
	public String getNama() {
		return nama;
	}
	public int getGaji() {
		return 1500000;
	}
}
