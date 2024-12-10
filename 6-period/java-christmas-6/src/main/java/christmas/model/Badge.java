package christmas.model;

public enum Badge {
    START("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private final String badge;
    private final int baseAmount;

    Badge(String badge, int baseAmount) {
        this.badge = badge;
        this.baseAmount = baseAmount;
    }

    public static String getBadge(int totalAmount) {
        String finalBadge = "";
        for (Badge baseAmount : Badge.values()) {
            if(totalAmount >= baseAmount.baseAmount) {
                finalBadge = baseAmount.badge;
            }
        }
        return finalBadge;
    }

}
