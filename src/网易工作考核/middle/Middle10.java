package org.example.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 跳跃距离
 * 分数 30
 * 作者
 * 单位
 * 给定一个非负整数数组nums，最初位于数组的第一个位置；数组中的每个元素表示你在该位置可以跳跃的最大长度。
 *
 * 请确定是否可以到达最后一个位置。
 *
 *
 * 输入格式:
 * 每个测试用例一行，以“,”分隔，代表nums数组
 *
 * 输出格式:
 * 请确定是否可以到达最后一个位置。如果能，返回true，否则返回false
 *
 *
 * 输出样例1：
 * 在这里给出一组输入。例如：
 *
 * 2,3,1,1,4
 * 输出样例1：
 * 在这里给出相应的输出。例如：
 *
 * true
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 3,2,1,0,4
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * false
 */
public class Middle10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        List<Integer> list = new ArrayList<>();
        for(String num : line.split(",")) {
            list.add(Integer.parseInt(num));
        }
        boolean[] visited = new boolean[list.size()];
        System.out.println(dfs(list, 0, visited));
    }

    private static boolean dfs(List<Integer> list, int idx, boolean[] visited) {
        //到达最后一个位置
        if(idx == list.size() - 1) {
            return true;
        }
        //已经访问过
        if(visited[idx]) {
            return false;
        }
        //标记为已访问
        visited[idx] = true;
        int val = list.get(idx);
        //向左
        if(idx - val >= 0) {
            if(dfs(list, idx - val, visited)) {
                return true;
            }
        }
        //向右
        if(idx + val < list.size()) {
            if(dfs(list, idx + val, visited)) {
                return true;
            }
        }
        //回溯
        visited[idx] = false;
        return false;
    }
}
