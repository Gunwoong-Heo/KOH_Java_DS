package Section2;

import java.util.Scanner;

public class Code18_2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int data[] = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = kb.nextInt();
        }
        kb.close();

        bubbleSort(data, n);
        System.out.println("Sorted data:");
        for (int i = 0; i < n; i++) {
            System.out.println(data[i]);
        }
    }

    public static void bubbleSort(int[] data, int n) {
        for(int i=n-1; i>0; i--) {
            for( int j=0; j<i; j++) {
                int tmp = data[j];
                if(data[j] > data[j+1]) {
//                    data[j] = data[j+1];
//                    data[j+1] = tmp;
                    swap(data[j], data[j+1]);
                }
            }
        }
    }

    public static void swap(int a, int b) {
        int tmp = a;
        a=b;
        b=tmp;
    }



}