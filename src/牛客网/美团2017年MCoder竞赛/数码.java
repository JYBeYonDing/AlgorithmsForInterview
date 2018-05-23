package 牛客网.美团2017年MCoder竞赛;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/22 17:21.
 * 链接：https://www.nowcoder.com/acm/contest/5/A
 来源：牛客网

 给定两个整数 l 和 r ，对于所有满足1 ≤ l ≤ x ≤ r ≤ 10^9 的 x ，把 x 的所有约数全部写下来。
 对于每个写下来的数，只保留最高位的那个数码。求1～9每个数码出现的次数。
 输入描述:
 一行，两个整数 l 和 r (1 ≤ l ≤ r ≤ 10^9)。
 输出描述:
 输出9行。

 第 i 行，输出数码 i 出现的次数。
 示例1
 输入
 1 4
 输出
 4
 2
 1
 1
 0
 0
 0
 0
 0


 复杂度一直太大

 */
public class 数码 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(" ");
        int l = Integer.parseInt(ss[0]);
        int r = Integer.parseInt(ss[1]);
        int[] res = solution(l, r);
        for (int i : res) {
            System.out.println(i);
        }
    }

    private static int[] solution(int l, int r) {
        int[] res = new int[9];
//        for(int i = 1;i<=r;i++) {
//            int index = getHigh(i)-1;
//            int count = numOfYueShu(i,l,r);
//            res[index] += count;
//        }

        for(int i = 1;i<=9;i++) {
            for(int j=1;i*j<=r;j*=10) {
                int start = i*j;
                int end = Math.min((i + 1) * j - 1, r);
                for(int k = start;k<=end;k++) {
                    int count = numOfYueShu(k, l, r);
                    res[i-1] += count;
                }
            }
        }
        return res;
    }

    /**
     * [l,r]中有几个数是i的倍数
     */
    private static int numOfYueShu(int i, int l, int r) {
        int count = 0;
        if (i < l) {
            if ((l % i) == 0 || (r % i) == 0) {
                count = (r - l) / i + 1;
            } else {
                if ((i-l%i+r%i)<i) {
                    count = (r - l) / i + 1;
                } else {
                    count = (r - l) / i;
                }
            }
        } else if (i == l) {
            count = (r - l) / i + 1;
        } else if (i < r) {// l<i<r
            count = (r - i) / i + 1;
        } else {
            count = 1;
        }
        return count;
    }

    private static int getHigh(int i) {
//        int high = 0;
//        while (i!=0) {
//            high = i;
//            i = i / 10;
//        }
//        return high;
        String n = i + "";
        return n.charAt(0)-'0';
    }





    /**
     * 设计一个绝对正确的方法
     * 可以是时间复杂度很高的算法，容易写出来，保证正确就行
     * 如果写的不正确，设计样本长度较小的样本，打印出出错的情况，肉眼观察哪里出错了，进行调整
     * @param arr
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 产生随机样本的产生器
     * 随机数组产生规则根据实际情况自己修改
     * @return
     */
    public static int[] generateRandomArray() {
        // 产生一个数组长度在[0,maxSize]内的随机数组
        int l = (int)(10 * Math.random());
        int r = l + (int) (10 * Math.random());
        return new int[]{l, r};
    }

    /**
     * 判断两个结果是否相等的方法
     * 根据实际题目进行调整
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印函数
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 进行大样本测试
     * @param args
     */
    public static void main(String[] args) {
        int testTime = 500000;
        boolean succeed = true;
        int[] input = null;
        int[] arr1 = null;
        int[] arr2 = null;
        for (int i = 0; i < testTime; i++) {
            input = generateRandomArray();
            arr1 = solution(input[0],input[1]);
            arr2 = allright(input[0],input[1]);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "错误!");

        int[] arrInput = input;
        printArray(arrInput);
        printArray(arr1);
        printArray(arr2);
    }

    private static int[] allright(int l, int r) {
        int[] res = new int[9];
        for(int i=l;i<=r;i++) {
            for(int n=1;n<=i;n++) {
                if (i % n == 0) {
                    int index = getHigh(n)-1;
                    res[index]++;
                }
            }
        }
        return res;
    }

}
