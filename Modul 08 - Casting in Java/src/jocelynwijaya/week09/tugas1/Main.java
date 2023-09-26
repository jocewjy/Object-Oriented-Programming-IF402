package jocelynwijaya.week09.tugas1;

import jocelynwijaya.week09.tugas1.model.*;
import java.util.*;

public class Main {
	
	private static Scanner scan;
	static ArrayList<Barang> barang = new ArrayList<Barang>();
	static Order[] orders = new Order[50];
	static int idxHP=2, idxVou=1, idxOrder=1;
	
	public static void listOfProducts() {
        barang.add(new Handphone("H01", "Samsung S9+", 2199000, 10, "hitam"));
        barang.add(new Handphone("H02", "iPhone X", 5699000, 10, "putih"));
        barang.add(new Voucher("V01", "Google Play", 20000, 100, 0.1));
    }
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int opsi;
		listOfProducts();
		
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
					lihatPesanan(idxOrder - 1);
					break;
				case 3:
					barangBaru();
					break;
				default: System.out.println("Wrong Input\n");
			}
			
		}
		System.out.println("Terima kasih dan sampai jumpa!");

	}
	
	public static void listBarang(Barang products) {
        System.out.println("ID     : " + products.getID());
        System.out.println("Nama   : " + products.getNama());
        System.out.println("Stok   : " + products.getStok());
        System.out.println("Harga  : " + products.getHarga() );
        System.out.println("------------------------------");
    }
	private static void pesanBarang() {
        boolean cekProduk = false;
        int IDpsn = 0;
        int jml, bayar;
        
        System.out.println("Daftar Barang Toko Voucher & HP");
        
        for (Barang product : barang) {
            listBarang(product);
        }
        
        System.out.println("Ketik 0 untuk batal");
        System.out.print("Pesan Barang (ID) : ");
        
        String opsi = scan.next();
        
        for(int i = 0; i < barang.size(); i++) {
            if (opsi.equalsIgnoreCase(barang.get(i).getID())){
                cekProduk = true;
                IDpsn = i;
            }
        }
        
        if(!cekProduk){
        	System.out.println("Barang tidak tersedia!");
            return;
        }
        
        System.out.print("Masukkan Jumlah : ");
        jml = scan.nextInt();
        
        if(jml == 0 || jml > barang.get(IDpsn).getStok()){
        	System.out.println("Stok barang tidak mencukupi!");
        	return;
        }
        
        System.out.println(jml + " @ " + barang.get(IDpsn).getNama() + " dengan total harga " + (jml * barang.get(IDpsn).getHarga()));
        System.out.print("Masukkan jumlah uang : ");
        bayar = scan.nextInt();
        
        if(bayar < jml * barang.get(IDpsn).getHarga()){
        	System.out.println("Jumlah uang tidak mencukupi");
        } else {
        	System.out.println("Berhasil dipesan");
            orders[idxOrder-1] = new Order(idxOrder, barang.get(IDpsn), jml);
            barang.get(IDpsn).minusStok(jml);
            idxOrder++;
        }
	}
	
	public static void lihatPesanan(int idxOrder) {
		System.out.println("----------------------------");
        System.out.println("Daftar pesanan konter Voucher & HP");
        
        for (int i = 0; i < idxOrder; i++){
            Order pesanan = orders[i];
            
            System.out.println("ID     : " + pesanan.getId());
            if(pesanan.getId().contains("OH")){
                System.out.println("Nama   : " + pesanan.getHandphone().getNama());
                System.out.println("Total  : " + pesanan.getJumlah() * pesanan.getHandphone().getHarga());
            } else{
                System.out.println("Nama   : " + pesanan.getVoucher().getNama());
                System.out.println("Total  : " + pesanan.getJumlah() * pesanan.getVoucher().getHarga());
            }
            System.out.println("----------------------------------------\n");
        }
    }
	
	public static void barangBaru() {
		String type, nama, warna;
        int stok, harga;
        double ppn;
        
        System.out.print("Voucher / Handphone (V/H) : ");
        type = scan.next(); scan.nextLine();
        
        if(type.equals("V") || type.equals("v")){
            System.out.print("Nama : ");
            nama = scan.nextLine();
            
            System.out.print("Harga : ");
            harga = scan.nextInt();
            
            System.out.print("Stok : ");
            stok = scan.nextInt(); scan.nextLine();
            
            System.out.print("PPN : ");
            ppn = scan.nextDouble();
            
            String id = String.format("V0%d", idxVou+1);
            barang.add(new Voucher(id,nama,harga,stok,ppn));
            idxVou++;
            
            System.out.println("Voucher telah berhasil diinput");
        }
        if(type.equals("H") || type.equals("h")){
            System.out.print("Nama : ");
            nama = scan.nextLine();
            
            System.out.print("Harga : ");
            harga = scan.nextInt();
            
            System.out.print("Stok : ");
            stok = scan.nextInt(); scan.nextLine();
            
            System.out.print("Warna  : ");
            warna = scan.nextLine();
            
            String id = String.format("H0%d", idxHP+1);
            barang.add(new Handphone(id, nama, harga, stok, warna));
            idxHP++;
            
            System.out.println("Handphone telah berhasil diinput");
        }
		
		/*String nama,warna, idH, idV;
        int stok, temp = 0;
        double harga,pajak;

        idH = "H" + Handphone.total;
        idV = "V" + Voucher.total;
        
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
            
        	break;*/
	}
		
}
