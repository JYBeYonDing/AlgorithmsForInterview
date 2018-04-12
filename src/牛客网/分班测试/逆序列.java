package 牛客网.分班测试;

import java.util.Scanner;

public class 逆序列 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
            inverse(b, 0, i);
        }
        for (int i = 0 ; i<n-1;i++) {
            System.out.print(b[i]+" ");
        }
        System.out.println(b[n-1]);
    }

    private static void inverse(int[] b, int start, int end) {
        //逆置b序列
        for (int i = 0; i < (end + 1 - start) / 2; i++) {
            int temp = b[start + i];
            b[start + i] = b[end - i];
            b[end - i] = temp;
        }
    }

}
