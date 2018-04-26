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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //一行
        String s = sc.nextLine();

        //每个case之后要有空行
        System.out.println(" "+"\n");

        //两个case之间有空行，最后一个没有空行

    }
}
