package 牛客网.计蒜客0519;

import java.util.*;

/**
 * Created by 杨杰 on 2018/5/19 16:04.
 *
 */
public class 房性价比 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        ArrayList<ArrayList<House>> all = new ArrayList<>();
        for(int t = 0 ; t<T;t++) {
            int n = Integer.parseInt(sc.nextLine());
            ArrayList<House> houses = new ArrayList<>();
            for(int i =0 ;i<n ;i++) {
                String[] ss = sc.nextLine().split(" ");
                int s = Integer.parseInt(ss[0]);
                int p = Integer.parseInt(ss[1]);
                houses.add(new House(s, p));
            }
            all.add(houses);
        }
        for(int t = 0; t<T;t++) {
            double res = solution(all.get(t));
            System.out.println(res);
        }
    }

    private static double solution(ArrayList<House> houses) {
        Collections.sort(houses, new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                return o1.s-o2.s;
            }
        });

        double max = Double.MIN_VALUE;
        for(int i=1;i<houses.size();i++) {
            House h1 = houses.get(i - 1);
            House h2 = houses.get(i);
            double h = Math.abs((double) (h1.p - h2.p)) / Math.abs((double) (h1.s - h2.s));
            if (h > max) {
                max = h;
            }
        }
        if (Double.isInfinite(max)) {
            return -1;
        } else {
            return max;
        }
    }

    static class House {
        int s;
        int p;
        double ps;
        public House(int s, int p) {
            this.s = s;
            this.p = p;
            this.ps = (double)p / (double) s;
        }
    }

}
