package week06.tugas1;

import java.util.*;

public class Main {
	
	private static Scanner scan;
	static HashMap <Integer, Handphone> handphone = new HashMap<>();
	static HashMap <Integer, Voucher> voucher = new HashMap<>();
	static LinkedList <Order> orders = new LinkedList<>();

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int opsi;
		
		for(;;) {
			System.out.println("------Menu Toko Multiguna------");
			System.out.println("1. Pesan Barang");
			System.out.println("2. Lihat Pesanan");
			System.out.println("3. Barang Baru");
			System.out.print("Pilihan : ");
			opsi = scan.nextInt();
			
			if (opsi == 0) {
				break;
			}
			switch(opsi) {
				case 1: 
					pesanBarang(); 
					break;
				case 2:
					lihatPesanan();
					break;
				case 3:
					barangBaru();
					break;
				default: System.out.println("Wrong Input\n");
			}
			
		}
		System.out.println("Terima kasih dan sampai jumpa!");

	}
	
	private static void pesanBarang() {
        int opsi;
        System.out.println("Daftar Barang Konter Voucher & HP");
        System.out.println("1. Handphone");
        System.out.println("2. Voucher");
        System.out.print("Pilihan: ");
        opsi = scan.nextInt();

        Order temp;

        if (opsi == 1) {
        	temp = pesanHandphone();
        } else {
        	if (opsi == 2) {
        		temp = pesanVoucher();
        	} else return;
        }
        if(temp == null) {
        	return;
        }
        orders.add(temp);

    }
		
	private static Order pesanHandphone() {
		int totalHarga;

        for(Handphone hp: handphone.values()) {
            System.out.println("ID: " + hp.id);
            System.out.println("Nama: " + hp.nama);
            System.out.println("Stok: " + hp.stok);
            System.out.println("Harga: " + (int)hp.harga);
            System.out.println("------------------");
        }
        System.out.println("Ketik 0 untuk batal");
        
        System.out.print("Pesan Barang (ID): ");
        int id = scan.nextInt();
        
        if(id == 0) { 
        	return null;
        }

        Handphone pesanHandphone = handphone.get(id);

        if(pesanHandphone == null) {
            System.out.println("Barang tidak tersedia!");
            return null;
        }
        if(pesanHandphone.stok < 1) {
            System.out.println("Stok barang habis!");
            return null;
        }
        
        System.out.print("Masukkan Jumlah: ");
        int jml = scan.nextInt();
        
        while (jml < 1 || jml > pesanHandphone.stok) {
            if (jml > pesanHandphone.stok) {
                System.out.println("Silahkan masukkan jumlah yang lebih kecil!");
            } else {
                System.out.println("Silahkan masukkan jumlah yang lebih besar!");
            }
            System.out.print("Masukkan Jumlah: ");
            jml = scan.nextInt();
        }
        totalHarga = (int) (jml * pesanHandphone.harga);
        
        System.out.println(jml + " @ " + pesanHandphone.nama + " dengan total harga " + totalHarga);
        
        System.out.print("Masukkan jumlah uang: ");
        double bayar = scan.nextDouble();
        
        while (bayar < totalHarga) {
            System.out.println("Uang tidak cukup! Silahkan masukkan nominal yang lebih besar.");
            System.out.print("Masukkan jumlah uang: ");
            bayar = scan.nextDouble();
        }
        
        pesanHandphone.minusStok(jml);
        System.out.println(pesanHandphone.nama + " berhasil dipesan!");
        
        return new Order(id, pesanHandphone, jml);
    }

	private static Order pesanVoucher() {
		int totalHarga;

        for(Voucher vo: voucher.values()) {
            System.out.println("ID: " + vo.id);
            System.out.println("Nama: " + vo.nama);
            System.out.println("Stok: " + vo.stok);
            System.out.println("Harga: " + (int)vo.harga);
            System.out.println("------------------");
        }
        System.out.println("Ketik 0 untuk batal");
        
        System.out.print("Pesan Barang (ID): ");
        int id = scan.nextInt();
        
        if(id == 0) {
        	return null;
        }

        Voucher pesanVoucher = voucher.get(id);

        if(pesanVoucher == null) {
            System.out.println("Barang tidak tersedia!");
            return null;
        }
        if(pesanVoucher.stok < 1) {
            System.out.println("Stok barang habis!");
            return null;
        }
        
        System.out.print("Masukkan Jumlah: ");
        int jml = scan.nextInt();
        
        while (jml < 1 || jml > pesanVoucher.stok) {
            if (jml > pesanVoucher.stok) {
                System.out.println("Silahkan masukkan jumlah yang lebih kecil!");
            } else {
                System.out.println("Silahkan masukkan jumlah yang lebih besar!");
            }
            System.out.print("Masukkan Jumlah: ");
            jml = scan.nextInt();
        }
        totalHarga = (int) (jml * pesanVoucher.getHargaJual());
        
        System.out.println(jml + " @ " + pesanVoucher.nama + " dengan total harga " + totalHarga);
        
        System.out.print("Masukkan jumlah uang: ");
        double bayar = scan.nextDouble();
        
        while (bayar < totalHarga) {
            System.out.println("Uang tidak cukup! Silahkan masukkan nominal yang lebih besar.");
            System.out.print("Masukkan jumlah uang: ");
            bayar = scan.nextDouble();
        }
        
        pesanVoucher.minusStok(jml);
        System.out.println(pesanVoucher.nama + " berhasil dipesan!");

        return new Order(id, pesanVoucher, jml);
	}
	
	public static void lihatPesanan() {
        System.out.println("----------------------------");
        System.out.println("Daftar pesanan konter Voucher & HP");
        System.out.println("Total order: " + orders.size());

        for(Order temp: orders) {
            if(temp == null) {
            	continue;
            }

            System.out.println("ID: " + temp.getId());

            System.out.print("Nama: ");
            if(temp.getHandphone() != null) {
            	System.out.println(temp.getHandphone().nama);
            } else {
            	System.out.println(temp.getVoucher().nama);
            }

            System.out.println("Jumlah: " + temp.getJumlah());

            System.out.print("Total: ");
            if(temp.getHandphone() != null) {
            	System.out.println((int)(temp.getHandphone().harga * temp.getJumlah()));
            } else {
            	System.out.println((int)(temp.getVoucher().harga * temp.getJumlah()));
            }

            System.out.println("----------------------------");
        }
        System.out.println();
    }
	
	public static void barangBaru() {
		String nama,warna;
        int stok, idH, idV, temp = 0;
        double harga,pajak;

        idH = Handphone.total;
        idV = Voucher.total;
        
        System.out.println("Total Handphone: " + Handphone.total);
        System.out.println("Total Voucher: " + Voucher.total);
        System.out.print("Voucher / Handphone (V/H): ");
        String opsi = scan.next(); scan.nextLine();
        
        opsi.toLowerCase();
		
        switch(opsi) {
        //V O U C H E R
        case "v":
        	System.out.print("Nama: ");
            nama = scan.nextLine();
            
            System.out.print("Harga: ");
            harga = scan.nextDouble();
            
            System.out.print("Stok: ");
            stok = scan.nextInt();
            
            System.out.print("PPN: ");
            pajak = scan.nextDouble();
            
            for(Voucher v: voucher.values()) {
                if(v.nama.equals(nama) && v.harga == harga) {
                    temp = v.id;
                    break;
                }
            }
            
            Voucher existVou = voucher.get(temp);

            if(existVou != null) {
                System.out.println("ID: " + existVou.id);
                System.out.println("Nama: " + existVou.nama);
                System.out.println("Stok: " + existVou.stok + " --> " + stok);
                System.out.println("Harga: " + (int)existVou.harga + " --> " + (int)harga);
                System.out.println("------------------------------------");
                
                System.out.print("Terdapat barang yang sama, apakah mau mengganti? (y/n)");
                opsi = scan.next();

                if(opsi.equals("y") || opsi.equals("Y")) {
                    voucher.replace(existVou.id, new Voucher(existVou.id, nama, harga, stok, pajak));
                    System.out.println("ID " + existVou.id + " dengan nama barang " + existVou.nama + "(stock: " + existVou.stok + " ) berhasil di ubah");
                } else {
                    System.out.println("Membatalkan update . . .");
                }
            } else {
                idV += 1;
                
                System.out.println("----------");
                System.out.println("ID: " + idV);
                System.out.println("Nama: " + nama);
                System.out.println("Stok: " + stok);
                System.out.println("Harga: " + (int) harga);
                System.out.println("------------------------------------");
                
                System.out.print("Menambah barang baru? (y/n)");
                opsi = scan.next();

                if (opsi.equals("y") || opsi.equals("Y")) {
                    voucher.put(idV, new Voucher(idV, nama, harga, stok, pajak));
                    System.out.println("ID " + idV + " dengan nama barang " + nama + " (stock: " + stok + " ) berhasil di tambah");
                    Voucher.total += 1;
                } else {
                    System.out.println("Membatalkan tambah . . .");
                }
            }
        	break;
        //H A N D P H O N E	
        case "h":
        	System.out.print("Nama: ");
            nama = scan.nextLine();
            
            System.out.print("Harga: ");
            harga = scan.nextDouble();
            
            System.out.print("Stok: ");
            stok = scan.nextInt(); scan.nextLine();
            
            System.out.print("Warna: ");
            warna = scan.nextLine();

            for(Handphone h: handphone.values()) {
                if(h.nama.equals(nama)) {
                    temp = h.id;
                    break;
                }
            }
            
            Handphone existHp = handphone.get(temp);
        	
            if(existHp != null) {
                System.out.println("ID: " + existHp.id);
                System.out.println("Nama: " + existHp.nama);
                System.out.println("Stok: " + existHp.stok + " --> " + stok);
                System.out.println("Harga: " + (int)existHp.harga + " --> " + (int)harga);
                System.out.println("Warna: " + existHp.getWarna());
                System.out.println("------------------------------------");
                
                System.out.print("Terdapat barang yang sama, apakah mau mengganti? (y/n)");
                opsi = scan.next();

                if (opsi.equals("y") || opsi.equals("Y")) {
                    handphone.replace(existHp.id, new Handphone(existHp.id, nama, harga, stok, warna));
                    System.out.println("ID " + existHp.id + " dengan nama barang " + existHp.nama + "(stock: " + existHp.stok + " ) berhasil di ubah");
                } else {
                    System.out.println("Membatalkan update . . .");
                }
            } else {
                idH += 1;
                
                System.out.println("----------");
                System.out.println("ID: " + idH);
                System.out.println("Nama: " + nama);
                System.out.println("Stok: " + stok);
                System.out.println("Harga: " + (int) harga);
                System.out.println("Warna: " + warna);
                System.out.println("------------------------------------");
                
                System.out.print("Menambah barang baru? (y/n)");
                opsi = scan.next();

                if (opsi.equals("y") || opsi.equals("Y")) {
                    handphone.put(idV, new Handphone(idH, nama, harga, stok, warna));
                    System.out.println("ID " + idH + " dengan nama barang " + nama + " (stock: " + stok + " ) berhasil di tambah");
                    Voucher.total += 1;
                } else {
                    System.out.println("Membatalkan tambah . . .");
                }
            }
            
        	break;
        }
	}
		
}