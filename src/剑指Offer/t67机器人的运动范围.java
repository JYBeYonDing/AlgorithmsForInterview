package 剑指Offer;

/**
 * Created by 杨杰 on 2018/6/13 17:52.
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class t67机器人的运动范围 {
    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] hasGet = new boolean[rows][cols];
        return movingCountRec(threshold, rows, cols, 0, 0,hasGet);
    }

    private static int movingCountRec(int threshold, int rows, int cols, int i, int j,boolean[][] hasGet) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || !canGet(threshold, i, j)||hasGet[i][j]) {
            return 0;
        } else {
            hasGet[i][j] = true;
            return 1 + movingCountRec(threshold, rows, cols, i - 1, j,hasGet)
                    + movingCountRec(threshold, rows, cols, i + 1, j,hasGet)
                    + movingCountRec(threshold, rows, cols, i, j - 1,hasGet)
                    + movingCountRec(threshold, rows, cols, i, j + 1,hasGet);
        }
    }

    private static boolean canGet(int threshold, int i, int j) {
        int num = 0;
        while (i!= 0) {
            num += i % 10;
            i /= 10;
        }
        while (j != 0) {
            num += j % 10;
            j /= 10;
        }
        return num <= threshold;
    }


    public static void main(String[] args) {
        System.out.println(movingCount(1,4,4));
    }

}
