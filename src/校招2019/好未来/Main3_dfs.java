package 校招2019.好未来;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by James on 2018/8/28 19:00.
 * 0 1 1 1 1 1 1 1 1 0
 */
public class Main3_dfs {
    static ArrayList<String> ans = new ArrayList<>();
    static int N = 10;
    static int[] a=new int[N];
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        String s = "";
        dfs(0, s);
        String[] res = ans.toArray(new String[]{});

        Arrays.sort(res);
        for (String str : res) {
            System.out.println(str);
        }

    }

    private static void dfs(int k, String stemp) {
        if (k == 10) {
            ans.add(stemp);
            return;
        }

        if (a[k]==1) {
            stemp +=  k;
            dfs(k + 1, stemp);
        }  else {
            dfs(k + 1, stemp);
            stemp += k;
            dfs(k + 1, stemp);
        }
    }
}
