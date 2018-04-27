package 练习;

/**
 * Created by 杨杰 on 2018/4/27 10:14.
 */
public class KMP练习 {
    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str,match));
    }

    private static int getIndexOf(String s, String m) {
        if (s == null || m == null || s.length() < m.length() || m.length() == 0) {
            return -1;
        }
        char[] sChars = s.toCharArray();
        char[] mChars = m.toCharArray();

        int si = 0;
        int mi = 0;
        int[] nexts = getNexts(mChars);

        while (si < sChars.length && mi < mChars.length) {
            if (sChars[si] == mChars[mi]) {
                si++;
                mi++;
            } else if (mi == 0) {
                si++;
            } else {
                mi = nexts[mi];
            }
        }
        if (mi == mChars.length) {
            return si - mi;
        } else {
            return -1;
        }

    }

    private static int[] getNexts(char[] mChars) {
        if (mChars.length == 1) {
            return new int[]{-1};
        }
        int[] nexts = new int[mChars.length];
        nexts[0] = -1;
        nexts[1] = 0;

        int pos = 2;
        int cn = nexts[pos - 1];
        for(;pos<nexts.length;) {
            if (mChars[pos - 1] == mChars[cn]) {
                nexts[pos++] = ++cn;
            } else if (cn == 0) {
                nexts[pos++] = 0;
            } else {
                cn = nexts[cn];
            }
        }
        return nexts;
    }
}
