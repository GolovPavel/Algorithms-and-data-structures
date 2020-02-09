import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Даны целые числа 1 <= n <= 10^18 и 1 <= m <= 10^5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * @see Период Пизано
 */
public class FibMod {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();

        System.out.println(fibonacciMod(n, m));
    }

    private static long fibonacciMod(long n, int m) {
        List<Integer> pisanoPeriod = getPisanoPeriod(m);
        return pisanoPeriod.get((int) (n % pisanoPeriod.size()));
    }

    private static List<Integer> getPisanoPeriod(int m) {
        List<Integer> pisanoPeriod = new ArrayList<>();
        pisanoPeriod.add(0);

        if (m == 1) {
            return pisanoPeriod;
        }

        pisanoPeriod.add(1);

        int fib1 = 0;
        int fib2 = 1;
        int tmp;

        while (true) {
            tmp = fib2;
            fib2 = (fib1 + fib2) % m;
            fib1 = tmp;

            pisanoPeriod.add(fib2);

            if (pisanoPeriod.get(pisanoPeriod.size() - 1) == 1 && pisanoPeriod.get(pisanoPeriod.size() - 2) == 0) {
                break;
            }
        }

        return pisanoPeriod.subList(0, pisanoPeriod.size() - 2);
    }
}