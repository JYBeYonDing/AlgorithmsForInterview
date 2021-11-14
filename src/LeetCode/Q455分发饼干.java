package LeetCode;


import java.util.Arrays;

/**
 * Created by James on 2018/9/1 19:26.
 */
public class Q455分发饼干 {


    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;

        int gi = g.length - 1;
        for (int i = s.length - 1; i >= 0; i--) {
            while (gi>=0 && g[gi] > s[i]) {
                gi--;
            }
            if (gi >= 0) {
                res++;
                gi--;
            } else {
                break;
            }
        }

        return res;

    }


    public static void main(String[] args) {
        Q455分发饼干 binggan = new Q455分发饼干();
        System.out.println(binggan.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
    }




    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;

        int gi = g.length - 1;

        int si = s.length - 1;
        while (gi >= 0 && si >= 0) {
            if (g[gi] <= s[si]) {
                gi--;
                si--;
                res++;
            } else {
                gi--;
            }
        }

        return res;
    }
}
