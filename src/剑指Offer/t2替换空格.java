package 剑指Offer;

/**
 * Created by 杨杰 on 2018/6/1 10:45.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class t2替换空格 {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("We Are Happy.");
        System.out.println(solution(s));
    }

    private static String solution(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i< str.length();i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
