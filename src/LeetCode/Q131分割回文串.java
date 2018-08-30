package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 2018/8/30 13:58.
 */
public class Q131分割回文串 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        res.clear();

        if (s == null || s.length() == 0) {
            return res;
        }

        LinkedList<String> oneCut = new LinkedList<>();

        cut(s, 0, oneCut);

        return res;
    }

    private void cut(String s, int index, LinkedList<String> oneCut) {
        if (index == s.length()) {
            LinkedList<String> temp = new LinkedList<>(oneCut);
            res.add(temp);
            return;
        }

        for (int end = index; end < s.length(); end++) {
            String sub = s.substring(index, end + 1);
            if (isHuiWen(sub)) {
                oneCut.addLast(sub);
                cut(s, end + 1, oneCut);
                oneCut.removeLast();
            }
        }
    }


    private boolean isHuiWen(String sub) {
        int len = sub.length();
        for (int i = 0; i < len / 2; i++) {
            if (sub.charAt(i) != sub.charAt(len-1 - i)) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        Q131分割回文串 HuiWenCut = new Q131分割回文串();
        List<List<String>> res = HuiWenCut.partition("aab");
        for (List<String> list : res) {

            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();

        }
    }
}
