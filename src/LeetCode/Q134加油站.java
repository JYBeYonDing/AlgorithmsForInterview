package LeetCode;

/**
 * Created by James on 2018/9/2 11:50.
 */
public class Q134加油站 {


    // 我的方法，暴力，复杂度O（N^2）
    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++) {
            gas[i] = gas[i] - cost[i];
        }

        for (int start = 0; start < gas.length; start++) {

            int remain = 0;
            for (int i = start; i < gas.length; i++) {
                remain += gas[i];
                if (remain < 0) {
                    break;
                }
            }
            if (remain >= 0) {
                for (int i = 0; i < start; i++) {
                    remain += gas[i];
                    if (remain < 0) {
                        break;
                    }
                }
            }
            if (remain >= 0) {
                return start;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        Q134加油站 jiayou = new Q134加油站();
        System.out.println(jiayou.canCompleteCircuit(new int[]{5,1,2,3,4},new int[]{4,4,1,5,1}));
    }






    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int k = 0;
        for(int i=0;i<gas.length;i++){
            sum += gas[i] - cost[i];
            if(sum<0){
                k = i+1;
                sum = 0;
            }
            total += gas[i] - cost[i];
        }
        if(total<0)
            return -1;
        else
            return k;
    }


    /**
     *
     *
     * 维护两个指针, end(终止下标) 和start(开始下标), end = 0, start = length - 1
     * sum = gas[start] - cost[start]， 表示当前累计油量
     *
     * 若sum > 0， 表示油量可以支持end右移
     * 若sum < 0, 表示油量不够， 需要将start左移
     * 若end >= start(环游一周), 若sum大于等于0， 返回start, 否则返回-1
     *
     */
    public int canCompleteCircuit3(int[] gas, int[] cost) {
        int len = gas.length;
        int start = len - 1,end = 0;
        int sum = gas[start] - cost[start];

        while(end < start){
            if(sum >= 0){
                sum += gas[end] - cost[end];
                end++;
            }else{
                start--;
                sum += gas[start] - cost[start];
            }
        }

        return sum >= 0 ? start : -1;
    }
}
