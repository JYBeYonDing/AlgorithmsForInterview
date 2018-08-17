package 校招2019.网易;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 杨杰 on 2018/8/11 15:36.
2 2 6
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String[] strs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);
        solution(n,m,k);
    }

    private static void solution(int n, int m,int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append("a");
        }
        for(int i=0;i<m;i++) {
            sb.append("z");
        }
        allPermutation(sb.toString(),k);
    }


    private static void swap(char[] chars, int i, int k) {
        char temp = chars[i];
        chars[i] = chars[k];
        chars[k] = temp;
    }

    private static void allPermutation(String s,int k) {
        //先进行排序，得到字典组最小的排列
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        if (k == 1) {
            System.out.println(s);
            return;
        }
//        System.out.println(new String(chars));
        int ki = 0;
        while (hasNextPermutation(chars)) {
            ki++;
            if (ki == k-1) {
                System.out.println(new String(chars));
                break;
            }

        }
    }

    private static boolean hasNextPermutation(char[] chars) {
        int i;
        for(i=chars.length-2 ;(i>=0)&& chars[i]>=chars[i+1];i--) {
        }
        if (i < 0) {
            return false;
        }
        int j;
        for(j=chars.length-1;(j>i)&&chars[j]<=chars[i];j--) {
        }
        swap(chars, i, j);
        reverse(chars, i + 1, chars.length - 1);
        return true;
    }

    private static void reverse(char[] chars, int start, int end) {
        while (end > start) {
            swap(chars,start++,end--);
        }
    }

}

