package 其他算法收集;

import java.util.Random;

/**
 * Created by 杨杰 on 2018/8/16 9:43:15.
 * 首先在下标0---n之间随机生成一个下标，将这个下标对应的数和数组的第一个数交换位置；
 * 然后从下标1---n之间随机生成一个下标，将下标对应的数和数组的第二个数交换位置。
 *
 * 扩展：数组长度无穷
 * 思路：建一个长度为k的数组，每需要加入一个数时从[0,k]中产生一个随机数，
 * 如果是k就将这个要加入的数去除，否则用这个数去替换数组中被选择的数。
 */
public class N个数随机等概率取K个数 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr=new int[10];
        for(int i=0;i<10;i++){
            arr[i]=i;
        }
        for(int n: selectM(arr, 5)){
            System.out.println(n);
        }
    }

    //从长度为n的数组中随机的选择m个整数
    public static int[] selectM(int[] arr,int m){
        int len=arr.length;
        if(m>arr.length)
            throw new RuntimeException("xxxxx");
        int[] res=new int[m];
        for(int i=0;i<m;i++){
            int randomIndex=len-1-new Random().nextInt(len-i);
            res[i]=arr[randomIndex];
            int tmp=arr[randomIndex];
            arr[randomIndex]=arr[i];
            arr[i]=tmp;
        }
        return res;
    }

}
