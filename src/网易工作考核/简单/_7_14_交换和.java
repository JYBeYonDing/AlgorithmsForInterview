package 网易工作考核.简单;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 输出数组，长度为2，输出的数组第一个元素表示第一个数组中需要交换的元素值，第二个元素表示第二个数组中需要交换的元素值。且元素之间以空格分开（结尾无空格）。
 * 若有多个答案，请返回所有答案，多组答案输出顺序按每组答案的第一个元素进行升序输出（若第一个元素相同，则继续按照每组第二个元素升序输出），每组答案单独一行显示，如果结果中有重复答案，请仅显示一组。
 * <p>
 * 若无满足条件的数值，不输出。
 */
public class _7_14_交换和 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        int sum1 = 0;
        int[] nums1 = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums1[i] = Integer.parseInt(split[i]);
            sum1 += nums1[i];
        }
        s = in.nextLine();
        split = s.split(" ");
        int sum2 = 0;
        int[] nums2 = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums2[i] = Integer.parseInt(split[i]);
            sum2 += nums2[i];
        }
        if ((sum2 - sum1) % 2 != 0) {
            return;
        }
        int dif = (sum2 - sum1) / 2;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<String> resultSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] - nums1[i] == dif) {
                    String res = nums1[i] + " " + nums2[j];
                    if (!resultSet.contains(res)) {
                        resultSet.add(res);
                        System.out.println(nums1[i] + " " + nums2[j]);
                    }
                }
            }
        }
    }


}
