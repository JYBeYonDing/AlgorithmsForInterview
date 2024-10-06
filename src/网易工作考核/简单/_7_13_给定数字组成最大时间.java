package 网易工作考核.简单;

import java.util.Arrays;
import java.util.Scanner;

public class _7_13_给定数字组成最大时间 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int max = -1;
        String time = "";
        for (int i = 0; i < nums.length; i++) {
            int maxTime = 0;
            boolean[] visited = new boolean[nums.length];
            int[] tempTime = new int[nums.length];
            if (nums[i] < 0 || nums[i] > 2) {
                continue;
            }
            visited[i] = true;
            maxTime += 60 * 10 * nums[i];
            tempTime[0] = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (visited[j] == true) {
                    continue;
                }
                if (tempTime[0] == 2) {
                    if (nums[j] > 3) {
                        continue;
                    }
                }
                visited[j] = true;
                maxTime += 60 * nums[j];
                tempTime[1] = nums[j];
                for (int k = 0; k < nums.length; k++) {
                    if (visited[k] == true) {
                        continue;
                    }
                    if (nums[k] >= 6) {
                        continue;
                    }
                    visited[k] = true;
                    maxTime += 10 * nums[k];
                    tempTime[2] = nums[k];
                    for (int l = 0; l < nums.length; l++) {
                        if (visited[l] == true) {
                            continue;
                        }
                        tempTime[3] = nums[l];
                        maxTime += nums[l];
                        if (maxTime > max) {
                            max = maxTime;
                            time = "" + tempTime[0] + tempTime[1] + ":" + tempTime[2] + tempTime[3];
                        }
                    }
                }
            }
        }

        System.out.println(time);
    }


}
