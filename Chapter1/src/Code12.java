import java.util.Scanner;

public class Code12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        scanner.close();

        int max = 0;

/*

        13
                -2 3 5 -14 12 3 -9 8 -1 13 2 -5 4
        28

*/
        for (int i = 0; i < n - 1; i++) {
            int sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += data[j];
                if(max < sum) {
                    max=sum;
                }
            }
        }
        System.out.println(max);
    }
}