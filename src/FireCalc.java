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
        double minPercentValue = 0;
        double maxPercentValue = 101;
        double CALCULATION_ERROR = 0.0001;
        while (Math.abs(maxPercentValue - minPercentValue) > CALCULATION_ERROR) {
            double midPercentValue = (minPercentValue + maxPercentValue) / 2;
            double functionOfMinPercentValue = getRemainsOn2022(minPercentValue, year);
            double functionOfMaxPercentValue = getRemainsOn2022(maxPercentValue, year);
            double functionOfMidPercentValue = getRemainsOn2022(midPercentValue, year);
            if (functionOfMinPercentValue * functionOfMidPercentValue < 0) {
                maxPercentValue = midPercentValue;
            } else if (functionOfMaxPercentValue * functionOfMidPercentValue < 0) {
                minPercentValue = midPercentValue;
            }
        }
        double solution;
        solution = (minPercentValue + maxPercentValue) / 2;
        return solution;
    }
}




