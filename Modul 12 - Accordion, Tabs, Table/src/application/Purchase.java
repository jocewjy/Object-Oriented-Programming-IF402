package application;

public class Purchase extends Transaction{
	public Purchase (Item item, int amount) {
		this.item = item;
		this.amount = amount;
	}
	@Override
	public Integer calculateTransaction() {
		return -item.getPrice()*amount;
	}
	@Override
	public String getTransactionInfo() {
		return item.getName() + "(" + amount + ")"; 
	}
}
