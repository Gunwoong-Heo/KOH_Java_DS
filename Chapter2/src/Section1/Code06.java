package Section1;

import java.util.Scanner;

public class Code06 {

//    스캐너로 입력받기 (create add calc print exit)

    static Polynomial[] polys = new Polynomial[100];
    static int n = 0;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        while (true) {
            String command = kb.next();
            if (command.equals("create")) {

            } else if (command.equals("add")) {

            } else if (command.equals("calc")) {

            } else if (command.equals("print")) {

            } else if (command.equals("exit")) {
                break;
            }
        }
        kb.close();
    }

}
