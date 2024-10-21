package org.example.simple;

import java.util.*;

/**
 * 求两个数组的交集
 * 分数 30
 * 作者 
 * 单位 
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
 *
 * 输入样例:
 * 在这里输入二组数组。例如：
 *
 * 1,2,6,5,9,6,8;3,9,6
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 6,9
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 *
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class Simple34 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        String[] strs = str.split(";");

        List<Integer> list1 = new ArrayList<>();
        for(String s : strs[0].split(",")) {
            list1.add(Integer.parseInt(s));
        }

        Set<Integer> set = new HashSet<>();
        for(String s : strs[1].split(",")) {
            set.add(Integer.parseInt(s));
        }

        Collections.sort(list1);

        Integer pre = 0;
        List<Integer> result = new ArrayList<>();
        for(Integer i : list1) {
            if(set.contains(i) && !i.equals(pre)) {
                result.add(i);
                pre = i;
            }
        }

        if(result.size() > 0) {
            System.out.print(result.get(0));
            for(int i = 1; i < result.size(); i++) {
                System.out.print("," + result.get(i));
            }
            return;
        }

        System.out.println();
    }
}
