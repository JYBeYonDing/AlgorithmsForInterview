package 其他算法收集;

/**
 * Created by 杨杰 on 2018/5/17 20:57.
 */
public class 找素数 {
    //****************************************************************************************
    // 素数打表
    /**
     * n以内的素数，效率最高
     * 2；是素数，则2*2, 2*3，2*4，………这些都不是素数，
       3；是素数，则3*3, 3*4，3*5，………这些都不是素数，
       5；是素数，则5*5, 5*6，5*7，………这些都不是素数，
     * @param n
     */
    private static void printPrime3(int n) {
        int[] arr = new int[n+1];
        double m = Math.sqrt(n + 0.5);
        for(int i=2;i<=m;i++) {
            if (arr[i] == 0) {//如果i是素数
                for(int j = i*i;j<=n;j+=i) {
                    arr[j] = 1;//j不是素数
                }
            }
        }
        for(int i=2;i<=n;i++) {// 遍历，为0的即是素数
            if (arr[i] == 0) {
                System.out.print(i+" ");
            }
        }
    }


    /**
     * 2开始的n个素数
     * @param n
     */
    private static void printNPrime(int n) {
        int[] arr = new int[n];
        arr[0] = 2;
        int len = 1;
        boolean isPrime=true;//一开始都假设是素数
        for (int num=3;len<n;num++) {
            for(int i=0;i<len;i++) {
                if (num % arr[i] == 0) {// 能整除，说明不是素数
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                arr[len++] = num;
            } else {
                isPrime = true;
            }
        }
        //打印
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    // 方法一
    public static void main(String[] args) {
//        printPrime(100);
//        System.out.println();
//        printPrime3(100);
        printNPrime(26);
    }

    /**
     * 暴力查找
     * 查找n以内的素数
     */
    private static void printPrime(int n) {
        for (int i = 2; i < n; i++) {
            int count = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
                if (j == i && count == 1) {//如果只有一个因子，且是他本身就是素数，打印
                    System.out.print(i + " ");
                }
                if (count > 1) {// 多余一个因子直接跳过
                    break;
                }
            }
        }
    }
//********************************************************************************************************
    /**
     * 方法二
     * 使用开根号的方法，减少了部分搜索空间
     */
    public static void main2(String[] args) {

        for (int j = 2; j < 1000; j++) {
            if (m(j)) {
                System.out.print(j + " ");
            }
        }
    }

    /**
     * 使用开根号的方法，减少了部分搜索空间
     * @param num
     * @return
     */
    public static boolean m(int num) {
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;// 只要有一个能整除就立马返回false
            }
        }
        return true;
    }
}
