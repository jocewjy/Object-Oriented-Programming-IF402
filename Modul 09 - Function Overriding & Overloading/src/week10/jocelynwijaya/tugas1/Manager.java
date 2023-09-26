package week10.jocelynwijaya.tugas1;

public class Manager extends Karyawan{
	public Manager() {}
	public Manager(String id, String nama) {
		super(id,nama);
	}
	
	public String getId() {
		return id;
	}
	public String getNama() {
		return nama;
	}
	public int getGaji() {
		return 10000000;
	}
}
