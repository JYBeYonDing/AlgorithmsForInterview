package 校招2019.奇虎360;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by James on 2018/8/27 20:02.
 *
5 3
1 2 3 2 2
3
1 4
2 4
1 5
 */
public class 看花 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];


        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }


        int Q = sc.nextInt();
        int[][] qs = new int[Q][2];// 先用数组存放输入数据比较好！！！


        for (int i = 0; i < Q; i++) {
            qs[i][0] = sc.nextInt();
            qs[i][1] = sc.nextInt();

        }

        for (int i = 0; i < Q; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = qs[i][0]-1; j < qs[i][1]; j++) {
                hashSet.add(a[j]);
            }
            System.out.println(hashSet.size());
        }

    }

//*************************************************************************
    public static void main2(String[] args) {

        Scanner dsn = new Scanner(System.in);

        while(dsn.hasNext()){
            int count = dsn.nextInt();
            int non_use = dsn.nextInt();
            int[] data = new int[count];

            for(int i = 0; i < count; i++){
                data[i] = dsn.nextInt();
            }

            int q = dsn.nextInt();
            int[][] arr = new int[q][2];
            for(int i = 0; i < q; i++){
                arr[i][0] = dsn.nextInt();
                arr[i][1] = dsn.nextInt();
            }

            for(int i = 0; i < q; i++){
                System.out.println(result(data, arr[i][0], arr[i][1]));
            }

        }

    }

    private static int result(int[] arr, int start, int end) {
        HashSet<Integer> dkejt = new HashSet<>();

        start--;
        end--;
        for(int i = start; i <= end; i++){
            dkejt.add(arr[i]);
        }

        return dkejt.size();

    }


//***********************************************************************************
    public static void main3(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int n = Integer.parseInt(strings[0]);//看了n次花
        int m = Integer.parseInt(strings[1]);//共m朵花

        strings = sc.nextLine().split(" ");
        int[] a = new int[strings.length];// 小明看花的种类
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < strings.length; i++) {
            a[i] = Integer.parseInt(strings[i]);
        }


        int Q = Integer.parseInt(sc.nextLine());
//        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < Q; i++) {
            strings = sc.nextLine().split(" ");
            int l = Integer.parseInt(strings[0]);
            int r = Integer.parseInt(strings[1]);

            for (int j = l-1; j < r; j++) {
                hashSet.add(a[j]);
            }
            System.out.println(hashSet.size());

            hashSet.clear();
        }

//        for (int i : res) {
//            System.out.println(i);
//        }

    }

}
