package 牛客网.分班测试;

import java.util.Scanner;

public class 循环单词 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] words = new String[n];
        int count = 0;//记录循环单词的种数
        boolean[] hasCount = new boolean[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.nextLine();
            for (int j = 0; j < i; j++) {
                //没输入一个新的单词就判断是不是前面单词的循环单词
                if (isCircle(words[i], words[j])) {
                    if(!hasCount[j]){//如果前面已经计算过，说明是同一种
                        hasCount[j] = true;
                        count++;
                    }
                }
            }
        }


    }

    private static boolean isCircle(String word, String word1) {
        if (word.length() != word1.length()) {
            return false;
        }
        char[] chars2 = (word1+word1).toCharArray();
        char[] chars1 = word.toCharArray();
        int inedx1 = 0;
        int index2 = 0;
        for(; inedx1<chars1.length ; inedx1++) {

        }
        return false;
    }
}
