package 校招2019.Keep;
import java.util.*;
/**
 * Created by James on 2018/9/29 13:02.
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        int[] leftHighest = new int[arr.length];
        leftHighest[0] = 0;
        for (int i = 1; i < leftHighest.length; i++) {
            leftHighest[i] = Math.max(leftHighest[i - 1], arr[i-1]);
        }

        int[] rightHighest = new int[arr.length];
        rightHighest[rightHighest.length-1] = 0;
        for (int i = rightHighest.length-2; i >= 0; i--) {
            rightHighest[i] = Math.max(rightHighest[i + 1], arr[i+1]);
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = Math.min(leftHighest[i], rightHighest[i])- arr[i];
            if (temp > 0) {
                res += temp;
            }
        }
        System.out.println(res);
    }

}
