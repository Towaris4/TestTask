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
        double a = 0;
        double b = 101;
        double eps = 0.0001;
        while (Math.abs(b - a) > eps) {
            double c = (a + b) / 2;
            double fa = getRemainsOn2022(a, year);
            double fb = getRemainsOn2022(b, year);
            double fc = getRemainsOn2022(c, year);
            if (fa * fc < 0) {
                b = c;
            } else if (fb * fc < 0) {
                a = c;
            }
        }
        double solution;
        solution = (a + b) / 2;
        return solution;
    }
}




