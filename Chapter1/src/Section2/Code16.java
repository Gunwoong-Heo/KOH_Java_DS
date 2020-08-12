package Section2;

import java.util.Scanner;

public class Code16 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter two integers and press Enter");

        int a = kb.nextInt();  // a의
        int b = kb.nextInt();  // b제곱

        int result = power(a, b);
        System.out.println("The Result is : " + result);
        kb.close();
    }

    public static int power(int n, int m) {
        int result = 1;
        for (int i = 0; i < m; i++) {
            result *= n;
        }
        return result;
    }

}