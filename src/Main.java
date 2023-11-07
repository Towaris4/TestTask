// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input: ");
        try {
            int year = in.nextInt();
            double percent = Firecalc.FindPercent(year);
            System.out.print("Output:" + (percent-percent%0.5) + "\n");
        }
        catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            System.out.println("Exception was processed. Program continues");
        }
        catch (InputMismatchException s) {
            System.out.println(s.getMessage());
            System.out.println("Exception was processed. Program continues");
        }
        }
    }