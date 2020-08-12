package Section2;

public class Code17 {
    public static void main(String[] args) {
        //1과 100000 사이에 소수를 찾아서 출력한다.
        for (int i = 2; i <= 10000; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}