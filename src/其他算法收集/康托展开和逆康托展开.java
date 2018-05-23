package 其他算法收集;

import edu.princeton.cs.algs4.In;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 杨杰 on 2018/5/23 9:08.
 * 参考博客：https://blog.csdn.net/wbin233/article/details/72998375
 * 我的为知笔记中也有收藏
 *
 * 康托展开是一个全排列到一个自然数的双射，常用于构建hash表时的空间压缩。
 * 设有n个数（1，2，3，4,…,n），可以有组成不同(n!种)的排列组合，
 * 康托展开表示的就是是当前排列组合在n个不同元素的全排列中的名次。
 * X=a[n]*(n-1)!+a[n-1]*(n-2)!+...+a[i]*(i-1)!+...+a[1]*0!
 * a[i]表示在当前未出现的的元素中排第几个
 */
public class 康托展开和逆康托展开 {
    public static void main(String[] args) {
        int n = 5;
        int[] a = {3, 4, 1, 5, 2};
        int res = contor(a, n);
        System.out.println(res);
        int[] aa= decantor2(res, n);
        for (int i : aa) {
            System.out.print(i+" ");
        }
    }

    private static int FAC[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};// 阶乘

    /**
     * 康托展开
     * 数组a，在（1，2，3，4,…,n）的不同组合中排第几
     */
    private static int contor(int[] a, int n) {
//        int FAC[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};// 阶乘
        int res = 0;
        for(int i=0;i<n;i++) {
            int numOfSmaller = 0;// 在当前位之后，即未出现的元素中小于其的个数
            for(int j=i+1;j<n;j++) {
                if (a[j] < a[i]) {
                    numOfSmaller++;
                }
            }
            res += FAC[n - 1 - i] * numOfSmaller;
        }
        return res;
    }


    /**
     * 逆康托展开
     * 根据n和在所有排序中的位置x，逆推出原数组
     */
    private static int[] decantor(int x, int n) {
        int[] res = new int[n];
//        int FAC[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};// 阶乘
        int[] visited = new int[n];
        for(int index=0;index<n;index++) {
            int r = x % FAC[n - 1 - index];
            int t = x / FAC[n - 1 - index];// （1，2，3，4,…,n）剩下的数中比我小的要有t个
            x = r;

            int count = 0;
            for (int i = 0 ; i<n;i++) {
                if (visited[i] == 0) {
                    count++;
                }
                if (count == t+1) {// 我是剩下数中第t+1小的数
                    res[index] = i + 1;// 因为第i要位置代表的是数字i+1
                    visited[i] = 1;// 表示这个数字已被取
                    break;
                }
            }
        }

        return res;
    }


    /**
     * 逆康托展开
     * 用了数组队列排序的方法
     */
    private static int[] decantor2(int x, int n) {
        ArrayList<Integer> v = new ArrayList<>();// 存放当前可选的数
        int[] a = new int[n];// 所求的排列组合
        for(int i=1;i<=n;i++) {
            v.add(i);
        }
        for(int i=0;i<n;i++) {
            int r = x % FAC[n-i - 1];
            int t = x / FAC[n-i - 1];
            x = r;
            Collections.sort(v);
            a[i] = v.get(t);
            v.remove(t);
        }
        return a;
    }


}
