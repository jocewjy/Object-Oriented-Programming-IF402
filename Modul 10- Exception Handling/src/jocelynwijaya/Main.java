package jocelynwijaya;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner scan;
	static ArrayList<User> listOfUser = new ArrayList<User>();
	
	public static void initialize() {
		listOfUser.add(new User("John", "Doe", 'L', "Jl. Merpati No. 1 RT RW 1, Banten", "admin", "admin"));
	}
	
	public static void main(String[] args) throws Exception {
		scan = new Scanner(System.in);
		int opsi;
		initialize();
		
		for(;;) {
			System.out.println("------Menu Toko Multiguna------");
			System.out.println("1. Login");
			System.out.println("2. Sign Up");
			System.out.print("Pilihan : ");
			opsi = scan.nextInt();
			
			String tes = scan.nextLine();
			System.out.println(tes);
			
			if (opsi == 0) {
				break;
			}
			switch(opsi) {
				case 1: 
					 menuLogin();
					break;
				case 2:
					 handleSignUp();
					break;
				default: System.out.println("Wrong Input\n");
			}
			
		}
		System.out.println("Terima kasih dan sampai jumpa!");

	}
	
	public static void menuLogin() throws Exception {
		System.out.println("Login      : ");
		String uname = scan.nextLine();
		
		System.out.println("Password   : ");
		String pass = scan.nextLine();
		
		handleLogin(uname, pass);
		
	}
	
	public static void handleLogin(String uname, String pass) throws Exception {
		for (User pengguna : listOfUser) {
            if (pengguna.getUsername().contains(uname)) {
                if (pengguna.login(uname, pass) == false) {
                	menuLogin();
                } else {
                    System.out.println(pengguna.greeting());
                    break;
                }
            }
        }
	}
	
	public static void handleSignUp() {
		String namaDepan = "", namaBelakang = "", alamat = "", uname ="", pass = "";
        char jenisKelamin = 'A';
        boolean i = true;
        int ctrNum = 0, ctrUpCase = 0;
        
        while(i) {
            if(uname.length() <= 8) {
				System.out.println("Nama Depan :");
				namaDepan = scan.nextLine();
				
				System.out.println("Nama Belakang :");
				namaBelakang = scan.nextLine();
				
				System.out.println("Jenis Kelamin (L/P) :");
				jenisKelamin = scan.next().charAt(0);
				
				System.out.println("Alamat :");
				alamat = scan.next(); scan.nextLine();
				
				System.out.println("Username :");
				uname = scan.nextLine();
				
				if (uname.length() <= 8) {
                    System.out.println("Username harus lebih dari 8 karakter");
				}
            }
            
            if (uname.length() > 8) {
                System.out.print("Password :");
                pass = scan.next();
                
                if (pass.length() > 5 && pass.length() <= 16) {
                    char [] charPass = pass.toCharArray();

                    for (char c : charPass) {
                        if (Character.isDigit(c)) {
                            ctrNum ++;
                        } else if (Character.isUpperCase(c)){
                            ctrUpCase++;
                        }
                    }

                    if (ctrNum > 0 && ctrUpCase > 0) {
                        System.out.println("User berhasil di daftarkan");
                        listOfUser.add(new User(namaDepan, namaBelakang, jenisKelamin, alamat, uname, pass));
                        
                        i = false;
                        
                        break;
                    } else {
                        System.out.println("Password harus mengandung huruf besar, angka, min 6 karakter dan max 16 karakter");
                    }
                } else {
                    System.out.println("Password harus mengandung huruf besar, angka, min 6 karakter dan max 16 karakter");
                }
            }
		}
	}
}
