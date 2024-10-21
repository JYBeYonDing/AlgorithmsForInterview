package org.example.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 存在重复元素3
 * 分数 30
 * 作者
 * 单位
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 *
 * 找出满足下述条件的下标对 (i, j)：
 *
 * i != j
 *
 * abs(i - j) <= indexDiff
 *
 * abs(nums[i] - nums[j]) <= valueDiff
 *
 * 如果存在，返回 1 ；否则，返回 0
 *
 *
 * 提示:
 * 2 <= nums.length <= 10^5
 *
 * -10^9 <= nums[i] <= 10^9
 *
 * 1 <= indexDiff <= nums.length
 *
 * 0 <= valueDiff <= 10^9
 *
 * 运行有时间和内存限制
 *
 * 输入格式:
 * 字符串，包括3部分：数组nums、indexDiff、valueDiff，每部分用英文逗号分隔。
 *
 * 其中，数组nums的每个元素用空格分隔。
 *
 * 输出格式:
 * 0 or 1
 *
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * 1 2 3 1,3,0
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 1
 * 解释：可以找出 (i, j) = (0, 3) 。满足下述 3 个条件：
 * i != j --> 0 != 3
 * abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
 * abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
 *
 *
 *
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 1 5 9 1 5 9,2,3
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 0
 */
public class Middle15 {

    /**
     * 通过桶排序记录滑动窗口内的元素，判断是否存在满足条件的元素
     * 也可以使用有序列表TreeSet来记录滑动窗口的值
     * 有序链表能保证快速获取>x的最小元素
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        //读取
        String[] arr = line.split(",");
        String[] ns = arr[0].split(" ");
        int[] nums = new int[ns.length];
        for(int i = 0; i < ns.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        //下标间隔
        int id = Integer.parseInt(arr[1]);
        //值间隔
        int vd = Integer.parseInt(arr[2]);

        //对于每个元素x，找x前面id个元素里，符合[x-vd, x+vd]的元素

        boolean res = false;
        //每个元素x想找的范围是  [x-vd, x+vd]， 所以最多vd + 1个区间（边界元素多一个区间）
        //桶的数量, 每个桶的元素范围差是vd;
        int tc = vd + 1;
        //桶元素，最多id个（窗口大小），超过了移除最早添加的元素（nums[i-id]， 算出所在的桶）
        //如果滑动窗口内有两个元素相同，一定落在同一个桶，一定满足需求, 所以可以直接算桶移除最早的
        Map<Integer, Integer> map = new HashMap<>(id);
        for(int i = 0; i < ns.length; i++) {
            int x = nums[i];
            int tid = getTid(x, tc);
            if(map.containsKey(tid)) {
                //桶内元素y, x-y <= vd, 满足 [x-vd, x+vd]
                res = true;
                break;
            }
            //相邻桶，有可能在 [x-vd]区间内
            if(map.containsKey(tid - 1) && x - map.get(tid -1) <= vd) {
                res = true;
                break;
            }
            //相邻桶，有可能在 [x+vd]区间内
            if(map.containsKey(tid + 1) && map.get(tid + 1) - x <= vd) {
                res = true;
                break;
            }
            map.put(tid, x);
            if(map.size() > id) {
                //移除最早添加的元素
                map.remove(getTid(nums[i - id], tc));
            }
        }

        System.out.println(res ? 1 : 0);
    }

    private static int getTid(int x, int tc) {
        //负数除法取整是向0取整，和整数不同，因此通过平移让求桶下标稳定
        return (x + 1_000_000_000) / tc;
    }
}
