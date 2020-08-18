package Section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code19 {
    public static void main(String[] args) {
        String[] name = new String[1000];
        String[] number = new String[1000];
        int count = 0;

        try {
            Scanner inFile = new Scanner(new File("C:\\Users\\Gunwoong-Heo\\Desktop\\ungk\\workspace\\KOH\\KOH_java_ds\\Chapter1\\input.txt"));
            while(inFile.hasNext()) {
                name[count] = inFile.next();
                number[count] = inFile.next();
                count++;
            }
            inFile.close();
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println("No datea file exists");
            return;
        }

        for (int i = 0; i<count; i++) {
            System.out.println("Name: " + name[i] + ", Phone: " + number[i]);
        }

    }
}