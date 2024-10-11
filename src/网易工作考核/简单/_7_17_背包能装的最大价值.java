package 网易工作考核.简单;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给定n个物品和一个容量为C的背包，物品i的重量是Wi，其价值为Vi，背包问题是如何选择入背包的物品，使得装入背包的物品的总价值最大。
 * <p>
 * 注意：你可以将物品的一部分装入背包，但不能重复装入。
 * <p>
 * 每个测试用例三行，每行之间用逗号“,”分隔。
 * <p>
 * 第一行包括两个数字，分别代表物品数n和背包容量C。
 * <p>
 * 第二行输入的是n个数，代表的是物品的重量；第三行输入的是n个数，代表的是物品的价值.
 * <p>
 * 在这里给出一组输入。例如：
 * <p>
 * 3,50 <br/>
 * 10,20,30 <br/>
 * 60,100,120 <br/>
 */
public class _7_17_背包能装的最大价值 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int n = Integer.parseInt(split[0]);
        int c = Integer.parseInt(split[1]);
        s = in.nextLine();
        String[] splitW = s.split(",");
        s = in.nextLine();
        String[] splitV = s.split(",");

        ArrayList<Item> items = new ArrayList<>();

        for (int i = 0; i < splitW.length; i++) {
            Item item = new Item();
            item.setW(Integer.parseInt(splitW[i]));
            item.setV(Integer.parseInt(splitV[i]));
            item.setFullV(item.getV() * c / item.getW());
            items.add(item);
        }
        items.sort((o1, o2) -> o2.getFullV() - o1.getFullV());
        int i = 0;
        int res = 0;
        while (i < items.size() && c > 0) {
            Item item = items.get(i);
            if (item.getW() <= c) {
                res += item.getV();
                c -= item.getW();
            } else {
                res += item.getV() * c / item.getW();
                c = 0;
            }
            i++;
        }
        System.out.println(res);

    }

    public static class Item {
        private int w;
        private int v;
        private int fullV;

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public int getFullV() {
            return fullV;
        }

        public void setFullV(int fullV) {
            this.fullV = fullV;
        }
    }

}
