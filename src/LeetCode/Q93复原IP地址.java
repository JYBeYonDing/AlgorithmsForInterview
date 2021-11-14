package LeetCode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 2018/8/29 23:51.
 *
 * 没做完
 */
public class Q93复原IP地址 {

    ArrayList<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        res.clear();

        LinkedList<String> oneIP = new LinkedList<>();
        cut(s, 0, 4,oneIP);

        return res;
    }

    private void cut(String s, int start, int cutNum,LinkedList<String> oneIP) {
        if (start == s.length()) {
            if (cutNum == 0) {
                // 保存
                LinkedList<String> tempIP = (LinkedList<String>) oneIP.clone();
                saveIP(tempIP);
            }
            return;
        }

        for (int end = start; end < s.length() && end-start < 4; end++) {
            String temp = s.substring(start, end + 1);
            if (numIsOk(temp) && cutNum > 0) {
                oneIP.addLast(temp);
                cut(s, end + 1, cutNum - 1, oneIP);// 回溯
                oneIP.removeLast();
            }
        }
    }

    private void saveIP(LinkedList<String> tempIP) {
        StringBuilder oneres = new StringBuilder();
        while (tempIP.size() != 1) {
            oneres.append(tempIP.pollFirst());
            oneres.append(".");
        }
        oneres.append(tempIP.pollFirst());
        res.add(oneres.toString());
    }

    private boolean numIsOk(String substring) {
        if (substring.length() > 1 && substring.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(substring);
        return num <= 255;
    }


    public static void main(String[] args) {
        Q93复原IP地址 ip地址 = new Q93复原IP地址();
        List<String> res = ip地址.restoreIpAddresses("25525511135");
        for (String s : res) {
            System.out.println(s);
        }
    }

}
