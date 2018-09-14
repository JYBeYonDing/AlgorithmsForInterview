package 校招2019.网易校招;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/8 16:11.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<Integer, ArrayList<Integer>> peoples = new HashMap<>();

        int[] has = new int[m+1];


        for (int i = 0; i < n; i++) {
            int people = sc.nextInt();

            has[people]++;

            int cost = sc.nextInt();
            if (peoples.containsKey(people)) {
                peoples.get(people).add(cost);
            } else {
                peoples.put(people, new ArrayList<>());
                peoples.get(people).add(cost);
            }

        }


        ArrayList<Integer> more = new ArrayList<>();
        for (int i=2; i <= m; i++) {
            if (has[i] > has[1]) {
                more.add(i);
            }
        }

        Collections.sort(more);

        int res = 0;

        while(haveMore(peoples,m)){



        }


    }

    private static boolean haveMore(HashMap<Integer, ArrayList<Integer>> peoples, int m) {
        int numOf1 = peoples.get(1).size();

        for (int i = 2; i <= m; i++) {
            if (peoples.get(i).size() >= numOf1) {
                return true;
            }
        }
        return false;
    }

}