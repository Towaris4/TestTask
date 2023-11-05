// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input: ");
        int year = in.nextInt();
        in.close();
        double percent = Firecalc.FindPercent(year)-Firecalc.FindPercent(year)%0.5;
        System.out.print("Input:" + percent);
        }
    }
