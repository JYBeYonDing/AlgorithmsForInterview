import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/4/23 20:47.
 * OJ只是比较输出
 * BufferedInputStream
 * BufferedOutputStream
 *
 * 如果测试数据是多组的，但是恰巧你代码里面需要些标记数组，map，set等，在循环内一定记得清空，
 * 不然可能会产生前面的测试样例影响了后续数据的答案。
 *
 * 注意行末空格
 * 一般系统1秒的算法量级不足10^8，要自己估计算法复杂度
 *
 */
public class 输入输出 {
    public static void main(String[] args) throws IOException {
        /**
         * 读取用BufferedReader！！！效率高
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        Scanner sc = new Scanner(System.in);
        // 应该是每次读入一行效率来的高，所以可以每次读入一行字符串，之后对字符串处理
        String[] ss = sc.nextLine().split(" ");
        int n = Integer.parseInt(ss[0]);


        // 注意！！！：例如输入为2时，如果不使用nextLine()时，
        // 在前面读完nextInt()后，后面的Enter键还没有读入，不注意会出错！！！
        sc.nextInt();
        sc.nextLine();

        //一行
        String s = sc.nextLine();

        //每个case之后要有空行
        System.out.println(" "+"\n");

        //两个case之间有空行，最后一个没有空行

    }
}
