package 网易工作考核.简单;

import java.util.LinkedList;
import java.util.Scanner;

public class _7_13_给定数字组成最大时间 {
    private static boolean[] used;
    private static String maxTime = "";

    private static int max = 0;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        used = new boolean[nums.length];
        LinkedList<Integer> time = new LinkedList<>();
        backTrace(nums, 0, time);

        System.out.println(maxTime);
    }

    private static void backTrace(int[] nums, int idx, LinkedList<Integer> time) {
        if (idx == 4) {
            // 统计时间
            if (!valid(time)) {
                return;
            }
            int temp = time.get(0) * 60 * 10 + time.get(1) * 60 + time.get(2) * 10 + time.get(3);
            if (temp > max) {
                maxTime = "" + time.get(0) + time.get(1) + ":" + time.get(2) + time.get(3);
                max = temp;
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                time.addLast(nums[i]);
                backTrace(nums, idx + 1, time);
                used[i] = false;
                time.removeLast();
            }
        }
    }

    /**
     * 判断是否符合时间规则
     *
     * @param time
     * @return
     */
    private static boolean valid(LinkedList<Integer> time) {
        if (time.get(0) > 2) {
            return false;
        }
        if (time.get(0) == 2) {
            if (time.get(1) > 3) {
                return false;
            }
        }
        if (time.get(2) > 5) {
            return false;
        }
        return true;
    }


}
