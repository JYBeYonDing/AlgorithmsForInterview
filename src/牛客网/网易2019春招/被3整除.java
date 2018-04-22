package 牛客网.网易2019春招;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/4/21 16:30.
 * AC 17:06
 *
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
 并且小Q对于能否被3整除这个性质很感兴趣。
 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。

 输入描述:
 输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。

 输出描述:
 输出一个整数, 表示区间内能被3整除的数字个数。

 输入例子1:
 2 5
 输出例子1:
 3

 例子说明1:
 12, 123, 1234, 12345...
 其中12, 123, 12345能被3整除。
 */
public class 被3整除 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int res = solution(start, end);
        System.out.println(res);
    }

    private static int solution(int start, int end) {
        if (end < start) {
            return 0;
        }
        int toEnd = getSum(end);
        int toStart_1 = getSum(start - 1);

        return toEnd - toStart_1;
    }

    // 从1到end位置上的数有多少能被3整除
    private static int getSum(int end) {
        if (end == 1) {
            return 0;
        }
        if (((end-1) % 3) == 1) {
            return (end-2) / 3 * 2 + 1;
        } else {
            return (end-2) / 3 * 2 + 2;
        }
    }
}
