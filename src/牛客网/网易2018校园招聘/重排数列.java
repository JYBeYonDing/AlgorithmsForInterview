package 牛客网.网易2018校园招聘;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/18 22:44.
 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
 牛博士给小易出了一个难题:
 对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 输入描述:
 输入的第一行为数列的个数t(1 ≤ t ≤ 10),
 接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
 第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)


 输出描述:
 对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。

 输入例子1:
2
3
1 10 100
4
1 2 3 4

 输出例子1:
 Yes
 No
 */
public class 重排数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = sc.nextInt();
        sc.nextLine();
        String[] res = new String[round];
        for(int i = 0;i<round ; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] nums = new int[n];
            for(int index = 0 ;index<n;index++) {
                nums[index] = sc.nextInt();
            }
            sc.nextLine();
            res[i]=solution(nums);
        }
        for (String s : res) {
            System.out.println(s);
        }
    }

    private static String solution(int[] nums) {
        int is2 = 0;
        int is4 = 0;
        for (int i : nums) {
            if (i % 2 == 0) {
                is2++;
            }
            if (i % 4 == 0) {
                is4++;
            }
        }
        if (nums.length % 2 == 0) {
            if (is2 + is4 >= nums.length) {
                return ("Yes");
            } else {
                return ("No");
            }
        }else{
            if (is2 + is4 + 1 >= nums.length) {
                return ("Yes");
            } else {
                return ("No");
            }
        }
    }
}
