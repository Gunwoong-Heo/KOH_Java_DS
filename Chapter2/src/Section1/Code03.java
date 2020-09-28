package Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code03 {

    // members의 경우 배열 각 칸의 경우도 Person1 객체 형태로만 저장이 가능하다.
    // 일반적인 primitive 타입의 변수를 할당해서 사용을 시도하면 NullPointerException이 발생한다.
    static Person1[] members = new Person1[100];
    static int count = 0;

    public static void main(String[] args) {
        Scanner in;
        try {
            in = new Scanner(new File("Chapter2/input.txt"));
            while (in.hasNext()) {
                String nm = in.next();
                String nb = in.next();
                members[count] = new Person1();
                members[count].name = nm;
                members[count].number = nb;
                count++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No data exists.");
            System.exit(1);
        }

        bubbleSort();

        for (int i = 0; i < count; i++) {
            System.out.println(members[i].name + "'s phone number is :" + members[i].number);
        }
    }

    private static void bubbleSort() {
        for (int i = count-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (members[j].name.compareTo(members[j+1].name) > 0) {
                    Person1 tmp = members[j];
                    members[j] = members[j+1];
                    members[j+1] = tmp;
                }
            }
        }
    }

}