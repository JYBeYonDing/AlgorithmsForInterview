package 校招2019.网易;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/8/11 15:36.
5
2 7 3 4 9
3
1 25 11
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String str = scanner.nextLine();
        int n = Integer.parseInt(str);

        String[] strs = scanner.nextLine().split(" ");
        int[] ai = new int[n];
        for(int i =0;i<n;i++) {
            ai[i] = Integer.parseInt(strs[i]);
        }

        str = scanner.nextLine();
        int m = Integer.parseInt(str);

        strs = scanner.nextLine().split(" ");
        int[] qi = new int[m];
        for(int i =0;i<m;i++) {
            qi[i] = Integer.parseInt(strs[i]);
        }

        solution(n,ai,m,qi);
    }

    private static void solution(int n, int[] ai, int m, int[] qi) {
        int[] sums = new int[n+1];
        sums[0]=0;
        for(int i=1;i<=n;i++) {
            sums[i] = sums[i - 1] + ai[i-1];
        }
        int[] res = new int[m];
        for(int i=0;i<m;i++) {
            System.out.println( find(sums, qi[i]));
        }

    }

    private static int find(int[] sums, int q) {
        int index = Arrays.binarySearch(sums,q );
        if (index > 0) {
            return index;
        } else {
            return -index - 1;
        }
    }


}

