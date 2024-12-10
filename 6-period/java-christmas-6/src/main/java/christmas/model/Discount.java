package christmas.model;

public record Discount(int christmas, int weekDay, int weekEnd, int presentation, int special) {
    public int totalBenefitAmount() {
        return christmas + weekDay + weekEnd + presentation + special;
    }
}
