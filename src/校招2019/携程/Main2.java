package 校招2019.携程;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/4 19:35.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int N = sc.nextInt();

        int A = sc.nextInt();

        Order[] orders = new Order[N];

        for (int i = 0; i < N; i++) {

            int id = sc.nextInt();
            int in = sc.nextInt();
            int out = sc.nextInt();
            orders[i] = new Order(id, in, out);

        }


        Arrays.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.in - o2.in;
            }
        });

        int[] ins = new int[N];

        for (int i = 0; i < N; i++) {
            ins[i] = orders[i].in;
        }

        if (A < ins[0]) {
            System.out.println("null");
            return;
        }

        int i = floor(ins,A);


        ArrayList<Integer> ids = new ArrayList<>();
        int j = i-1;
        while (j>=0&& j<N && orders[j].in <= A && orders[j].out >= A) {
            ids.add(orders[j].id);
//            System.out.println(orders[j].id);
            j--;
        }
        while (i>=0&&i<N && orders[i].in <= A && orders[i].out >= A) {
            ids.add(orders[i].id);
//            System.out.println(orders[i].id);
            i++;
        }

        Collections.sort(ids);

        if (ids.isEmpty()) {
            System.out.println("null");

        } else {
            for (int id : ids) {
                System.out.println(id);
            }
        }
    }

    static class Order{
        int id;
        int in;
        int out;

        public Order(int id, int in, int out) {
            this.id = id;
            this.in = in;
            this.out = out;
        }
    }

    static int floor(int[] arr, int target){
        int l = -1, r = arr.length-1;
        while( l < r ){
            int mid = l + (r-l+1)/2;
            if( arr[mid]>=(target) )
                r = mid - 1;
            else
                l = mid;
        }
        if( l + 1 < arr.length && arr[l+1] == target )
            return l + 1;
        return l;
    }
}