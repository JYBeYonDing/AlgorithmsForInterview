package 校招2019.美团;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by James on 2018/9/6 20:56.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += solution(numbers, k, t, i);


        }
        System.out.println(res);


    }

    public static int solution(int[] numbers, int k, int t, int start) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int l = numbers.length;
        int end = start + k - 1;
        if (end >= l) {
            return 0;
        }
        for (int i = start; i <= end; i++) {

            hashmap.put(numbers[i], hashmap.getOrDefault(numbers[i], 0) + 1);
        }

        for (int v : hashmap.values()) {
            if (v >= t) {
                return 1;
            }
        }
        return 0;
    }
}
