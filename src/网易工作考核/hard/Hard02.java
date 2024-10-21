package org.example.hard;

import java.util.*;

/**
 * 按公因数计算最大组件大小
分数 60
作者 
单位 
给定一个由不同正整数组成的非空数组 nums，考虑下面的构图：

有 nums.length 个节点，按照从 nums[0]到 nums[nums.length-1]标记；

只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j] 之间才有一条边。

返回构图中最大连通组件的大小。

输入格式:
输入为数组元素，空格分隔

输出格式:
输出最大连通组件的大小

输入样例1:
在这里给出一组输入。例如：

4 6 15 35
对应的构图为
ex1.png

可以看到，最大连通组件的大小为 4。

输出样例1:
在这里给出相应的输出。例如：

4



输入样例2:
在这里给出一组输入。例如：

20 50 9 63
对应的构图为


ex2.png

可以看到，最大连通组件的大小为 2。

输出样例2:
在这里给出相应的输出。例如：

2

输入样例3:
在这里给出一组输入。例如：

2 3 6 7 4 12 21 39
对应的构图为


ex3.png

可以看到，最大连通组件的大小为 8。

输出样例3:
在这里给出相应的输出。例如：

8


注意：
1 <= nums.length <= 2*10^4

1 <= nums[i] <= 10^5

nums 中所有值都不同
 */
public class Hard02 {

    public static void main(String[] args) {
        // read
        Scanner in = new Scanner(System.in);
        String vals = in.nextLine();
        in.close();

        String[] nums = vals.split(" ");

        int len = nums.length;
        int[] arr = new int[len];
        
        //并查集数组，初始等于元素下标
        int[] parent = new int[len];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            arr[i] = Integer.valueOf(nums[i]);
        }

        //并查集合并后，元素数量数组，初始都是1
        int[] composedCount = new int[len];
        for (int i = 0; i < composedCount.length; i++) {
            composedCount[i] = 1;
        }

        //key: 公因子； val：有此公因子的数的下标
        Map<Integer, List<Integer>> factorNumMap = new HashMap<>();

        //求公因子
        for (int i = 0; i < composedCount.length; i++) {
            int n = arr[i];
            //短除法
            for (int j = 2; j * j <= n; j++) {
                if (n % j == 0) {
                    recordInFactorMap(factorNumMap, j, i);
                    while (n % j == 0) {
                        n = n / j;
                    }
                }
            }
            //剩一个素数，也放到map
            if (n > 1) {
                recordInFactorMap(factorNumMap, n, i);
            }
        }

        //按相同因子集合进行合并
        factorNumMap.forEach((factor, list) -> {
            for (int i = 1; i < list.size(); i++) {
                merge(parent, composedCount, list.get(0), list.get(i));
            }
        });

        //找到最大的集合
        int maxSizeGraph = 0;
        for (int i = 0; i < composedCount.length; i++) {
            if (composedCount[i] > maxSizeGraph) {
                maxSizeGraph = composedCount[i];
            }
        }

        System.out.println(maxSizeGraph);
    }

    //以素数为key存放相同公因子的下标
    private static void recordInFactorMap(Map<Integer, List<Integer>> map, int key, int val) {
        map.computeIfAbsent(key, list -> new ArrayList<>()).add(val);
    }

    private static void merge(int[] parent, int[] composedCount, int k1, int k2) {
        //找各自的根节点
        int rootK1Idx = find(parent, k1);
        int rootK2Idx = find(parent, k2);

        //在一个集合中, 根节点下标相同
        if (rootK1Idx == rootK2Idx) {
            return;
        }

        //不在一个集合中，合并
        //集合数量合并，因为根节点合并了，所以数量都会回溯到根节点的数量进行相加，k2对应的数量也可以更新
        composedCount[rootK1Idx] += composedCount[rootK2Idx];
        //根节点合并, 因为数据加在k1, 所以是把k2指向k1
        parent[rootK2Idx] = parent[rootK1Idx];
    }

    private static int find(int[] parent, int k) {
        //把第k个元素指向根节点， 合并过程中可能导致集合其他元素的根节点不正确
        if (parent[k] != k) {
            parent[k] = find(parent, parent[k]);
        }
        return parent[k];
    }
}
