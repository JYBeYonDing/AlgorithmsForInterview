package 网易工作考核;

import java.util.Scanner;
import java.util.Stack;


/**
 在一个公司里有 N 名员工。这其中有些人有合作关系，有些则没有。他们的合作关系具有传递性。如果已知 A 和 B 有过合作，B 和 C 也有过合作，
 那么我们可以认为 A 和 C 也有间接的合作关系。所谓的合作圈，就是所有间接或直接合作过的员工集合。

 输入格式:
 给定一个 N * N 的矩阵 M（程序实际接收的输入是字符串，参见下面的输入样例），表示公司中员工之间的合作关系。
 如果 M[i][j] = 1，表示已知第 i 个和第 j 个员工有过间接或直接的合作，否则为没有合作过。

 输出格式:
 你需要输出所有员工中的已知的合作圈总数。

 备注：
 N 在[1,200]的范围内

 对于所有员工，有M[i][i] = 1

 如果有M[i][j] = 1，则有M[j][i] = 1

 输入样例:
 在这里给出一组输入。例如：

 1 1 0|1 1 0|0 0 1
 在代码中进行处理，使其变成二维数组 [[1,1,0], [1,1,0], [0,0,1]]

 输出样例:
 根据上面的输入样例，已知员工0和员工1合作过，他们在一个合作圈。 第2个员工自己在一个合作圈。 最后返回2。

 2
 */
public class _7_2合作圈 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
//        String line = "1 1 0|1 1 0|0 0 1";
        String[] lines = line.split("\\|");
        String[][] matrix = new String[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            matrix[i] = lines[i].split(" ");
        }

        int result = 0;
        int N = matrix.length;
        int M = matrix[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if("1".equals(matrix[i][j])){
                    result++;
                    infect(matrix, i, j,N,M);
                }
            }
        }

        System.out.println(result);
    }
    public static void infect(String[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || !"1".equals(m[i][j])) {
            return;
        }
        m[i][j] = "2";
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }
}
