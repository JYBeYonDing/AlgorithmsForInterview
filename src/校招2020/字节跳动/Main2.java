/**
 * @(#)Main2.java, 2019/8/25.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package 校招2020.字节跳动;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import edu.princeton.cs.algs4.In;

/**
 * @author 杨杰(yangjie7 @ corp.netease.com)
 * @date 2019/8/25 20:41.
 *
 * 没做出来，没思路
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = Integer.parseInt(sc.nextLine());

        HashMap<Integer, HashSet> p = new HashMap<>();

        int[] nums = new int[n];
        for (int k = 0; k< n; k++) {
            int a = sc.nextInt();
            nums[k] = a;
            if (a > 1) {
                for (int i = 2; i <= Math.sqrt(a); i++) {
                    if (a % i == 0) {
                        if (p.get(i) == null) {
                            HashSet<Integer> sets = new HashSet<>();
                            sets.add(a);
                            p.put(i, sets);
                        } else {
                            p.get(i).add(a);
                        }
                    }
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int key : p.keySet()) {

            }
        }

    }
}
