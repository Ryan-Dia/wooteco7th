package christmas.model;

public class Presentation {
    private static final int BASE_AMOUNT = 120_000;
    private static final int PRICE = 25_000;
    private final int count;
    private final int benefitAmount;

    public Presentation(int totalAmount) {
        this.count = calculateCount(totalAmount);
        this.benefitAmount = calculateBenefitAmount(count);
    }

    private static int calculateCount(int totalAmount) {
        if(totalAmount >= BASE_AMOUNT) {
            return 1;
        }
        return 0;
    }

    private static int calculateBenefitAmount(int count) {
        return count * PRICE;
    }

    public int getCount() {
        return count;
    }

    public int getBenefitAmount() {
        return benefitAmount;
    }
}
