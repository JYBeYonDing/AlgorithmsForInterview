package 网易工作考核.简单;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * <p>
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 */
public class _7_22_根据字符出现频率排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] charArray = s.toCharArray();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            Integer orDefault = map.getOrDefault(c, 0);
            map.put(charArray[i], orDefault + 1);
            max = Math.max(max, orDefault + 1);
        }
        StringBuilder[] buckets = new StringBuilder[max+1];
        map.forEach((k, v) -> {
            StringBuilder bucket = buckets[v];
            if (bucket == null) {
                bucket = new StringBuilder();
                buckets[v] = bucket;
            }
            bucket.append(k);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                StringBuilder bucket = buckets[i];
                char[] charArray1 = bucket.toString().toCharArray();
                Arrays.sort(charArray1);
                for (int j = 0; j < charArray1.length; j++) {
                    char c = charArray1[j];
                    for (int k = 0; k < i; k++) {
                        sb.append(c);
                    }
                }

            }
        }

        System.out.println(sb);
    }


}
