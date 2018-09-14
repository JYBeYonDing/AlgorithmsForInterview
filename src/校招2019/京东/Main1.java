package 校招2019.京东;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/9 20:28.
 *
 * 没有通过，通过0
 *
 2
 5 7
 1 3
 1 5
 2 3
 2 5
 3 4
 4 5
 3 5
 4 3
 1 2
 2 3
 3 4
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int T = sc.nextInt();
        HashMap<Integer, HashSet<Integer>> leftSet = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> rightSet = new HashMap<>();

        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            leftSet.clear();
            rightSet.clear();


            String resOne = "Yes";
            boolean flag = true;
            for (int k = 0; k < M; k++) {
                resOne = "Yes";
                int a = sc.nextInt();
                int b = sc.nextInt();


                    boolean leftContainA = leftSet.containsKey(a);
                    boolean leftContainB = leftSet.containsKey(b);
                    boolean rightContainA = rightSet.containsKey(a);
                    boolean rightContainB = rightSet.containsKey(b);

                    if (leftContainA && leftContainB || rightContainA && rightContainB) {
                        resOne = "No";
                        flag = false;

                    } else if (!leftContainA && !leftContainB && !rightContainA && !rightContainB) {
                        leftSet.put(a, new HashSet<>());
                        leftSet.get(a).add(b);
                        rightSet.put(b, new HashSet<>());
                        rightSet.get(b).add(a);
                    } else if (leftContainA && rightContainB && !rightContainA && !leftContainB
                            || leftContainB && rightContainA && !leftContainA && !rightContainB) {
                        continue;
                    } else if (leftContainA && !rightContainA && !leftContainB && !rightContainB) {
                        leftSet.get(a).add(b);
                        rightSet.put(b, new HashSet<>());
                        rightSet.get(b).add(a);
                    } else if (leftContainB && !leftContainA && !rightContainA && !rightContainB) {
                        leftSet.get(b).add(a);
                        rightSet.put(a, new HashSet<>());
                        rightSet.get(a).add(b);
                    } else if (rightContainA && !leftContainA && !rightContainB && !leftContainB) {
                        rightSet.get(a).add(b);
                        leftSet.put(b, new HashSet<>());
                        leftSet.get(b).add(a);
                    } else if (rightContainB && !rightContainA && !leftContainA && !leftContainB) {
                        rightSet.get(b).add(a);
                        leftSet.put(a, new HashSet<>());
                        leftSet.get(a).add(b);
                    }
                }




            for (Integer ll : leftSet.keySet()) {
                if (!leftSet.get(ll).containsAll(rightSet.keySet())) {
                    resOne = "No";
                }
            }

            for (Integer rr : rightSet.keySet()) {
                if (!rightSet.get(rr).containsAll(leftSet.keySet())) {
                    resOne = "No";
                }
            }
            res.add(resOne);


        }


        for (String s : res) {
            System.out.println(s);
        }
    }
}