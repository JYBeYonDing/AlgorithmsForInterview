package 牛客网.网易2019春招;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/4/21 17:37.
 *
 *
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 牛牛希望你能帮他计算一共有多少个可能的数对。

 输入描述:
 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。

 输出描述:
 对于每个测试用例, 输出一个正整数表示可能的数对数量。

 输入例子1:
 5 2

 输出例子1:
 7

 例子说明1:
 满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
 */
public class 数对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
//        System.out.println(solution(n, k));
        System.out.println(solution2(n, k));
    }

    private static long solution2(int n, int k) {
        if (k == 0) {// 如果k为0，说明任意组合都可以
            return n*(long)n;
        }
        // 因为x%y>=k,所以y>k
        // 以y为标准进行考虑
        long count = 0;
        for(int y = k+1; y<=n;y++) {
            count += (n / y) * (y - k);
            int temp = n%y;
            if (temp >= k) {
                count += temp - k + 1;
            }
        }
        return count;
    }









    /**
     * 复杂度太大
     */
    private static int solution(int n, int k) {
        int res = ((n-k)+1)*(n-k)/2;
        for (int i = 1; i <=n ; i++) {
            res += bigDivideSmall(i, k);
        }
        return res;
    }

    private static int bigDivideSmall(int i, int k) {
        int res = 0;
        if (k > ((i - 1) / 2)) {
            return 0;
        } else {
            for(int j = 1; j<i ; j++) {
                if (i % j >= k) {
                    res++;
                }
            }
        }
        return res;
    }
}
