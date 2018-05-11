package 牛客网.网易2018校招内推;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/11 13:54.
 * 小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,
 * 并且他要求学生按照身高不递减的顺序排列。
 * 有一次,n个学生在列队的时候,小易老师正好去卫生间了。
 * 学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,
 * 他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。
 * 由于按照身高顺序排列的队列的疯狂值是最小的,
 * 他们当然决定按照疯狂值最大的顺序来进行列队。
 * 现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。
 * 小易老师回来一定会气得半死。
 输入描述:
 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示学生的人数
 第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身高

 输出描述:
 输出一个整数,表示n个学生列队可以获得的最大的疯狂值。

 如样例所示:
 当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为15+30+35+20=100。
 这是最大的疯狂值了。

 输入例子1:
5
5 10 25 40 25

 输出例子1:
 100

8
2 3 5 7 11 13 17 19
 82

 测试用例:
15
1 1 1 1 1 1 1 500 500 500 500 1000 1000 1000 1000
 对应输出应该为:
 10986


 */
public class 疯狂队列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] h = new int[N];
        for(int i = 0 ; i< N ;i++) {
            h[i] = sc.nextInt();
        }
        System.out.println(solution(h));
    }

    /**
     * 这种做法有问题
     * @param h
     * @return
     */
    private static int solution(int[] h) {
        int maxH = 0;
        Arrays.sort(h);
        int[] newArray = new int[h.length];
        int mid = h.length/2;
        int r=1;
        int left = 0;
        int right = h.length - 1;
        newArray[mid] = h[right--];
        while (right >= left) {
            if (mid - r >= 0) {
                newArray[mid - r] = h[left++];
            }
            if (mid + r <= newArray.length - 1) {
                newArray[mid + r] = h[left++];
            }
            r++;
            if (mid - r >= 0) {
                newArray[mid - r] = h[right--];
            }
            if (mid + r <= newArray.length - 1) {
                newArray[mid + r] = h[right--];
            }
            r++;
        }

        for(int i = 0; i<newArray.length ; i++) {
            System.out.print(newArray[i]+" ");
        }

        for(int i = 1 ; i< newArray.length; i++) {
            maxH += Math.abs(newArray[i] - newArray[i - 1]);
        }
        return maxH;
    }

}
