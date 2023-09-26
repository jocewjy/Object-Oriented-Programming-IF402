package jocelynwijaya.week09.tugas1.model;

public class Order {
	private int jumlah;
	public static int total;
	private String id, nama;
	
	private Voucher voucher;
	private Handphone handphone;
	
	public Order(int id, Barang b, int jumlah) {
		if(b instanceof Handphone){
	        this.id = String.format("OH01-%d",id);
	        this.handphone = (Handphone) b;
	        this.jumlah = jumlah;
	    }
		
	    if(b instanceof Voucher){
	        this.id = String.format("OV01-%d",id);
	        this.voucher = (Voucher) b;
	        this.jumlah = jumlah;
	    }
	}
	public String getId() {
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
