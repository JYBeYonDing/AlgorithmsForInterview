package 练习;

/**
 * Created by 杨杰 on 2018/4/19 16:29.
 * 完成16:41
 */
public class 旋转正方形 {

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }

    private static void rotate(int[][] matrix) {
        int ar = 0;
        int br = matrix.length-1;
        while (ar < br) {
            rotateCircle(matrix, ar++, br--);
        }
    }

    private static void rotateCircle(int[][] matrix, int ar, int br) {
        for(int i = 0 ; i< (br-ar) ; i++) {
            int temp = matrix[ar][ar + i];
            matrix[ar][ar + i] = matrix[br - i][ar];
            matrix[br - i][ar] = matrix[br][br - i];
            matrix[br][br - i] = matrix[ar + i][br];
            matrix[ar + i][br] = temp;
        }
    }
}
