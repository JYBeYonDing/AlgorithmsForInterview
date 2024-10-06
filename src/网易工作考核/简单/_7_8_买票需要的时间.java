package 网易工作考核.简单;

import java.util.Scanner;

public class _7_8_买票需要的时间 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        int k = in.nextInt();
        String[] s = string.split(" ");
        int[] list = new int[s.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(s[i]);
        }
        int res = 0;
        for (int i = 0; i < list.length; i++) {
            if (i <= k) {
                res += list[i] <= list[k] ? list[i] : list[k];
            } else {
                res += list[i] <= list[k] - 1 ? list[i] : list[k] - 1;
            }
        }
        System.out.println(res);
    }
}
