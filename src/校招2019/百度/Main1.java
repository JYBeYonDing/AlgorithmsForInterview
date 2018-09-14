package 校招2019.百度;

import java.net.InetSocketAddress;
import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/11 20:05.
 */
public class Main1 {
    public static void main(String[] args) {

        int numCustomer=4;
        int numProduct=4;

    }


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> findCommonElements(int numCustomer, int numProduct,
                                     List<List<Integer> > productList)
    {
        // WRITE YOUR CODE HERE

        HashMap<Integer, Integer> procudt = new HashMap<>();


        HashSet<Integer> hashSet = new HashSet<>();
        for (List<Integer> list : productList) {
            hashSet.clear();
            for (int p : list) {
                if (!hashSet.contains(p)) {
                    procudt.put(p, procudt.getOrDefault(p, 0) + 1);
                }
                hashSet.add(p);
            }
        }

        int max = Integer.MIN_VALUE;

        for (Integer k : procudt.keySet()) {
            max = Math.max(max, procudt.get(k));
        }


        ArrayList<Integer> res = new ArrayList<>();
        for (Integer k : procudt.keySet()) {
            if (procudt.get(k) == max) {
                res.add(k);
            }
        }

        Collections.sort(res);
        return res;
    }
    // METHOD SIGNATURE ENDS
}