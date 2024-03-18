import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> black = new HashSet<>();
        queue.offer("0000");
        for (int i = 0; i < deadends.length; i++) {
            black.add(deadends[i]);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (black.contains(poll)) {
                    continue;
                }

                if (poll.equals(target)) {
                    return res;
                }
                for (int j = 0; j < 4; j++) {
                    String plus = plus(poll, j);
                    if (!visited.contains(plus)) {
                        queue.offer(plus);
                        visited.add(plus);
                    }
                    String minus = minus(poll, j);
                    if (!visited.contains(minus)) {
                        queue.offer(minus);
                        visited.add(minus);

                    }
                }
            }
            res++;
        }
        return -1;
    }

    public String plus(String lock, int i) {
        char[] charArray = lock.toCharArray();
        if (charArray[i] == '9') {
            charArray[i] = '0';
        } else {
            charArray[i] = (char) (charArray[i] + 1);
        }
        return String.valueOf(charArray);
    }

    public String minus(String lock, int i) {
        char[] charArray = lock.toCharArray();
        if (charArray[i] == '0') {
            charArray[i] = '9';
        } else {
            charArray[i] = (char) (charArray[i] - 1);
        }
        return String.valueOf(charArray);
    }
}


//class Solution {
//    public int openLock(String[] deadends, String target) {
//        // 记录需要跳过的死亡密码
//        Set<String> deads = new HashSet<>();
//        for (String s : deadends) deads.add(s);
//        // 记录已经穷举过的密码，防止走回头路
//        Set<String> visited = new HashSet<>();
//        Queue<String> q = new LinkedList<>();
//        // 从起点开始启动广度优先搜索
//        int step = 0;
//        q.offer("0000");
//        visited.add("0000");
//
//        while (!q.isEmpty()) {
//            int sz = q.size();
//            /* 将当前队列中的所有节点向周围扩散 */
//            for (int i = 0; i < sz; i++) {
//                String cur = q.poll();
//
//                /* 判断是否到达终点 */
//                if (deads.contains(cur))
//                    continue;
//                if (cur.equals(target))
//                    return step;
//
//                /* 将一个节点的未遍历相邻节点加入队列 */
//                for (int j = 0; j < 4; j++) {
//                    String up = plusOne(cur, j);
//                    if (!visited.contains(up)) {
//                        q.offer(up);
//                        visited.add(up);
//                    }
//                    String down = minusOne(cur, j);
//                    if (!visited.contains(down)) {
//                        q.offer(down);
//                        visited.add(down);
//                    }
//                }
//            }
//            /* 在这里增加步数 */
//            step++;
//        }
//        // 如果穷举完都没找到目标密码，那就是找不到了
//        return -1;
//    }
//
//    // 将 s[j] 向上拨动一次
//    String plusOne(String s, int j) {
//        char[] ch = s.toCharArray();
//        if (ch[j] == '9')
//            ch[j] = '0';
//        else
//            ch[j] += 1;
//        return new String(ch);
//    }
//
//    // 将 s[i] 向下拨动一次
//    String minusOne(String s, int j) {
//        char[] ch = s.toCharArray();
//        if (ch[j] == '0')
//            ch[j] = '9';
//        else
//            ch[j] -= 1;
//        return new String(ch);
//    }
//}

//leetcode submit region end(Prohibit modification and deletion)
