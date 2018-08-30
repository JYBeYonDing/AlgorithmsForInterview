package 校招2019.拼多多2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by James on 2018/8/30 20:10.
 *
3 4
COKE
TARN
SHOW
 */
public class Main4_2 {

    static ArrayList<String> res = new ArrayList<>();
    static HashSet<String> hashSet = new HashSet<>();
    static int flag = 0;
    public static void main(String[] args) {
        res.clear();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String[] strs = sc.nextLine().split(" ");

        int N = Integer.parseInt(strs[0]);
        int L = Integer.parseInt(strs[1]);

        char[] ans = new char[L];

        boolean[][] chars = new boolean[L][26];



        for (int i = 0; i < N; i++) {
            String stemp = sc.nextLine();
            for (int j = 0; j < stemp.length(); j++) {
                chars[j][stemp.charAt(j)-'A'] = true;
            }
            hashSet.add(stemp);
        }

        StringBuilder sb = new StringBuilder();

        findWord(chars, L,0, ans);


        if (flag == 0) {
            System.out.println("-");
        }

    }

    private static void findWord(boolean[][] chars, int l, int index, char[] ans) {
        if (flag == 1) {
            return;
        }
        if (index == l) {
            String s = new String(ans);
            if (!hashSet.contains(s)) {
                System.out.println(s);
                flag = 1;
                return;
            }
            return;
        }

        for (int i = index; i < l; i++) {
            for (int j = 0; j < 26; j++) {
                if (chars[i][j]) {
                    ans[index]=((char)('A'+j));
                    findWord(chars, l, index + 1, ans);
                }
            }
        }

    }


}