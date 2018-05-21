package 牛客网.计蒜客0520;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/20 16:34.
 * 感觉思路有问题，太复杂了
 */
public class 贝壳找房搜房 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        String[] res = new String[m];
        String S = "";
        String[] allm = new String[m];

        ss = sc.nextLine().split(" ");
        int size = Integer.parseInt(ss[0]);
        for(int j=1;j<=size;j++) {
            S += ss[j];
        }
        allm[0] = S;
        boolean canFind = false;
        for(int i = 1 ; i<m ; i++) {
            String M = "";
            ss = sc.nextLine().split(" ");
            size = Integer.parseInt(ss[0]);
            for(int j=1;j<=size;j++) {
                M += ss[j];
                allm[i]=M;
            }
            if (ShasNoM(S, M)) {
                // 如果M的每个字符都不在S中，按字典序拼接S和M
                if ((S + M).compareTo(M + S) < 0) {
                    S = S + M;
                } else {
                    S = M + S;
                }
                canFind = true;
                continue;
            }else{
                if (S.contains(M)) {
                    // S中有M，直接跳过
                    canFind = true;
                    continue;
                } else {
                    // 窗口遍历M，看能否在S中找到
                    boolean have = false;
                    for(int l = 1;l<M.length();l++) {
                        if (M.substring(l).equals(S.substring(0, M.length()-l)) ) {
                            S = M.substring(0,l) + S;
                            have = true;
                            break;
                        }

                    }
                    for(int r=1;r<M.length();r++) {
                        if ((M.substring(0, r).equals(S.substring(M.length()-r)))) {
                            S = S+M.substring(r);
                            have = true;
                            break;
                        }
                    }
                    if (have) {
                        canFind = true;
                    } else {
                        canFind = false;
                    }
                }
            }

        }
        if (canFind == false) {
            System.out.println(-1);
            return;
        }
        System.out.println(minDic(n,allm));


    }

    private static String minDic(int n, String[] allm) {
        int[] ns = new int[n + 1];
        return null;

    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    private static boolean ShasNoM(String s, String m) {
        for(int i=0;i<m.length();i++) {
            if (s.indexOf(m.charAt(i))!=-1) {
                return false;
            }
        }
        return true;
    }
}
