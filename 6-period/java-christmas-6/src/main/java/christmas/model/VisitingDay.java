package christmas.model;

public class VisitingDay {
    private final int visitingDay;

    public VisitingDay(String input) {
        validate(parseToNumber(input));
        this.visitingDay = parseToNumber(input);
    }

    private void validate(int visitingDay) {
        if(visitingDay < 1 || visitingDay > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private int parseToNumber(String input) {
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public int getVisitingDay() {
        return visitingDay;
    }
}
