package 校招2019.美团;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }


        if (k >= n) {
            System.out.println(0);
            return;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();//数，出现的次数
        int res = 0;
        int l=0;
        int r = k - 1 + l;

        for (int i = 0; i < r; i++) {
            hashMap.put(numbers[i], hashMap.getOrDefault(numbers[i], 0) + 1);
        }
        for (; r < n; r++) {
            hashMap.put(numbers[r], hashMap.getOrDefault(numbers[r], 0) + 1);
            for (int v : hashMap.values()) {
                if (v >= t) {
                    res++;
                    break;
                }
            }
            hashMap.put(numbers[l], hashMap.get(numbers[l]) - 1);
        }
        System.out.println(res);
    }
}
