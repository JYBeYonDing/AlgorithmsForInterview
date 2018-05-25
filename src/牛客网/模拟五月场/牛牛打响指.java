package 牛客网.模拟五月场;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/25 18:06.
 * 链接：https://www.nowcoder.com/questionTerminal/442cbe24e08447729543510c2eb47082
 来源：牛客网

 牛牛在地上捡到了一个手套，他带上手套发现眼前出现了很多个小人，
 当他打一下响指，这些小人的数量就会发生以下变化：
 如果小人原本的数量是偶数那么数量就会变成一半，
 如果小人原本的数量是奇数那么数量就会加一。
 现在牛牛想考考你，他要打多少次响指，才能让小人的数量变成1。
 输入描述:
 每个输入包含一个测试用例。
 输入的第一行包括一个正整数，表示一开始小人的数量N(1<=N<=10^100)。


 输出描述:
 对于每个用例，在单独的一行中输出牛牛需要打多少次响指才能让小人的数量变成1。
 示例1
 输入
 10000
 输出
 20
 */
public class 牛牛打响指 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        BigInteger bg = new BigInteger(N);
        System.out.println(solution(bg));
    }

    private static int solution(BigInteger n) {
        int time = 0;
        BigInteger t = new BigInteger("2");
        while (!n.equals(BigInteger.ONE)) {
            if (n.remainder(t).equals(BigInteger.ZERO)) {
                n = n.divide(t);
            } else {
                n = n.add(BigInteger.ONE);
            }
            time++;
        }
        return time;
    }
}
