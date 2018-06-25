package 计蒜客.复赛20180617;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/6/17 14:31.
 *
 * 复杂度太大，不是到结果对不对
 */
public class 贝壳找房计数比赛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> result = new ArrayList<>();
        String s = null;
        String t = null;
        for (int i = 0; i < T; i++) {
            s = sc.nextLine();
            t = sc.nextLine();
            result.add(solution(s,t));
        }
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static Integer solution(String s, String t) {
        int result = 0;
        //先进行排序，得到字典组最小的排列
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String permuTemp = new String(chars);
        result = result + findT(permuTemp, t);
        result %= 1000000007;
        while (hasNextPermutation(chars)) {
            permuTemp = new String(chars);
            result = result + findT(permuTemp, t);
            result %= 1000000007;
        }
        return result;
    }

    private static int findT(String permuTemp, String t) {
        int num = 0;
        int index = -1;
        while ((index = permuTemp.indexOf(t)) != -1) {
            num++;
            if (index < permuTemp.length() - 1) {
                permuTemp = permuTemp.substring(index + 1);
            } else {
                break;
            }
        }
        return num;
    }


    private static boolean hasNextPermutation(char[] chars) {
        int i;
        // 步骤一：找到排列中最后一个升序的首位位置i，x=ai
        for(i=chars.length-2 ;(i>=0)&& chars[i]>=chars[i+1];i--) {
        }
        if (i < 0) {//说明已经找到了所有的排列
            return false;
        }
        int j;
        // 步骤二：找到排列中第i位右边最后一个比ai大的位置j，y=aj
        for(j=chars.length-1;(j>i)&&chars[j]<=chars[i];j--) {
        }
        // 步骤三：交换x和y
        swap(chars, i, j);
        // 步骤四：把第i+1位到最后的部分翻转
        reverse(chars, i + 1, chars.length - 1);

        return true;
    }

    private static void reverse(char[] chars, int start, int end) {
        while (end > start) {
            swap(chars,start++,end--);
        }
    }
    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
