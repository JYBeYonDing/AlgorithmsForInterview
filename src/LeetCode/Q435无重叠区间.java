package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
Created by James on 2018/8/18 23:49.
 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 注意:
 可以认为区间的终点总是大于它的起点。
 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 示例 1:
 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 输出: 1
 解释: 移除 [1,3] 后，剩下的区间没有重叠。

 贪心！！！
 用贪心的思想，根据结尾处end，从小到大进行排序，这样后面留给其他线段的空间是最大的。
 然后依次放置，重叠就舍去，不重叠就增加，统计出所有能放置的条数，总数一减就是需要移除的数量。
 */
public class Q435无重叠区间 {

    public static void main(String[] args) {
    }

    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        int max = 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        int end = Integer.MIN_VALUE;//end之后都是空的，可以放其他区间
        for (Interval interval : intervals) {
            if (interval.start < end) {
                continue;
            } else {
                max++;
                end = interval.end;
            }
        }
        return intervals.length-max;
    }




    // 区间
    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}



