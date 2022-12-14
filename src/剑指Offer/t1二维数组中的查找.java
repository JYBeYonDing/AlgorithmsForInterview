package 剑指Offer;

/**
 * Created by 杨杰 on 2018/6/1 10:38.
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class t1二维数组中的查找 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution(arr,8));
    }

    private static boolean solution(int[][] array, int target) {
        for(int i = 0,j=array[0].length-1;(i<array.length)&&(j>=0);) {
            if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
