package 校招2019.中国电信;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/10 11:12.
 *
 wqerwq  eeefffwqerwq
 */
public class main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String[] strs = sc.nextLine().split(" +");


        String s = strs[0];
        String t = strs[1];

        int sLen = s.length();
        int tLen = t.length();

        int res = 0;
        int sIndex = sLen > tLen ? sLen-tLen : 0;
        for(; sIndex < sLen ;sIndex++)
        {
            if(match(s,t,sIndex,sLen -1))
            {
                res=sLen - sIndex;

                break;
            }
        }

        if (res == 0) {
            int tIndex = sLen < tLen ? tLen-sLen : 0;
            for(; tIndex < tLen ;tIndex++)
            {
                if(match(t,s,tIndex,tLen -1))
                {
                    res=tLen - tIndex;

                    break;
                }
            }
        }
        System.out.println(res);

    }


    private static boolean match(String s, String t, int sIndex, int end)
    {
        int tIndex = 0;
        for(;sIndex <= end;)
        {
            if(s.charAt(sIndex) != t.charAt(tIndex)) {
                return false;
            }
            sIndex++;
            tIndex++;
        }
        return true;
    }

}