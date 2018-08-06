import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/7/3 21:07.
 */
public class 输入 {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        /**
         * 整型数组
         * 3 -1 2 1
         */
        String[] strings = in.nextLine().split(" ");
        int[] arr = new int[strings.length];
        for(int i = 0;i<strings.length ; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        System.out.println(solution(arr));

        throw new RuntimeException("fa");
    }

    private static int solution(int[] arr) {
        int tempMax = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i<arr.length ; i++) {
            if (sum < 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }
            if (sum > tempMax) {
                tempMax = sum;
            }
        }
        return tempMax;
    }
}
