package week01.jocelynwijaya.id.ac.umn;
import java.util.Scanner;

public class Tugas2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Masukkan Nama Anda: ");
		String name = scanner.nextLine();
		
		System.out.println("=======================================");
		System.out.println("String Anda: " + name);
		
		System.out.println("1. charAt"+ "\t\t"+ "2. length");
		System.out.println("3. substring(n)" + "\t\t" + "4. substring(m, n)");
		System.out.println("5. contains" + "\t\t" + "6. concat");
		System.out.println("7. replace" + "\t\t" + "8. split");
		System.out.println("9. lowerCase" + "\t\t" + "10. upperCase");
		
		System.out.println("Pilih menu: ");
		int num = scanner.nextInt();
		scanner.nextLine();
		
		switch (num) {
			case 1: {
				System.out.println("-----charAt-----");
				System.out.println("Nama: " + name);
				System.out.println("Input: "); int in = scanner.nextInt();
				
				char result = name.charAt(in);
				System.out.println("Hasil: " + result);
				
				break;
			}
				
	        case 2: {
	        	System.out.println("-----lenght-----");
	        	System.out.println("Nama: " + name);
	        	
	        	int result = name.length();
	        	System.out.println("Hasil: " + result);
	        	
				break;
	        }
	        case 3: {
	        	System.out.println("-----substring(n)-----");
	        	System.out.println("Nama: " + name);
				System.out.println("Input: "); int in = scanner.nextInt();
	        	
				String result = name.substring(in);
				System.out.println("Hasil: " + result);
				
	        	break;
	        }
	        case 4: {
	        	System.out.println("-----substring(m, n)-----");
	        	System.out.println("Nama: " + name);
				System.out.println("Input mulai: "); int inMulai = scanner.nextInt(); 
				System.out.println("Input akhir: "); int inAkhir = scanner.nextInt();
				
				String result = name.substring(inMulai, inAkhir);
				System.out.println("Hasil: " + result);
				
				break;
	        }
	        case 5: {
	        	
	        	System.out.println("-----contains-----");
	        	System.out.println("Nama: " + name);
				System.out.println("Input:");
				String inp = scanner.nextLine();
				
				System.out.println("Hasil: ");
				System.out.println(name.contains(inp));
				
				break;
	        }
	        case 6: {
	        	System.out.println("-----concat-----");
	        	System.out.println("Nama: " + name);
				System.out.println("Input: "); String inp = scanner.nextLine();
				
				System.out.println("Hasil: ");
				System.out.println(name.concat(inp));
				
				break;
	        }
	        case 7: {
	        	System.out.println("-----replace-----");
	        	System.out.println("Nama: " + name);
				System.out.println("Input kata yang diganti: "); String inpG = scanner.nextLine();
				System.out.println("Input kata pengganti: "); String inpP = scanner.nextLine();
				
				System.out.println("Hasil: ");
				System.out.println(name.replace(inpG, inpP));
				
				break;
	        }
	        case 8: {
	        	System.out.println("-----split-----");
	        	System.out.println("Nama: " + name);
				System.out.println("Input: "); String inp = scanner.nextLine();
								
				String[] result = name.split(inp);
				for (int i=0; i < result.length; i++){
					System.out.println("Hasil: " + result[i]);
				}
				break;
	        }
	        case 9: {
	        	System.out.println("-----lowerCase-----");
	        	System.out.println("Nama: " + name);
	        	
	        	String result = name.toLowerCase();
	        	System.out.println("Hasil: " + result);
	        	
	        	break;
	        }
	        case 10: {
	        	System.out.println("-----upperCase-----");
	        	System.out.println("Nama: " + name);

	        	String result = name.toUpperCase();
	        	System.out.println("Hasil: " + result);
	        	
	        	break;
	        }
	        default: System.out.println("Pilihan tidak valid");
		}
	}

} //by: Jocelyn Wijaya - 00000034804
