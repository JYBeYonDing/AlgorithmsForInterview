package 牛客网.分班测试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 穷举法
 */
public class 三角形 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] lengths = new int[n];
        for(int i=0;i<n;i++) {
            lengths[i] = in.nextInt();
        }
        Arrays.sort(lengths);
        int count = 0;
        for(int i = 0 ; i<n-2; i++) {
            for(int j = i+1;j<n-1;j++) {
                for(int k = j+1;k<n;k++) {
                    if ((lengths[i] + lengths[j] > lengths[k]) &&
                            (lengths[j] - lengths[i] < lengths[k])) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
