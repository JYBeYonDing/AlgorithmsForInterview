package 牛客网.美团2018年MCoder资格赛;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/26 12:06.
 * 新店开张免不了大优惠。我们要在小象生鲜超市里采购n个物品，每个物品价格为ai，有一些物品可以选择八折优惠（称为特价优惠）。
 有m种满减优惠方式，满减优惠方式只有在所有物品都不选择特价优惠时才能使用，且最多只可以选择最多一款。
 每种满减优惠描述为(bi,ci)，即满bi减ci（当消费>=bi时优惠ci）。
 求要买齐这n个物品（必须一单买齐），至少需要多少钱（保留两位小数）。
 输入描述:
 第一行，两个整数n,m。
 接下来n行，每行一个正整数ai，以及一个0/1表示是否可以选择特价优惠（1表示可以）。
 接下来m行，每行两个正整数bi,ci，描述一款满减优惠。

 1 <= n,m <=10
 1 <= ai <= 100
 1 <= ci < bi <= 1000
 输出描述:
 一行一个实数，表示至少需要消耗的钱数（保留恰好两位小数）。
 示例1
 输入
2 1
6 1
10 1
12 2
 输出
 12.80
 示例2
 输入
2 2
6 1
10 1
5 1
16 6
 输出
 10.00


 */
public class 下单 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        Good[] goods = new Good[n];
        for(int i = 0 ; i<n; i++) {
            str = sc.nextLine().split(" ");
            goods[i] = new Good(Integer.parseInt(str[0]),Integer.parseInt(str[1])==1);
        }
        CutOff[] cutOffs = new CutOff[m];
        for(int i=0; i<m;i++) {
            str = sc.nextLine().split(" ");
            cutOffs[i] = new CutOff(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
        System.out.printf("%.2f",solution(goods,cutOffs));
    }

    private static double solution(Good[] goods, CutOff[] cutOffs) {
        double res = 0;
        double sumWithGoodCut = 0;
        double sumWithFullCut = 0;
        int sum = 0;
        PriorityQueue<CutOff> maxCutQueue = new PriorityQueue<>(new Comparator<CutOff>() {
            @Override
            public int compare(CutOff o1, CutOff o2) {
                return o2.cut - o1.cut;
            }
        });
        for (Good good : goods) {
            if (good.canCut) {
                sumWithGoodCut += good.price * 0.8;
            } else {
                sumWithGoodCut += good.price;
            }
            sum += good.price;
        }
        for (CutOff cutOff : cutOffs) {
            maxCutQueue.add(cutOff);
        }
        sumWithFullCut = sum;
        while (!maxCutQueue.isEmpty()) {
            CutOff tmp = maxCutQueue.poll();
            if (sum >= tmp.full) {
                sumWithFullCut = sum - tmp.cut;
                break;
            }
        }
        return Math.min(sumWithFullCut, sumWithGoodCut);

    }

    private static class Good{
        int price;
        boolean canCut;

        public Good(int price, boolean canCut) {
            this.price = price;
            this.canCut = canCut;
        }
    }

    private static class CutOff {
        int full;
        int cut;

        public CutOff(int full, int cut) {
            this.full = full;
            this.cut = cut;
        }
    }
}
