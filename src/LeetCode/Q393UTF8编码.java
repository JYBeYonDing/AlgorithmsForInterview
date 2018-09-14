package LeetCode;

import java.util.Scanner;

/**
 * Created by James on 2018/9/9 11:36.
 */
public class Q393UTF8编码 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        boolean flag = validUtf8(arr);

        System.out.println(flag ? 1 : 0);
    }

    public static  boolean validUtf8(int[] data) {
        int n = data.length;
        int skip = 0b10000000;
        int check = 0;
        for (int i = 0; i < data.length; i++) {
            if (check > 0) {
                if ((data[i] & skip) == skip){
                    check--;
                } else{
                    return false;
                }
            } else {
                check = getHeadType(data[i]);
                if (check < 0){
                    return false;
                }
            }
        }
        return check == 0;
    }
    /**
     * 检查*/
    public static int getHeadType(int num) {
        if ((num & 0b11110000) == 0b11110000) return 3;
        if ((num & 0b11100000) == 0b11100000) return 2;
        if ((num & 0b11000000) == 0b11000000) return 1;
        if ((num & 0b10000000) == 0b10000000) return -1; //error
        return 0;
    }
}
