package 网易工作考核.简单;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * 给两个整型数组 nums1 和 nums2 ，返回 它们的交集 。
 *
 * 输出结果中的每个元素一定是 唯一 的。输出结果按照从小到大排列。
 *
 * 例如： nums1的内容是[1,2,6,5,9,8]，nums2的内容是[3,9,6]，最后输出的结果是[6,9]。
 *
 *
 * 输入格式:
 * 数组内元素用逗号分隔，数组与数组间用分号分割
 *
 * 输出格式:
 * 输出两个数组中都包含的元素，且是唯一的
 *
 * 在这里输入二组数组。例如：
 *
 * 1,2,6,5,9,6,8;3,9,6
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 6,9
 */
public class _7_26_求两个数组的交集 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] split = s.split(";");
        String[] split1 = split[0].split(",");
        String[] split2 = split[1].split(",");

        Set<Integer> nums1 = new HashSet<>();
        for (int i = 0; i < split1.length; i++) {
            nums1.add( Integer.parseInt(split1[i]));
        }

        Set<Integer> nums2 = new HashSet<>();
        for (int i = 0; i < split2.length; i++) {
            nums2.add(Integer.parseInt(split2[i]));
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (Integer i : nums1) {
            if(nums2.contains(i)){
                res.add(i);
            }
        }
        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        for (Integer re : res) {
            sb.append(re).append(",");
        }
        if (res.isEmpty()) {
            System.out.println("");
        }else{
            System.out.println(sb.substring(0,sb.length()-1));
        }
    }


}
