package 剑指Offer;

/**
 * Created by 杨杰 on 2018/6/13 18:29.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 输入描述:
 题目保证输入的数组中没有的相同的数字

 数据范围：
 对于%50的数据,size<=10^4
 对于%75的数据,size<=10^5
 对于%100的数据,size<=2*10^5

 示例1
 输入
 1,2,3,4,5,6,7,0
 输出
 7

 用归并排序的思想

 */
public class 数组中的逆序对 {
    public static int InversePairs(int [] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int[] help = new int[array.length];
        for(int i=0;i<help.length;i++) {
            help[i] = array[i];
        }
        return sortMergeRec(array,help,0,array.length-1);
    }

    private static int sortMergeRec(int[] array,int[] help,  int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + ((end - start) >>1);// 运算符的优先级：蛋运一逼，位落三福
        int leftInversNum = sortMergeRec(array, help, start, mid);
        int rightInversNum = sortMergeRec(array, help, mid + 1, end);
        int num = merge(array,help, start, mid, end);
        return (num+rightInversNum+leftInversNum)%1000000007;
    }

    private static int merge(int[] array, int[] help, int start, int mid, int end) {
        int inverseNum = 0;
        int index = start;
        int left =start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (array[left] < array[right]) {
                help[index++] = array[left++];
            } else {// 右边的数比左边的大，形成逆序对
                inverseNum+=mid-left+1;
                if (inverseNum >= 1000000007) {//里面在增长的过程中也可能越界
                    inverseNum %= 1000000007;
                }
                help[index++] = array[right++];
            }
        }
        while (left <= mid) {
            help[index++] = array[left++];
        }
        while (right <= end) {
            help[index++] = array[right++];
        }
        for (int i = 0; i < end-start+1; i++) {
            array[start+i] = help[start+i];
        }
        return inverseNum%1000000007;
    }

    public static void main(String[] args) {
//        int[] num = {1,2,3,4,5,6,7,0};
        int[] num = {7,5,6,4};
        System.out.println(InversePairs(num));

    }
}
