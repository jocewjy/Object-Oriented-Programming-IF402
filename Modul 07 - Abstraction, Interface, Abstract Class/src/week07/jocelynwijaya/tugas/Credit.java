package week07.jocelynwijaya.tugas;

public class Credit extends Payment{
	int installment;
    int maxInstallmentAmount;
    
    public Credit(Item item, int maxInstallmentAmount) {
        super(item);
        this.maxInstallmentAmount = maxInstallmentAmount;
        this.installment = maxInstallmentAmount-1;
    }

    public void paidOff() {
        installment -= 1;
        if (installment == 0) {
            isPaidOff = true;
        }
    }

    @Override
    public int pay() {
        if (isPaidOff) {
            return 0;
        } else {
        	
        }
        return item.getPrice() / maxInstallmentAmount;
    }

    public int getRemainingAmount() {
        if (isPaidOff) {
            return 0;
        }
        return item.getPrice() * installment / maxInstallmentAmount;
    }

    public String getClassName() {
        return "CREDIT";
    }
}
