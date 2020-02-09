import java.util.Scanner;

/**
 * Дано число 1 <= n <= 10^7, необходимо найти последнюю цифру n-го числа Фибоначчи.
 * Числа Фибоначчи растут очень быстро, поэтому при их вычислении нужно быть аккуратным с переполнением.
 */
public class FibLastChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(lastCharFib(n));
    }

    private static int lastCharFib(int n) {
        int[] numbers = new int[n + 1];
        numbers[0] = 0;
        numbers[1] = 1;

        if (n < 2) {
            return numbers[n];
        } else {
            for (int i = 2; i <= n; i++) {
                numbers[i] = (numbers[i - 1] + numbers[i - 2]) % 10;
            }

            return numbers[n];
        }
    }
}