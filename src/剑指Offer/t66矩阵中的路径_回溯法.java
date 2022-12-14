package 剑指Offer;

/**
 * Created by 杨杰 on 2018/6/13 17:09.
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如
 * a b c e
 * s f c s
 * a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 回溯法
 */
public class t66矩阵中的路径_回溯法 {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                char[] temp = matrix.clone();
                if (hasPath(temp, rows,cols,str,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str, int i, int j,int index) {
        if (i<0||i>=rows||j<0||j>=cols||(matrix[i * cols + j] != str[index])) {
            return false;
        } else {
            matrix[i * cols + j] = '#';
            if (index + 1 < str.length) {
                return (hasPath(matrix, rows, cols, str, i + 1, j, index + 1)
                        || hasPath(matrix, rows, cols, str, i - 1, j, index + 1)
                        || hasPath(matrix, rows, cols, str, i, j - 1, index + 1)
                        || hasPath(matrix, rows, cols, str, i, j + 1, index + 1));// 回溯法，使用短路或，一个不行就回退判断另一个
            } else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        System.out.println(hasPath(matrix,3,4,"abab".toCharArray()));
    }
}
