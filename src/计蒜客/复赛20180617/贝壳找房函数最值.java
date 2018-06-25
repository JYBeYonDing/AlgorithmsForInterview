package 计蒜客.复赛20180617;

import java.util.*;

/**
 * Created by 杨杰 on 2018/6/17 14:05.
 *
 * 复杂度太大，不是到结果对不对
 */
public class 贝壳找房函数最值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> result = new ArrayList<>();

        String[] strs = null;
        int n = 0;
        int x = 0;
        int[] a = null;
        int[] b = null;
        for(int t = 0; t< T;t++) {
            strs = sc.nextLine().split(" ");
            n = Integer.parseInt(strs[0]);
            x = Integer.parseInt(strs[1]);
            strs = sc.nextLine().split(" ");
            a = new int[strs.length];
            for(int i = 0 ; i<a.length;i++ ) {
                a[i] = Integer.parseInt(strs[i]);
            }
            strs = sc.nextLine().split(" ");
            b = new int[strs.length];
            for(int i = 0 ; i<b.length;i++ ) {
                b[i] = Integer.parseInt(strs[i]);
            }

            result.add(solution(n,x,a,b));
        }

        for (int i : result) {
            System.out.println(i);
        }
    }

    private static Integer solution(int n, int x, int[] a, int[] b) {
        LinkedList<AB> list = new LinkedList<>();
        for(int i = 0; i< a.length;i++) {
            list.add(new AB(a[i], b[i]));
        }
        AB temp = null;
        while (list.size() != 0) {
            for(int i = 0 ; i< list.size();i++) {
                temp = list.get(i);
                temp.res = x * temp.a + temp.b;
            }
            Collections.sort(list);
            x = list.removeFirst().res;
        }
        return x % 10;
    }

    private static class AB implements Comparable<AB>{
        int a;
        int b;
        int res;
        public AB(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(AB o) {
            return res-o.res==0? a-o.a: res-o.res;
        }
    }
}
