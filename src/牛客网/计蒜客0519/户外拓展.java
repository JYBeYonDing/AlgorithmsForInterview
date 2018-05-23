package 牛客网.计蒜客0519;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/19 17:37.
 * 例子测试没问题，但是OJ测试错误
 */
public class 户外拓展 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0])+1;
        int m = Integer.parseInt(s[1])+1;
        int[][] map = new int[n][m];
        int h = Integer.parseInt(s[2]);
        int k = 1;//k-1次1操作
        int[] p = new int[h+1];
        int[] q = new int[h+1];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0 ; i<h ; i++) {
            s = sc.nextLine().split(" ");
            String task = s[0];
            if (task.equals("I") ) {
                int l = Integer.parseInt(s[1]);
                int r = Integer.parseInt(s[2]);
                int y = Integer.parseInt(s[3]);
                p[k] = Integer.parseInt(s[4]);
                q[k] = Integer.parseInt(s[5]);

                for(int li = Math.min(l,r) ; li<= Math.max(l,r);li++) {
                    map[y][li] = k;
                }
                k++;
            } else if (task.equals("Q")) {
                int x = Integer.parseInt(s[1]);
                int l = Integer.parseInt(s[2]);
                int r = Integer.parseInt(s[3]);
                int happy=0;
                if (l < r) {
                    for(int li=l;li<=r;li++) {
                        if (map[li][x] != 0) {
                            happy = (p[map[li][x]] * happy + q[map[li][x]])%323232323;
                        }
                    }
                } else {
                    for(int li=l;li>=r;li--) {
                        if (map[li][x] != 0) {
                            happy = (p[map[li][x]] * happy + q[map[li][x]])%323232323;
                        }
                    }
                }
                res.add(happy);
            } else {
                int x = Integer.parseInt(s[1]);
                for(int ni = 0;ni<n;ni++) {
                    for(int mi=0;mi<m;mi++) {
                        if (map[ni][mi] == x) {
                            map[ni][mi] = 0;
                            p[x] = 0;
                            q[x] = 0;
                        }
                    }
                }
            }
        }
        for (int i : res) {
            System.out.println(i);
        }
    }
}
