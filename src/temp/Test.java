package temp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 杨杰(yangjie7 @ corp.netease.com)
 * @date 2021/11/28 22:12
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        boolean isomorphic = test.isIsomorphic("badc", "baba");
        System.out.println(isomorphic);
    }

    public void method() {

    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hash = new HashMap<>();
        Map<Character, Character> hashRev = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char d = t.charAt(i);
            if ((hash.containsKey(c) && hash.get(c) != d) || (hashRev.containsKey(d) && hashRev.get(d) != c)) {
                return false;
            }
            hash.put(c, d);
            hashRev.put(d, c);
        }
        return true;
    }
}
