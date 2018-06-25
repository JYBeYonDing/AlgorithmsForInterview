package 牛客网.模拟六月场;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by 杨杰 on 2018/6/14 19:34.
 * 一闪一闪亮晶晶，满天都是小星星，牛牛晚上闲来无聊，便躺在床上数星星。
 牛牛把星星图看成一个平面，左上角为原点(坐标为(1, 1))。现在有n颗星星，他给每颗星星都标上坐标(xi，yi)，表示这颗星星在第x行，第y列。
 现在，牛牛想问你m个问题，给你两个点的坐标(a1, b1)(a2，b2)，表示一个矩形的左上角的点坐标和右下角的点坐标，
 请问在这个矩形内有多少颗星星（边界上的点也算是矩形内）。
 输入描述:
 第一行输入一个数字n(1≤n≤100000)，表示星星的颗数。
 接下来的n行，每行输入两个数xi和yi(1≤xi，yi≤1000），表示星星的位置。
 然后输入一个数字m(1≤m≤100000), 表示牛牛询问问题的个数。
 接下来m行，每行输入四个数字a1，b1，a2，b2(1≤a1＜a2≤1000), (1≤b1＜b2≤1000）
 题目保证两颗星星不会存在于同一个位置。
 输出描述:
 输出一共包含m行，每行表示与之对应的每个问题的答案。
 示例1
 输入
4
1 1
2 2
3 3
1 3
4
1 1 2 2
1 1 3 3
2 2 3 3
1 2 2 3
 输出
 2
 4
 2
 2

 测试用例通过50%，不知道错在哪？？？

 读取数据量大的时候不要用Scanner
 用BufferedReader
 */
public class 牛牛数星星 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] stars = new int[1001][1001];
        String[] strs = null;
        for (int i = 0; i < n; i++) {
            strs = reader.readLine().split(" ");
            stars[Integer.parseInt(strs[0])][Integer.parseInt(strs[1])] = 1;
        }
        for(int i=1;i<=1000;i++) {
            for(int j=1;j<=1000;j++) {
                stars[i][j] += (stars[i - 1][j] + stars[i][j - 1]-stars[i-1][j-1]);
            }
        }
        int m = Integer.parseInt(reader.readLine());
        ArrayList<Integer> result = new ArrayList<>();
        int a1 = 0;
        int b1 = 0;
        int a2 = 0;
        int b2 = 0;
        for(int i=0;i<m;i++) {
            strs = reader.readLine().split(" ");
            a1 = Integer.parseInt(strs[0]);
            b1 = Integer.parseInt(strs[1]);
            a2 = Integer.parseInt(strs[2]);
            b2 = Integer.parseInt(strs[3]);
            result.add(stars[a2][b2]+stars[a1-1][b1-1]-stars[a1-1][b2]-stars[a2][b1-1]);
        }
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
