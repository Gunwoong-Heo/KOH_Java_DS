package Section3;

import java.io.*;
import java.util.Scanner;

public class Code22 {

    static String[] words = new String[100000];
    static int[] count = new int[100000];
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
                    System.out.println("The word" + keyword + " appears " + count[index] + "times.");
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
                out.println(words[i] + " " + count[i]);
            }
            out.close();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Save failed.");
        }
    }

    private static int findWord(String keyword) {
        for (int i = 0; i < n; i++) {
            if (words[i].equals(keyword)) {
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
            count[index]++;
        } else {
            int i = n - 1;
            for(; i>=0 && words[i].compareToIgnoreCase(word)>0; i--) {
                words[i+1] = words[i];
                count[i+1] = count[i];
            }
            words[i+1] = word;
            count[i+1] = 1;
            n++;
        }
    }

}