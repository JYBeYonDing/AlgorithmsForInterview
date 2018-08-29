package 校招2019.好未来;

import java.util.Scanner;

/**
 * Created by James on 2018/8/28 19:00.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        int[] num = new int[str.length()];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(str.charAt(i) + "");
        }

        int sum = 0;
        int res = 0;

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            sum += (str.charAt(i) -'0');
            count++;
            if (sum % 3 == 0 || count==3) {
                res++;
                sum = 0;
                count=0;
            }
        }
        System.out.println(res);

    }
}
