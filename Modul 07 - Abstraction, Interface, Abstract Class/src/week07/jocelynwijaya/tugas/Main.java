package week07.jocelynwijaya.tugas;

import java.util.*;

public class Main {
	static ArrayList<Item> listOfItems = new ArrayList<Item>();
	static ArrayList<Payment> listOfPayments = new ArrayList<Payment>();
	static Scanner s = new Scanner(System.in);
	
	public static void seedData() {
		listOfItems.add(new Item("Kulkas", "Electronic", 4800000));
		listOfItems.add(new Item("TV", "Electronic", 1280000));
		listOfItems.add(new Item("Laptop", "Computer", 6000000));
		listOfItems.add(new Item("PC", "Computer", 12000000));
	}
	
	public static void printItem(Item item) {
		System.out.println("Nama   : " + item.getName());
		System.out.println("Tipe   : " + item.getType());
		System.out.println("Harga  : " + item.getPrice());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opt =0, id =0, payOpt=0;
		int remainingPayment = 0;
		seedData();
		
		do {
			System.out.println("===Program Toko Elektronik==");
			System.out.println("1. Pesan Barang");
			System.out.println("2. Lihat Pesanan");
			System.out.println("0. Keluar");
			System.out.println("Pilihan: ");
			opt = s.nextInt();
			
			if(opt == 1) {
				System.out.println("====Daftar Barang====");
				for(int i = 0; i < listOfItems.size(); i++) {
					System.out.println("No    : " + (i+1));
					printItem(listOfItems.get(i));
					System.out.println("---------------------------------");
				}
				System.out.println("Pilih: ");
				
				id = s.nextInt();
				
                System.out.println("No: " + id);
                
                id -= 1;
                
                printItem(listOfItems.get(id));
                
                System.out.println("Tipe pembayaran");
                System.out.println("1. Cash");
                System.out.println("2. Credit");
                System.out.print("Pilih: ");
                
                payOpt = s.nextInt();
                
                if (payOpt == 1) {
                    payWithCash(id);
                } else if (payOpt == 2){
                    payWithCredit(id);
                } else {
                    System.out.println("Input tidak sesuai!");
                }
                
			} else if (opt == 2) {
				if (listOfPayments.size() == 0) {
                    System.out.println("Belum ada pesanan");
                } else {
                    System.out.println("Daftar Barang");
                    for (int i = 0; i < listOfPayments.size(); i++) {
                        System.out.println("No               : " + (i + 1));
                        System.out.println("Nama             : " + listOfPayments.get(i).getItemName());
                        System.out.println("Tipe             : " + listOfPayments.get(i).getItem().getType());
                        System.out.println("Status           : " + listOfPayments.get(i).getStatus());
                        System.out.println("Sisa Pembayaran  : " + listOfPayments.get(i).getRemainingAmount());
                        System.out.println("------------------------------------------");
                    }

                    System.out.print("Pilih No Transaksi: ");
                    id = s.nextInt();

                    if (id > 0 && id <= listOfPayments.size()) {
                        id -= 1;
                        System.out.println("No               : " + (id + 1));
                        System.out.println("Nama             : " + listOfPayments.get(id).getItemName());
                        System.out.println("Tipe             : " + listOfPayments.get(id).getItem().getType());
                        System.out.println("Status           : " + listOfPayments.get(id).getStatus());
                        System.out.println("Sisa Pembayaran  : " + listOfPayments.get(id).getRemainingAmount());
;
                        if (listOfPayments.get(id).getStatus().equals("FINISHED")) {
                            System.out.println("Transaksi telah lunas");
                        } else {
                            remainingPayment = listOfPayments.get(id).pay();
                            int paidOff = 0;
                            
                            System.out.println("Harga Pembayaran    : " + remainingPayment);
                            
                            while (paidOff < remainingPayment) {
                                System.out.println("Bayar               : ");
                                paidOff = s.nextInt();
                                
                                if (paidOff >= listOfPayments.get(id).pay() && paidOff == listOfPayments.get(id).getRemainingAmount()) {
                                    listOfPayments.get(id).paidOff();
                                    System.out.println("Transaksi telah dibayar lunas");
                                } else {
                                    listOfPayments.get(id).paidOff();
                                    System.out.println("Transaksi telah dibayar");
                                }
                            }
                        }
                    }
                }
			} else {
				System.out.println("Salah input");
			}
		} while (opt != 0);
		
	}
	
	public static void payWithCash(int id) {
        char inp;
        int pay;

        System.out.print("Bayar(Y/N): ");
        listOfPayments.add(new Cash(listOfItems.get(id)));
        inp = s.next().charAt(0);

        if (inp == 'y' || inp == 'Y') {
            System.out.println("Harga pembayaran: " + listOfPayments.get(listOfPayments.size()-1).pay());
            System.out.print("Bayar: ");
            
            pay = s.nextInt();
            
            while (pay < listOfItems.get(id).getPrice()) {
                System.out.println("Jumlah uang kurang!");
                pay = s.nextInt();
            }
            
            System.out.println("Transaksi telah dibayar lunas");
        } else if (inp == 'n' || inp == 'N') {
            System.out.println("Transaksi telah disimpan");
        }
    }
	
	public static void payWithCredit(int id) {
        int credit = 0, pay;

        while (credit != 3 && credit != 6 && credit != 9 && credit != 12) {
            System.out.print("Lama Cicilan (3/6/9/12): ");
            credit = s.nextInt();
        }
        
        listOfPayments.add(new Credit(listOfItems.get(id), credit));
        
        System.out.println("Harga pembayaran: " + listOfPayments.get(listOfPayments.size()-1).pay());
        System.out.println("Bayar           : ");
        
        pay = s.nextInt();
        
        while (pay < listOfPayments.get(listOfPayments.size()-1).pay()) {
            System.out.println("Jumlah uang kurang!");
            pay = s.nextInt();
        }
        
        System.out.println("Transaksi telah dibayar");
    }
}
