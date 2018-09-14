package 校招2019.百度;

/**
 * Created by James on 2018/9/11 20:21.
 */
public class Main2 {

    public static void main(String[] args) {
        String str = "cabcac";
        int pair = 3;
        int[][] rangeLR = {{1, 6}, {1, 3}, {2, 5}};

        char[] res = rangeFrequent(str, pair, rangeLR);

        for (char c : res) {
            System.out.println(c);
        }
    }

    static char[] rangeFrequent(String str, int pair, int[][] rangeLR)
    {

        char[] res = new char[pair];

        for (int i = 0; i < pair; i++) {
            res[i] = solution(str, rangeLR[i]);
        }

        return res;
        // WRITE YOUR CODE HERE
    }

    private static char solution(String str, int[] range) {
        int L = range[0]-1;
        int R = range[1]-1;


        int[] count = new int[26];

        for (int i = L; i <= R; i++) {
            int index = str.charAt(i) - 'a';
            count[index]++;
        }

        int max = 0;
        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                return (char) ('a' + i);
            }
        }
        return 0;
    }
}
