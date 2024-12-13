package christmas.model;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    START("별", 5_000),
    NONE("없음", 0);


    private final String type;
    private final int price;

    Badge(final String type, final int price) {
        this.type = type;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public static Badge findByTotalBenefitAmount(int totalBenefitAmount) {
        for (Badge badge : Badge.values()) {
            if (totalBenefitAmount >= badge.getPrice()) {
                return badge;
            }
        }
        return Badge.NONE;
    }
}
