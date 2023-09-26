package week04.jocelynwijaya.id.ac.umn;

import java.util.Scanner;

public class Main {
	private static Scanner scan;
	
	static Barang[] items = new Barang[10];
	static Order[] orders = new Order[10];
	
	private static int id, jumlah, bayar;

	public static void main(String[] args) {
		int opsi, idx=0;
		data();
		scan = new Scanner(System.in);
		
		for(;;) {
			System.out.println("------Menu Toko Multiguna------");
			System.out.println("1. Pesan Barang");
			System.out.println("2. Lihat Pesanan");
			System.out.println("0. Exit Application");
			System.out.print("Pilihan : ");
			
			opsi = scan.nextInt();
			if (opsi == 0) break;
			System.out.println(orders[0]);
			switch(opsi) {
				case 1: 
					showBarang(); 
					if (pesanBarang(idx) == true) {
						idx++;
						System.out.println("Berhasil di pesan\n");
					} else {
						System.out.println("Pesanan Gagal\n");
					}
					break;
				case 2:
					lihatPesanan();
					break;
				default: System.out.println("Wrong Input\n");
			}
			
		}
		System.out.println("Terima kasih dan sampai jumpa!");
	}
	
	public static void data() {
		items[0] = new Barang(1, "Pulpen Easy Gel 0.1 mm", 120,2000);
		items[1] = new Barang(2, "Penggaris 30cm", 20,5000);
		items[2] = new Barang(3, "Tipe-x Roller", 30,7000);
		items[3] = new Barang(4, "Pensil Mekanik", 50,5000);
		items[4] = new Barang(5, "Buku Tulis", 100,6000);
	}
	
	public static void showBarang() {
		System.out.println("Daftar Barang Toko Multiguna");
		int i = 1;
		for (Barang item : items) {
			if(item==null) break;
			System.out.println("\nNomor : "+i);i++;
			System.out.println("ID \t : "+item.getId());
			System.out.println("Nama \t : "+item.getNama());
			System.out.println("Stock \t : "+item.getStock());
			System.out.println("Harga \t : "+item.getHarga());
			System.out.print("----------------------------------");
		}
		System.out.print("\n\n");
	}
	
	public static boolean pesanBarang(int idx) {
		System.out.println("Ketik 0 untuk batal");
		System.out.print("Pesan Barang (ID)\t : ");
		id = scan.nextInt();
		if (id == 0) return false;
		Barang item = items[id-1];
		for(;;) {
			System.out.print("Masukan Jumlah Barang\t : ");
			jumlah = scan.nextInt();
			if (jumlah <= item.getStock()) break;
		}
		
		int totalBayar = jumlah * item.getHarga();
		System.out.println(jumlah+" @ "+item.getNama()+" dengan total harga "+totalBayar);
		
		for(;;) {
			System.out.print("Masukan Jumlah Uang\t : ");
			bayar = scan.nextInt();
			if (bayar >= totalBayar) break;
		}
		
		if (bayar > totalBayar) {
			System.out.println("Kembalian : "+(bayar-totalBayar));
		}
		
		orders[idx] = new Order(id, item.getNama(), jumlah, bayar);
		return true;
	}
	
	public static void lihatPesanan() {
		System.out.println("Daftar Pesanan Toko Multiguna");
		int i = 1;
		for (Order order : orders) {
			if(order==null) continue;
			System.out.println("\nNomor : "+i); i++;
			System.out.println("ID \t : "+order.getId());
			System.out.println("Nama \t : "+order.getNama());
			System.out.println("Jumlah \t : "+order.getJumlah());
			System.out.println("Harga \t : "+order.getTotal());
			System.out.print("----------------------------------");
		}
		System.out.print("\n\n");
	}
}
