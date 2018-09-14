package LeetCode;

import java.util.*;

/**
 * Created by James on 2018/9/3 12:57.
 */
public class Q216组合总和3 {


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();


        if (n <= 0 || k<=0) {
            return res;
        }



        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            list.addLast(i);
            combinationSum(k, n-i, list, i+1);
            list.removeLast();
        }
        return res;


    }

    /**
     * 从num开始到9，和为n
     */
    private void combinationSum(int k, int n, LinkedList<Integer> list, int num) {

        if (n < 0) {
            return;
        }
        if (n == 0 && list.size()==k) {
            res.add((List<Integer>) list.clone());
            return;
        }

        for (int i = num; i <= 9; i++) {

            list.addLast(i);
            combinationSum(k,n-i,list,i+1);
            list.removeLast();

        }
    }


    public static void main(String[] args) {
        Q216组合总和3 zuhe = new Q216组合总和3();
        List<List<Integer>> res = zuhe.combinationSum3(3, 7);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.println(i);
            }
            System.out.println();

        }
    }
}
