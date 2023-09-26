package week06.tugas1;

public class Order {
	private int id, jumlah;
	public static int total;
	private String nama;
	
	private Voucher voucher;	
	private Handphone handphone;
	
	public Order(int id, Voucher voucher, int jumlah) {
		this.id = id;
		this.voucher = voucher;
		this.jumlah = jumlah;
	}
	public Order(int id, Handphone handphone, int jumlah) {
		this.id = id;
		this.handphone = handphone;
		this.jumlah = jumlah;
	}
	public int getId() {
		return this.id;
	}
	public String getNama() {
		return this.nama;
	}
	public int getJumlah() {
		return this.jumlah;
	}

	public Voucher getVoucher() {
        return voucher;
    }

    public Handphone getHandphone() {
        return handphone;
    }
}
