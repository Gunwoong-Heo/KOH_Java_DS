    package Section1;

import java.io.*;
import java.util.Scanner;

public class IndexMaker {

//    static String[] words = new String[100000];
//    static int[] count = new int[100000];
    static Item [] items = new Item[100000];
    static int n;

    public static void main(String[] args) {
        //스캐너 생성
        Scanner kb = new Scanner(System.in);
        //while 문을 true로 루프(사용자가 exit를 입력할때까지)
        while (true) {
            //while문을 돌때마다 사용자로부터 하나의 명령을 받아 수행한다.
            System.out.printf("$ ");
            String command = kb.next();
            if (command.equals("read")) {
                String fileName = kb.next();
                makeIndex(fileName);
            } else if (command.equals("find")) {
                String keyword = kb.next();
                int index = findWord(keyword);
                if (index != -1) {
                    System.out.println("The word" + keyword + " appears " + items[index].count + "times.");
                } else {
                    System.out.println("The word" + keyword + " doesn't appear.");
                }
            } else if (command.equals("saveas")) {
                String fileName = kb.next();
                saveAs(fileName);
            } else if (command.equals("exit")) {
                break;
            }
        }
        //스캐너 닫기
        kb.close();

    }

    private static void saveAs(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < n; i++) {
                out.println(items[i].word + " " + items[i].count);
            }
            out.close();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Save failed.");
        }
    }

    private static int findWord(String keyword) {
        for (int i = 0; i < n; i++) {
            if (items[i].word.equals(keyword)) {
                return i;
            }
        }
        return -1;
    }

    private static void makeIndex(String fileName) {
        try {
            Scanner theFile = new Scanner(new File(fileName));
            while (theFile.hasNext()) {
                String word = theFile.next();
                String trimmed = trimming(word);
                if (trimmed != null) {
                    addWord(trimmed.toLowerCase());
                }
            }
            theFile.close();
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println("File not exist!");
        }
    }

    private static String trimming(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        int i = 0;
        int j = str.length() - 1;

        while (i < str.length() && !Character.isLetter(str.charAt(i))) {
            i++;
        }
        while (j >= 0 && !Character.isLetter(str.charAt(j))) {
            j--;
        }
        if (i <= j) {
            return str.substring(i, j + 1);
        } else {
            return null;
        }
    }

    private static void addWord(String word) {
        int index = findWord(word);
        if (index > -1) {
            items[index].count++;
        } else {
            int i = n - 1;
            while(i>=0 && items[i].word.compareToIgnoreCase(word)>0) {
//                items[i+1].word = items[i].word;
//                items[i+1].count = items[i].count;
                items[i+1] = items[i];
                i--;
            }
            items[i+1] = new Item();
            items[i+1].word = word;
            items[i+1].count = 1;
            n++;
        }
    }

}