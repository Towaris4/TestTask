import java.util.InputMismatchException;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
public class Firecalc {
    public static double remains(double percent, int year) { //функция находит значение остатка баланса на бирже на 2022
        double capital = 1;
        double expenditure = capital * percent / 100;
        double balance = capital;
        for (int i = year; i < 2022; i++) {
            balance = balance - expenditure;
            double income = (Constants.MOEX_RATE[i - 2001] / Constants.MOEX_RATE[i - 2002]);
            balance = balance * income;
            expenditure = expenditure * (1 + Constants.INFLATION_RATE[i - 2002] / 100);
        }
        return balance;
    }

    public static double FindPercent(int year) throws InvalidInputException, InputMismatchException { //функция определяет процент при котором баланс к началу 2022 >= 0 методом половинного деления
        if (year > 2021 || year < 2002) {
            throw new InvalidInputException("Input year [2002-2021]");
        }
        double a = 0;
        double b = 101;
        double eps = 0.0001;
        while (Math.abs(b - a) > eps) {
            double c = (a + b) / 2;
            double fa = remains(a, year);
            double fb = remains(b, year);
            double fc = remains(c, year);
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




