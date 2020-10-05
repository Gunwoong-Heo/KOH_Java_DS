package Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {

    static MyRectangle1[] rects = new MyRectangle1[100];
    static int n = 0;

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("Chapter2/src/data.txt"));

            while (in.hasNext()) {

                int x = in.nextInt();
                int y = in.nextInt();
                int w = in.nextInt();
                int h = in.nextInt();

                MyRectangle1 myRectangle1 = new MyRectangle1();
                myRectangle1.lu = new MyPoint1();
                myRectangle1.lu.x = x;
                myRectangle1.lu.y = y;
                myRectangle1.width = w;
                myRectangle1.height = h;
                rects[n] = myRectangle1;
                n++;
            }

            bubbleSort();

            for (int i = 0; i < n; i++) {
                System.out.println(rects[i].lu.x+" "+rects[i].lu.y+" "+rects[i].width+" "+rects[i].height);
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No data file.");
            System.exit(1);
        }
    }

    private static void bubbleSort() {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (calcArea(rects[j]) > calcArea(rects[j + 1])) {
                    MyRectangle1 tmp = rects[j];
                    rects[j] = rects[j+1];
                    rects[j+1] = tmp;
                }
            }
        }
    }

    private static int calcArea(MyRectangle1 r) {
        return r.width * r.height;
    }
}