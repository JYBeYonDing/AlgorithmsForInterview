package org.example.middle;

import java.util.Scanner;

/**
 * Call to your teacher
 * 分数 30
 * 作者
 * 单位 
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
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * 5 5
 * 1 3
 * 2 3
 * 3 4
 * 2 4
 * 4 5
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * Yes
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 4 3
 * 1 2
 * 2 3
 * 4 1
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * No
 */
public class Middle19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line1 = in.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        boolean[][] arr = new boolean[n][n];
        while(m > 0) {
            String[] line = in.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            arr[x-1][y-1] = true;
            m--;
        }
        in.close();
        if(arr[0][n-1]) {
            System.out.println("Yes");
            return;
        }

        boolean[] visit = new boolean[n];
        for(int i = 0; i < n-1; i++) {
            if(!visit[i]) {
                if(dfs(arr, i, visit)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    private static boolean dfs(boolean[][] arr, int x, boolean[] visit) {
        if(arr[x][arr.length - 1]) {
            return true;
        }

        visit[x] = true;

        boolean res = false;
        for(int i = 0; i < arr.length - 1; i++) {
            if(!visit[i] && arr[x][i]) {
                if(dfs(arr, i, visit)) {
                    return true;
                }
            }
        }

        visit[x] = false;

        return false;
    }
}
