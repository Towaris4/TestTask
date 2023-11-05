
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
    /* public static double FindPercent(int year) { //функция определяет процент при котором баланс к началу 2022 = 0
        double a,b;
        double percent = 0.001;
        while(double r > 0.001) {
            a = remains(percent,year);
            b = remains(percent,year);
        }
        return percent;
    } */
}



