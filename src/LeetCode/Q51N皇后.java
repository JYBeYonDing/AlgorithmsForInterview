package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 2018/8/30 11:37.
 */
public class Q51N皇后 {

    boolean[] colHasBeenPut;
    boolean[] zhengXieXian;
    boolean[] fanXieXian;

    ArrayList<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        res.clear();

        colHasBeenPut = new boolean[n];
        zhengXieXian = new boolean[2 * n];
        fanXieXian = new boolean[2 * n];

        LinkedList<Integer> one = new LinkedList<>();

        // 确定第row行的皇后放在哪一列
        putOneQueue(n, 0,one);


        return res;
    }

    private void putOneQueue(int n, int row, LinkedList<Integer> one) {
        if (row == n) {

            LinkedList<Integer> temp = (LinkedList<Integer>) one.clone();
            res.add(change(temp));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (canPut(n,row, j)) {
                colHasBeenPut[j] = true;
                zhengXieXian[row + j] = true;
                fanXieXian[row - j + n - 1] = true;
                one.addLast(j);
                putOneQueue(n, row + 1, one);// 回溯法
                one.removeLast();
                colHasBeenPut[j] = false;
                zhengXieXian[row + j] = false;
                fanXieXian[row - j + n - 1] = false;

            }
        }
    }

    private List<String> change(LinkedList<Integer> one) {
        ArrayList<String> res =new ArrayList<>();
        char[] chars = new char[one.size()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = '.';
        }
        while (!one.isEmpty()) {
            int i = one.removeFirst();
            chars[i] = 'Q';
            res.add(new String(chars));
            chars[i] = '.';
        }
        return res;
    }


    private boolean canPut(int n, int i, int j) {
        return (!colHasBeenPut[j] && !zhengXieXian[i + j] && !fanXieXian[i - j + n - 1]);
    }

    public static void main(String[] args) {
        Q51N皇后 n皇后 = new Q51N皇后();
        List<List<String>> ress = n皇后.solveNQueens(8);
        for (List<String> list : ress) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }



    //*************************************************************
    public ArrayList<String[]> solveNQueens2(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sol[] = new int[n];
        boolean col[] = new boolean[n], diag1[] = new boolean[n + n], diag2[] = new boolean[n + n];
        ArrayList<String[]> result = new ArrayList<String[]>();
        helper(0, n, sol, col, diag1, diag2, result);
        return result;
    }
    private void helper(int row, int n, int sol[], boolean col[], boolean diag1[], boolean diag2[], ArrayList<String[]> result) {
        for (int i = 0; i < n; i++) {
            if (!col[i] && !diag1[i + row] && !diag2[i - row + n]) {
                sol[row] = i;
                col[i] = diag1[i + row] = diag2[i - row + n] = true;
                if (row == n - 1) {
                    String ans[] = new String[n];
                    char line[] = new char[n];
                    for (int j = 0; j < n; j++) {
                        int k = -1;
                        while (++k < n) {
                            line[k] = sol[j] == k ? 'Q' : '.';
                        }
                        ans[j] = new String(line);
                    }
                    result.add(ans);
                } else {
                    helper(row + 1, n, sol, col, diag1, diag2, result);
                }
                col[i] = diag1[i + row] = diag2[i - row + n] = false;
            }
        }
    }

}
