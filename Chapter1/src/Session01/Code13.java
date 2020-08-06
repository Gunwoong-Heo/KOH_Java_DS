package Session01;

import java.util.Scanner;

public class Code13 {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int data[] = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = kb.nextInt();
        }
        kb.close();

        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                // convert data[i] ... data[j] into an integer...
                int val = 0;
                for (int k = i; k <= j; k++) {
                    val = val * 10 + data[k];
                }

                // test if it is a prime
                boolean isPrime = true;
                for (int l = 2; l * l <= val; l++) {
                    if (val % l == 0) {
                        isPrime = false;
                    }
                }

                // if it is prime, compare to the max
                if (isPrime && val > 1 && val > max) {
                    max = val;
                }

            }
        }
        if (max > 0) {
            System.out.println("the max is : " + max);
        } else {
            System.out.println("prime is not exist");
        }

    }
}