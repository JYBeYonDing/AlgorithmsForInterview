import java.util.HashMap;
import java.util.Map;

import com.netease.backend.db.common.schema.Hash;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
