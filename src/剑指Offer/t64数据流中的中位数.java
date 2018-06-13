package 剑指Offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by 杨杰 on 2018/6/13 15:33.
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 可以通过在另外设置一个属性记录数据量来简化编程。
 */
public class t64数据流中的中位数 {
    PriorityQueue<Integer> bigQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    PriorityQueue<Integer> smallQueue = new PriorityQueue<>();
    public void Insert(Integer num) {
        if (bigQueue.size() == 0 || num <= bigQueue.peek()) {
            bigQueue.add(num);
        } else {
            smallQueue.add(num);
        }
        if (bigQueue.size() - smallQueue.size() > 1) {
            while (bigQueue.size() > smallQueue.size() + 1) {
                smallQueue.add(bigQueue.poll());
            }
        }
        if (smallQueue.size()-bigQueue.size() > 1) {
            while (smallQueue.size() > bigQueue.size() + 1) {
                bigQueue.add(smallQueue.poll());
            }
        }
    }

    public Double GetMedian() {
        int bigSize = bigQueue.size();
        int smallSize = smallQueue.size();
        if (bigSize > smallSize) {
            return (double)bigQueue.peek();
        }
        if (bigSize < smallSize) {
            return (double) smallQueue.peek();
        }
        return (bigQueue.peek() + smallQueue.peek()) / 2.0;
    }
}
