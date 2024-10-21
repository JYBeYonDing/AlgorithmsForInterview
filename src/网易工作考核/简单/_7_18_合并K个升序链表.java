package 网易工作考核.简单;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 注意：这道题目按照main是没有通过，但是按照main1是通过的，具体原因未知，可以比对结果试试。
 *
 *
 * 给定一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * <p>
 * 0 <= k <= 10^4
 * <p>
 * 0 <= lists[i].length <= 500
 * <p>
 * -10^4 <= lists[i][j] <= 10^4
 * <p>
 * lists[i] 按 升序 排列
 * <p>
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 数值都是整数
 * <p>
 * 输入格式:
 * lists = [[1,4,5],[1,3,4],[2,6]]
 * <p>
 * 输出格式:
 * [1, 1, 2, 3, 4, 4, 5, 6]
 * <p>
 * 格式说明：
 * 输入和输出需要参照以下样例的数据规范
 * <p>
 * 注意：输出数字前有空格（参考样例）；空列表以“[]” 表示
 */
public class _7_18_合并K个升序链表 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.replace("[", "").replace("]", "").split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            if (!split[i].isEmpty()) {
                nums[i] = Integer.parseInt(split[i].trim());
            }
        }
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        System.out.println(list);

    }

    public static void main1(String[] args) {
        String str = new Scanner(System.in).nextLine();
        System.out.print(Arrays.stream(str.replace("[", "").replace("]", "").split(",")).filter(s -> !"".equals(s)).map(Integer::parseInt).sorted().collect(Collectors.toList()));
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.replace("[", "").replace("]", "").split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String tmp = split[i].trim();
            if(tmp==""){
                continue;
            }
            list.add(Integer.parseInt(tmp));
        }
        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);
        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : arr) {
            res.add(num);
        }

        System.out.println(res);
    }
}
