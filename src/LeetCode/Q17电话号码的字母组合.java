package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 2018/8/29 23:26.
 */
public class Q17电话号码的字母组合 {
    static String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static ArrayList<String> res = new ArrayList<>();


    public List<String> letterCombinations(String digits) {
        res.clear();//这里需要clear一下，因为在测试的时候，会多次调用
        if (digits == null || digits.length() == 0) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }


    private static void findCombination(String digits, int index, String s) {

        if (index == digits.length()) {// 说明digits已经遍历完，保存结果
            // 保存结果s
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        assert (c>='0' && c<='9' && c!='1');

        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }

    }

}
