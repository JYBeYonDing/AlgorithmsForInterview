package 牛客网.网易2017实习生;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/10 18:22.
 * 在一条无限长的跑道上，有N匹马在不同的位置上出发开始赛马。
 * 当开始赛马比赛后，所有的马开始以自己的速度一直匀速前进。
 * 每匹马的速度都不一样，且全部是同样的均匀随机分布。
 * 在比赛中当某匹马追上了前面的某匹马时，被追上的马就出局。
 * 请问按以上的规则比赛无限长的时间后，赛道上剩余的马匹数量的数学期望是多少

 输入描述:
 每个测试输入包含1个测试用例
 输入只有一行，一个正整数N
 1 <= N <= 1000


 输出描述:
 输出一个浮点数，精确到小数点后四位数字，表示剩余马匹数量的数学期望

 输入例子1:
 1
 2

 输出例子1:
 1.0000
 1.5000

 速度最大的马无论在什么位置都可以不被淘汰，所以速度最大的马存活的概率是1，
 然后速度第二大的马只有在速度最大的马后面才能存活，只有在它前后两种情况，
 所以存活的概率是1/2，同理，速度第三大的马有三种排列情况（不考虑前面两匹马的排列），
 存活概率是1/3,依次类推，所以最后的情况就是1+1/2+1/3+......1/n。
 注意！！！不是通过每种排列情况计算能存活下来的马的数量，而是根据每匹马能存活的概率计算。
 */
public class 赛马 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.printf("%.4f",solution(N));
    }

    //通过了，但是没想明白，
    // 是根据答案提出来的，可能是既然都是随机分布的，那么直接将各匹马的速度进行排序
    private static double solution(int n) {
        if (n == 1) {
            return 1;
        }
        double res = 1;
        for(int i = 2 ; i <= n ; i++) {
            res = res+1.0/i;
        }
        return res;
    }
}

/**
 * 牛客上别人的暴力方法！！！惊呆！！！
 * 用的暴力求解，思路：数组array大小为马的个数，里面存放了每匹马的速度，
 * 不考虑马速度相等的情况。array = [1,2,3] 表示速度为1的马在最前面，
 * 速度为2的马在中间，速度为3的马在最后面，这种情况对应着：三匹马在场上，
 * 速度最快的马在最前面，速度最慢的马在最后面， 速度在中间的马位置在中间，
 * 则最最终剩下3匹马。 三匹马在场上位置的其他情况还有：
 * [1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]，
 * 分别剩下2、2、2、1、1匹马。 当有n匹马则排列所有可能的情况，对每一种情况求剩下的马的数量。
 * 本来想用高中的学的那点组合数学求个递推式或者直接一个解表达式，
 * 发现数学功底不够... 代码如下，solve()求出每种排列，remain()函数求每种排列剩下的马的数量
 */
class Main{
    static int count = 0;
    public static int remain(int[] array){
        int max = array[0];
        int remain_num = 0;
        for(int i = 0; i < array.length; ++i){
            if(max <= array[i]){
                max = array[i];
                ++remain_num;//这匹马会留下
            }
        }
        return remain_num;
    }
    public static void swap(int[] array,int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void solve(int[] array, int idx){
        if(idx == array.length - 1){
            count += remain(array);
            return ;
        }
        for(int i = idx; i < array.length; ++i){
            swap(array, idx, i);
            solve(array, idx + 1);
            swap(array,idx,i);
        }
    }

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int[] array = new int[num];
            for(int i = 0; i < num; ++i){
                array[i] = i + 1;
            }
            solve(array,0);
            double res = count*1.0;
            for(int j = 0; j < array.length; ++j){
                res = res/array[j];
            }
            String str = String.format("%.4f", res);
            System.out.println(str);
            count = 0;
        }
    }
}