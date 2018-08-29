package 校招2019.好未来;

import java.util.*;
import java.io.*;

/**
 * long 类型有19位。所以能完全表示18位十进制数
 * int 类型最大有10位，所以能完全表示9位十进制数
 */

/**
 * Created by James on 2018/8/29 16:07.
 *
 *
1
1073741802 1073741823
1073741802 1073741823
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        long n = Long.parseLong(sc.nextLine());
        String[] strs;
        long x ;
        long k;
        ArrayList<Long> res = new ArrayList<>();
        for (long i = 0; i < n; i++) {
            strs = sc.nextLine().split(" ");
            x = Long.parseLong(strs[0]);
            k = Long.parseLong(strs[1]);
            res.add(solution2(x, k));
        }

        //输出结果
        for (long i : res) {

            System.out.println(i);
        }

    }


    // 直接位运算，比较方便
    private static Long solution2(long x, long k) {
        long idx = 1;
        long res = 0;
        while (k>0){
            if((x&idx)==0){
                if((k&1)!=0){
                    res+=idx;//将这位表示的数值加入到结果中
                }
                k >>= 1;
            }
            idx <<= 1;
        }
        return res;
    }



    // 转换成字符数组进行位运算很麻烦
    private static Long solution(long x, long k) {
        char[] maxBin = new char[64];
        for (int i = 0; i < maxBin.length; i++) {
            maxBin[i] = '0';
        }
        int index = maxBin.length - 1;
        char[] xBin = Long.toString(x, 2).toCharArray();
        for (int i = xBin.length - 1; i >= 0; i--) {
            maxBin[index--] = xBin[i];
        }
        for (int i = maxBin.length - 1; i >= 0 && k>0; i--) {

            if (maxBin[i] == '0') {
                maxBin[i]= (char) ((k&1)+'0');
                k >>= 1;
            }
        }
        return Long.parseLong(new String(maxBin), 2)-x;
    }



}