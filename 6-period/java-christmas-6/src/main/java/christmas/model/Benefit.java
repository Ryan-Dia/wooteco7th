package christmas.model;

public record Benefit(int christmasDiscount, int weekDiscount, boolean canPresent, boolean isWeekday,
                      boolean isSpecialDay) {
}
