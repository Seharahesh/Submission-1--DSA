
import java.util.Scanner;

public class RabbitProblem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int months;
        int a = 0, b = 1, total;

        System.out.print("Enter number of months: ");
        months = input.nextInt();

        System.out.println("Month\tTotal pairs");
        System.out.println("0\t1");

        for (int i = 1; i <= months; i++) {

            total = a + b;
            a = b;
            b = total;

            System.out.println(i + "\t" + b);
        }

        input.close();
    }
}

