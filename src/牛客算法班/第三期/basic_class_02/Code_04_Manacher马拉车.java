package 牛客算法班.第三期.basic_class_02;

/**
 * 一个字符串中找最长回文子串
 * 首先需要对字符串处理，在字符串两头和中间都加入#，加入的字符可以任意，因为比对过程中虚轴永远和虚轴比对
 * 概念：
 * 回文直径
 * 回文半径
 * 回文半径数组记录从每个位置开始扩的回文半径
 * 最右回文右边界：所有回文半径中最靠右的位置
 * 回文右边界的最早中心
 * <p>
 * Manacher算法就是在暴力算法上加速
 * 可能性1：如果当前位置不在回文右边界R里面则暴力扩
 * 如果当前位置在回文右边界R里面，[L...R]为当前最大的回文直径
 * 可能性2：当前位置i关于回文右边界的最早中心的中心对称点i'的回文半径在最大回文直径的内部，则i的回文半径和i'一样
 * 可能性3：i'的回文半径超过了最大回文直径，i的回文半径就是i到R
 * 可能性4：i'的回文半径正好和L压线，i需要从R之后开始验
 * <p>
 * 时间复杂度：可能性1 R在变大，可能性4 R在变大，可能性2和可能性3的时间复杂度为O(1)，所以整个算法的时间复杂度为O(N)。
 *
 * 初级班第9章
 */
public class Code_04_Manacher马拉车 {

    /**
     * 将字符串插入虚轴并返回字符数组
     * 这一步是为了让对称轴都在字符串数组中
     * @param str 字符串
     * @return 插入虚轴后的字符数组
     */
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];// 将字符串扩大，因为需要插入虚轴，+1是因为两边都要插入虚轴
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];// 偶数放“#”，奇数放原字符
        }
        return res;
    }

    /**
     * 求最长回文长度， manacher主函数
     * 下标i从1 ~ length-1 开始遍历。同时借助2个辅助量 mid 和 maxRight ，
     * maxRight 是用来存储我们扫描过的字符串的最右端的下标。
     * mid为扫描最右端时的对称轴下标。
     * 注意，最右端的回文串不一定是最长的回文串。我们只是用maxRight来标识扫描长度。
     * @param str 字符串
     * @return 最长回文长度
     */
    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];// 回文半径数组。即以下标i的字符为对称轴的回文串的最右端与i的差值+1。回文串长度/2+1。
        int pR = 0;// 最右回文右边界，pR不包括在回文内！！！
        int C = -1;// 最右回文边界的最早中心
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            // pR > i：i在最右回文边界的里面，起码有一个不用验的区域，注意：pR不包括在回文内！！！
            pArr[i] = pR > i ? Math.min(pArr[2 * C - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {// 左右边界都没有越界可以进行扩
                //这里即使是情况2或情况3也会向外扩一下，不影响，这样做只是为了让代码更短
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            // 更新
            if (i + pArr[i] > pR ) {
                pR = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        // 这里的回文半径是加了虚轴后的回文半径，并且是以虚轴结尾的，
        // -1后是原数组的回文直径，奇数偶数长度分别举个例子就知道了
        // 最后的结果一定是加了虚轴后的回文直径/2
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
        str1 = "1234321";
        System.out.println(maxLcpsLength(str1));
        str1 = "12344321";
        System.out.println(maxLcpsLength(str1));
    }

}
