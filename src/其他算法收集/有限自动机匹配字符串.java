package 其他算法收集;

import java.util.HashMap;

/**
 * Created by 杨杰 on 2018/5/16 20:08.
 * 利用有限自动机进行字符串匹配
 * 注意！！！目前写的这个程序是有局限性的，不通用，使用时注意修改
 * 博客：https://blog.csdn.net/tyler_download/article/details/52549315
 */
public class 有限自动机匹配字符串 {
    /**
     * 跳转表< 状态，< 输入，下一个状态>>
     */
    private HashMap<Integer, HashMap<Character, Integer>> jumpTable = new HashMap<>();
    String P = "ababaca";//匹配字符串
    private final int alphaSize = 3;// 字符串中不同字符的数量
    public 有限自动机匹配字符串(String p) {
        this.P = p;
        makeJumpTable();
    }

    /**
     * 构建跳转表
     */
    private void makeJumpTable() {
        int m = P.length();// 长度为m，则总共有m个状态，状态就表示匹配的字符串长度
        for (int q = 0; q <= m; q++) {
            for (int k = 0; k < alphaSize; k++) {// 这里默认字符为a,b,c,d,e,f...
                char c = (char)('a' + k);// 输入字符c
                String Pq = P.substring(0, q) + c;
                // 字符串P从第一个字符开始，连续几个字符所构成的字符串可以成为S的后缀
                int nextState = findSuffix(Pq);
                System.out.println("from state " + q + " receive input char " + c + " jump to state " + nextState);
                HashMap<Character, Integer> map = jumpTable.get(q);
                if (map == null) {
                    map = new HashMap<Character, Integer>();
                }
                map.put(c, nextState);// 添加字符c时的下一个状态
                jumpTable.put(q, map);
            }
        }
    }

    /**
     * 字符串P从第一个字符开始，连续几个字符所构成的字符串可以成为Pq的后缀
     *
     * @return P中和Pq后缀的最大匹配长度
     */
    private int findSuffix(String Pq) {
        int suffixLen = 0;
        int k = 0;//假设会有k+1长度匹配
        while(k < Pq.length() && k < P.length()) {
            int i = 0;
            for (i = 0; i <= k; i++) {
                if (Pq.charAt(Pq.length() - 1 - k + i) != P.charAt(i)) {
                    break;
                }
            }
            if (i - 1 == k) {// i=k+1,说明上面的循环中没有break跳出，即k+1个字符全部匹配
                suffixLen = k+1;
            }
            k++;
        }
        return suffixLen;
    }

    public int match(String T) {
        Integer q = 0;
        System.out.println("Begin matching...");

        for (int n = 0; n <= T.length(); n++) {
            HashMap<Character, Integer> map = jumpTable.get(q);
            int oldState = q;
            q = map.get(T.charAt(n));
            if (q == null) {
                return -1;
            }
            System.out.println("In state " + oldState + " receive input " + T.charAt(n) + " jump to state " + q);

            if (q == P.length()) {
                return q;
            }
        }

        return -1;
    }
}
