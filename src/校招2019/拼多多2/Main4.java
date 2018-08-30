package 校招2019.拼多多2;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/8/30 20:10.
 *
3 4
COKE
TARN
SHOW


 复杂度太大了！！！注意题目中说了只是大写字母！！！所以可以大大简化，大写字母只有26个。
 要先分析条件，再写代码。

 看Main4_2
 */
public class Main4 {

    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) {
        res.clear();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        String[] strs = sc.nextLine().split(" ");

        int N = Integer.parseInt(strs[0]);
        int L = Integer.parseInt(strs[1]);

        String[] strings = new String[N];

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            strings[i] = sc.nextLine();
            hashSet.add(strings[i]);
        }

        Arrays.sort(strings);

        StringBuilder sb = new StringBuilder();

        findWord(strings, hashSet, 0, N, L,sb);

        Collections.sort(res);

        if (res.size() == 0) {
            System.out.println("-");
        }
        System.out.println(res.get(0));

    }

    private static void findWord(String[] strings, HashSet<String> hashSet, int index, int n, int l, StringBuilder sb) {

        if (index == l) {
            String str = sb.toString();
            if (!hashSet.contains(str)) {
                //把这个放入结果集中
                res.add(str);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            sb.append(strings[i].charAt(index));
            findWord(strings, hashSet, index + 1, n, l, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


}