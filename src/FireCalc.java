public class FireCalc {
    public static final int INITIAL_YEAR = 2002;
    public static final int FINAL_YEAR = 2021;
    public static final double STEP_CALCULATION = 1.0;
    public static double getRemainsOn2022(double percent, int year) {
        double balance = 1;
        double expenditure = balance * percent / 100;
        for (int i = year; i <= FINAL_YEAR; i++) {
            balance = balance - expenditure;
            double income = (Constants.MOEX_RATE[i - (INITIAL_YEAR-1)] / Constants.MOEX_RATE[i - INITIAL_YEAR]);
            balance = balance * income;
            expenditure = expenditure * (1 + Constants.INFLATION_RATE[i - INITIAL_YEAR] / 100);
        }
        return balance;
    }
    public static double findPercent(int year) throws InvalidInputException {
        if (year > FINAL_YEAR || year < INITIAL_YEAR) {
            throw new InvalidInputException("Input year [2002-2021]");
        }
        double percentValue = 0;
        double balanceOn2022 = getRemainsOn2022(percentValue, year);
        while (Double.compare(balanceOn2022, 0) != -1) {
            percentValue = percentValue + STEP_CALCULATION;
            balanceOn2022 = getRemainsOn2022(percentValue, year);
        }
        return percentValue-STEP_CALCULATION;
    }
}




