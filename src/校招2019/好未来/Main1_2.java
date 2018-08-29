package 校招2019.好未来;

import java.util.Scanner;

/**
 * Created by James on 2018/8/28 19:00.
 */
public class Main1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        int l=str.length();
        int ans=0;
        int sum=0;
        int x=0;
        int res;
        for(int i=0;i<l;i++)
        {
            res=(str.charAt(i)-'0')%3;
            sum+=res;
            x++;
            if(res==0||sum%3==0||x==3)
            {
                ans++;
                sum=0;
                x=0;
            }
        }

        System.out.println(ans);

    }
}
