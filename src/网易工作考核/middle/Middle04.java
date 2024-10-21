package org.example.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 钥匙和房间
 * 分数 30
 * 作者 
 * 单位 
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 *
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
 *
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：rooms = [[1];[2];[3];[]]输出：true
 *
 * 解释：我们从 0 号房间开始，拿到钥匙 1。之后我们去 1 号房间，拿到钥匙 2。然后我们去 2 号房间，拿到钥匙 3。最后我们去了 3 号房间。由于我们能够进入每个房间，我们返回 true。
 *
 * 示例 2：
 *
 * 输入：rooms = [[1,3];[3,0,1];[2];[0]]输出：false
 *
 * 解释：我们不能进入 2 号房间。
 *
 *
 *
 * 提示：
 *
 * n == rooms.length
 *
 * 2 <= n <= 1000
 *
 * 0 <= rooms[i].length <= 1000
 *
 * 1 <= sum(rooms[i].length) <= 3000
 *
 * 0 <= rooms[i][j] < n
 *
 * 所有 rooms[i]  互不相同
 *
 * 输入格式:
 * 字符串表示的二维数组。例如：[[1,3];[3,0,1];[2];[0]]
 *
 * 输出格式:
 * 小些的true/false。例如：false。
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * [[1,3];[3,0,1];[2];[0]]
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * false
 */
public class Middle04 {
    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        in.close();

        List<List<Integer>> rooms = new ArrayList<>();

        String[] strs = line1.split(";");
        for(String s : strs) {
            //去掉中括号
            s = s.replaceAll("[\\[\\]]","");
            List<Integer> list = new ArrayList<>();
            for(String num : s.split(",")) {
                //边界情况, num可能为空
                if(!"".equals(num)) {
                    list.add(Integer.parseInt(num));
                }
            }
            rooms.add(list);
        }

        int n = rooms.size();
        boolean[] visited = new boolean[n];

        //dfs
        dfs(rooms, 0, visited);

        //判断是否所有房间都访问过
        for(boolean b : visited) {
            if(!b) {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }

    private static void dfs(List<List<Integer>> lists, int target, boolean[] visited) {
        //已经访问过
        visited[target] = true;
        List<Integer> list = lists.get(target);
        for(Integer idx : list) {
            if(!visited[idx]) {
                //递归未访问过的房间
                dfs(lists, idx, visited);
            }
        }
    }
}
