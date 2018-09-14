package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by James on 2018/9/4 15:48.
 */
public class Q451根据字符出现频率排序 {


    public String frequencySort(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();// 字符：频率
        for (char c : s.toCharArray()){
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        }

        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];// 下标为频率
        for (char c : frequencyForNum.keySet()) {
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);//下标为频率，lis为桶，桶中存放着该频率的字符
        }
        StringBuilder str = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {// 从频率最大开始
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }

}
