package 练习;

/**
 * Created by 杨杰 on 2018/4/20 15:40.
 * 完成15:53
 * 具体打印和折纸的规则有关
 */
public class 折纸问题 {
    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);

    }

    private static void printAllFolds(int n) {
        boolean isUp = true;
        int i= 1;
        recPrint(i, n, false);
    }

    private static void recPrint(int i, int n, boolean isUp) {
        if (i>n) {
            return;
        }
        recPrint(i +1,n, true);
        if (isUp) {
            System.out.print(i+"上 ");
        } else {
            System.out.print(i+"下 ");
        }
        recPrint(i+1, n,false);
    }
}
