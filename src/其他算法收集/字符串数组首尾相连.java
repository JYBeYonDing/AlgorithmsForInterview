package 其他算法收集;

import java.util.Arrays;

/**
 * Created by James on 2018/8/27 15:39.
 *
 * 给定字符串数组，使其首尾相连。
 *
 * 回溯法！！！
 */
public class 字符串数组首尾相连 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //String [] str = {"ad","dg","gj","jl"};
        String [] str = {"gj","jl","dg","ad","gg","gg"};
        //System.out.println(judge("aa", "dd"));
        fun(str, 0);
    }

    /**
     * 将>=k位置的字符串首尾相连
     * @param str
     * @param k
     */
    private static void fun(String [] str, int k){
        if(k==str.length){// 字符串数组都已经连接完成
            System.out.println(Arrays.toString(str));
            return;
        }

        for(int i=k; i<str.length; ++i){
            //交换k+1和i
            //k=0,表明为第一个字符串，必须和自己以及后面每一个交换
            //k>0时，假设0-(k-1)是排序好的，我们需比较k-1和i的顺序
            if(k==0){
                swap(str, k, i);
                fun(str, k+1);
                swap(str, k, i);
            }else if(k>0 && judge(str[k-1], str[i])){// 如果i位置处的字符串可以接到k-1位置字符串的后面就进行交换。
                swap(str, k, i);
                fun(str, k+1);
                swap(str, k, i);//判断完之后再交换回来，回溯法。
            }

            // 如果不能相连接就什么也不做
        }
    }
    private static void swap(String[] a, int x, int y) {
        String t = a[x];
        a[x] = a[y];
        a[y] = t;
    }
    private static boolean judge(String s1, String s2){
        if(s1.charAt(s1.length()-1)==s2.charAt(0)){
            return true;
        }
        return false;
    }

}
