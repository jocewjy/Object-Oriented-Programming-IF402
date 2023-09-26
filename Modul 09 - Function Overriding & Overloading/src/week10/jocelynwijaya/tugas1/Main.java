package week10.jocelynwijaya.tugas1;
import java.util.*;

public class Main {
	private static Scanner scan;
	static ArrayList<Manager> manager = new ArrayList<Manager>();
	static ArrayList<Tetap> tetap = new ArrayList<Tetap>();
	static ArrayList<Magang> magang = new ArrayList<Magang>();
	static int id_manager = 0, id_kTetap = 0, id_kMagang = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		int opsi;
		
		for(;;) {
			System.out.println("=====Program Data Karyawan=====");
			System.out.println("1. Lihat Karyawan");
			System.out.println("2. Tambah Karyawan");
			System.out.println("3. Keluar");
			System.out.print("Pilihan : ");
			opsi = scan.nextInt();
			
			if (opsi == 3) {
				break;
			}
			switch(opsi) {
				case 1: 
					lihatKaryawan();
					break;
				case 2:
					tambahKaryawan();
					break;
				default: System.out.println("Input tidak valid");
			}
			
		}
		System.out.println("Keluar Program...");
	}
	
	public static void lihatKaryawan() {
		System.out.println("========Daftar Manajer=========");
		listOfManajer();
		System.out.println("=====Daftar Pegawai Tetap======");
		listOfKaryawanTetap();
		System.out.println("=====Daftar Pegawai Magang=====");
		listOfKaryawanMagang();
	}
	
	public static void listOfManajer() {
		if(manager.size() == 0) {
			System.out.println("Tidak ada");
		}
		
		for(Manager managers : manager) {
			System.out.println("ID	  : " + managers.id);
			System.out.println("Nama	  : " + managers.nama);
			System.out.println("Gaji	  : " + "Rp. " + managers.getGaji());
			System.out.println("----------------------------");
		}
	}
	
	public static void listOfKaryawanTetap() {
		if(tetap.size() == 0) {
			System.out.println("Tidak ada");
		}
		for(Tetap tetaps : tetap) {
			System.out.println("ID	  : " + tetaps.id);
			System.out.println("Nama	  : " + tetaps.nama);
			System.out.println("Gaji	  : " + "Rp. " + tetaps.getGaji());
			System.out.println("----------------------------");
		}
	}
	
	public static void listOfKaryawanMagang() {
		if(magang.size() == 0) {
			System.out.println("Tidak ada");
		}
		for(Magang magangs : magang) {
			System.out.println("ID	  : " + magangs.id);
			System.out.println("Nama	  : " + magangs.nama);
			System.out.println("Gaji	  : " + "Rp. " + magangs.getGaji());
			System.out.println("----------------------------");
		}
	}
	
	public static void tambahKaryawan() {
		String nama, id;
		
		System.out.println("=====Tambah Karyawan=====");
		System.out.println("1. Manajer");
		System.out.println("2. Karyawan Tetap");
		System.out.println("3. Karyawan Magang");
		System.out.print("Pilih: ");
		int opsi = scan.nextInt();
		
		switch(opsi) {
			case 1: 
				System.out.print("Nama	: ");
				nama = scan.next();
				
				id = String.format("M%d", id_manager+1);
				manager.add(new Manager(id,nama));
				id_manager++;
				
				System.out.println("Manajer baru telah ditambahkan");
				break;
			case 2:
				System.out.print("Nama	: ");
				nama = scan.next();
				
				id = String.format("R%d", id_kTetap + 1);
				tetap.add(new Tetap(id,nama));
				id_kTetap++;
				
				System.out.println("Manajer baru telah ditambahkan");
				break;
			case 3:
				System.out.print("Nama	: ");
				nama = scan.next();
				
				id = String.format("I%d", id_kMagang+1);
				magang.add(new Magang(id,nama));
				id_kMagang++;
				
				System.out.println("Karyawan magang baru telah ditambahkan");
				break;
			default: System.out.println("Input tidak valid");
		}
		
	}
	
}
