package 剑指Offer;

/**
 * Created by 杨杰 on 2018/6/14 16:17.
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 */
public class 翻转单词顺序列 {
    static char[] chars = null;
    public static String ReverseSentence(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        chars = str.toCharArray();
        int begin = 0;
        int end = str.length() - 1;
        reverseChars(chars,begin,end);
//        System.out.println(new String(chars));
        begin=0;
        end=0;
        for( ; end<=chars.length ; end++) {
            if (end == chars.length || chars[end] == ' ') {
                reverseChars(chars,begin,end-1);
                begin = end+1;
            }
        }
        return new String(chars);
    }

    private static void reverseChars(char[] chars, int begin, int end) {
        char temp;
        while (begin < end) {
            temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }
    public static void main(String[] args) {
//        String str = "student. a am I";
        String str = "\" \"";
        System.out.println(ReverseSentence(str));

    }
}
