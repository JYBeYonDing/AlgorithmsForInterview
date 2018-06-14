package 牛客网.模拟六月场;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/6/14 19:26.
 * 牛牛与妞妞闲来无聊，便拿出扑克牌来进行游戏。
 * 游戏的规则很简单，两个人随机抽取四张牌，四张牌的数字和最大的取胜
 * （该扑克牌总张数为52张，没有大小王，A=1，J=11，Q=12，K=13，每种数字有四张牌），
 * 现在两人已经分别亮出了自己的前三张牌，牛牛想要知道自己要赢得游戏的概率有多大。
 输入描述:
 输入包含两行，第一行输入三个整数a1，b1，c1(1≤a1，b1，c1≤13)，表示牛牛亮出的扑克牌。
 第二行输入三个整数a2，b2，c2(1≤a2，b2，c2≤13)，表示妞妞所亮出的扑克牌。
 输出描述:
 输出一个数字x（保留4位小数），表示牛牛获胜的概率。
 示例1
 输入
3 5 7
2 6 8
 输出
 0.3905

 暴力做出来连样例算出来都不正确，一开始没想到暴力，其实不会的题可以先用暴力做
 */
public class 牛牛与妞妞 {
    public static void solution(int[] ns, int[] ms) {
        int sumN = 0;
        for (int i : ns) {
            sumN += i;
        }
        int sumM = 0;
        for (int i : ms) {
            sumM += i;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1;i<=13;i++) {
            nums.add(i);
            nums.add(i);
            nums.add(i);
            nums.add(i);
        }
        for (Integer i : ns) {
            nums.remove(i);
        }
        for (Integer i : ms) {
            nums.remove(i);
        }

        Integer tempN = null;
        Integer tempM = null;
        int winNum = 0;
        int sumNum = 0;
        for(int i=0;i< nums.size();i++) {
            tempN = nums.remove(i);
            for(int j = 0;j<nums.size();j++) {
                tempM = nums.remove(j);
                if (tempN + sumN > sumM + tempM) {
                    winNum++;
                }
                sumNum++;
                nums.add(j,tempM);
            }
            nums.add(i, tempN);
        }

        System.out.printf("%.4f",winNum / (double) sumNum);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int[] Ns = new int[3];
        for(int i = 0; i< 3;i++) {
            Ns[i] = Integer.parseInt(strs[i]);
        }
        strs = sc.nextLine().split(" ");
        int[] Ms = new int[3];
        for(int i = 0; i< 3;i++) {
            Ms[i] = Integer.parseInt(strs[i]);
        }
        solution(Ns,Ms);
    }

}
