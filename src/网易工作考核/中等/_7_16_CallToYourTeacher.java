package 网易工作考核.中等;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


/**
 * 从实验室出来后，你忽然发现你居然把自己的电脑落在了实验室里，但是实验室的老师已经把大门锁上了。
 *
 * 更糟的是，你没有那个老师的电话号码。你开始给你知道的所有人打电话，询问他们有没有老师的电话，如果没有，他们也会问自己的同学来询问电话号码。
 *
 * 那么，你能联系到老师并且拿到电脑吗？
 *
 *
 * 输入格式:
 * 存在多组测试样例
 *
 * 每组样例的第一行分别是两个整数n(1<n<=50)，m(1<m<=2000)，n是在题目当中出现的人数，其中你的序号是1号，实验室老师的序号是n。
 * 接下来的m行，每行有两个整数x(1<=x<=n)，y(1<=y<=n)，代表x有y的电话号码。
 *
 * 输出格式:
 * 对于每组测试样例，如果你最终能联系到老师，输出“Yes”，否则输出“No”。
 */
public class _7_16_CallToYourTeacher {

    private static boolean res = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String[] split = s1.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        Map<Integer, List<Integer>> conn = new HashMap<>();
        for (int i = 0; i < m; i++) {
            s1 = in.nextLine();
            split = s1.split(" ");
            int start = Integer.parseInt(split[0]);
            List<Integer> integers = conn.get(start);
            if (integers == null) {
                integers = new ArrayList<>();
                conn.put(start, integers);
            }
            integers.add(Integer.parseInt(split[1]));
        }

        Set<Integer> visited = new HashSet<>();
        dfs(conn, 1, n, visited);

        System.out.println(res?"Yes":"No");
    }

    private static void dfs(Map<Integer, List<Integer>> conn, int i, int n, Set<Integer> visited) {
        if (visited.contains(i)) {
            return;
        }
        if (i == n) {
            res = true;
            return;
        }
        visited.add(i);
        List<Integer> integers = conn.get(i);
        if (integers == null) {
            return;
        }
        for (Integer integer : integers) {
            dfs(conn, integer, n, visited);
        }
    }

}
