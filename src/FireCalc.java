public class FireCalc {
    public static double getRemainsOn2022(double percent, int year) {
        double balance = 1;
        double expenditure = balance * percent / 100;
        for (int i = year; i < 2022; i++) {
            balance = balance - expenditure;
            double income = (Constants.MOEX_RATE[i - 2001] / Constants.MOEX_RATE[i - 2002]);
            balance = balance * income;
            expenditure = expenditure * (1 + Constants.INFLATION_RATE[i - 2002] / 100);
        }
        return balance;
    }
    public static double findPercent(int year) throws InvalidInputException {
        if (year > 2021 || year < 2002) {
            throw new InvalidInputException("Input year [2002-2021]");
        }
        double percentValue = 0;
        double balanceOn2022 = getRemainsOn2022(percentValue, year);
        while (Double.compare(balanceOn2022, 0) != -1) {
            percentValue = percentValue + 0.5;
            balanceOn2022 = getRemainsOn2022(percentValue, year);
        }
        return percentValue-0.5;
    }
}




