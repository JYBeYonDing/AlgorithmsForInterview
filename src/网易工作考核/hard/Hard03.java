package org.example.hard;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 拼接最大数
分数 60
作者 
单位 
给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。

现在从这两个数组中选出 k (0 <=k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

输入格式:
输入三个行内容：

第一行是数组nums1，元素内容用逗号分隔；数组最大长度为1000。

第二行是数组nums2，元素内容用逗号分隔；数组最大长度为1000。

第三行是长度k；

输出格式:
返回一个表示该最大数的长度为 k 的数组，数组元素用逗号隔开。

输入样例:
在这里给出一组输入。例如：

3,4,6,5
9,1,2,5,8,3
5
输出样例:
在这里给出相应的输出。例如：

9,8,6,5,3
提示：
1 <= nums1.length, nums2.length <= 1000

0 <= nums1[i], nums2[i] <= 9
 */
public class Hard03 {

    //部分通过
    public static void main(String[] args) {

        // read
        Scanner in = new Scanner(System.in);
        String nums1 = in.nextLine();
        String nums2 = in.nextLine();
        int k = in.nextInt();
        in.close();

        String[] arrs1 = nums1.split(",");
        int[] arr1 = new int[arrs1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.valueOf(arrs1[i]);
        }
        
        String[] arrs2 = nums2.split(",");
        int[] arr2 = new int[arrs2.length];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.valueOf(arrs2[i]);
        }

        if (k == 0) {
            System.out.println();
            return;
        }

        if (arr1.length + arr2.length == k) {
            int[] merge = merge(arr1, arr2);
            String res = Arrays.stream(merge).boxed().map(String::valueOf).reduce((a,b)->a+"," + b).get();
            System.out.println(res);
            return;
        }

        //分别找各自的最大子序列，再合并
        int[] max = null;
        for (int k1 = 0; k1 <= Math.min(arr1.length, k); k1++) {
            int k2 = k - k1;
            if (k2 < 0 || k2 > arr2.length) {
                continue;
            }
            int[] m1 = maxSubArr(arr1, k1);
            int[] m2 = maxSubArr(arr2, k2);

            int[] merge = merge(m1, m2);

            max = max(max, merge);
        }

        String res = Arrays.stream(max).boxed().map(String::valueOf).reduce((a,b)->a+"," + b).get();
        System.out.println(res);
    }

    private static int[] maxSubArr(int[] arr, int k) {
        if (k == 0) {
            return null;
        }

        if (arr.length == k) {
            return arr;
        }

        int delCount = arr.length - k;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
             while(delCount > 0 && !stack.empty() && compare(stack.peek(), n) < 0) {
                stack.pop();
                delCount--;
            }
            stack.push(n);
        }

        int[] res = new int[k];
        while (stack.size() > k) {
            stack.pop();
        }

        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }

    private static int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }

    private static int[] merge(int[] m1, int[] m2) {
        if (m1 == null) {
            return m2;
        }
        if (m2 == null) {
            return m1;
        }

        int[] res = new int[m1.length + m2.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m1.length && j < m2.length) {
            int c = compare(m1[i], m2[j]);
            if (c == 0) {
                if (i + 1 == m1.length && j + 1 == m2.length) {
                    res[index++] = m1[i];
                    i++;
                    break;
                }
                int next = 0;
                if (i+1 < m1.length && j+1 < m2.length) {
                    next = compare(m1[i+1], m2[j+1]);
                } else if (i+1 < m1.length) {
                    next = compare(m1[i+1], m2[j]);
                } else {
                    next = compare(m1[i], m2[j+1]);
                }
                if (next == 0) {
                    res[index++] = m1[i];
                    i++;
                } else if (next > 0) {
                    res[index++] = m1[i];
                    i++;
                } else {
                    res[index++] = m2[j];
                    j++;
                }
            } else if (c > 0) {
                res[index++] = m1[i];
                i++;
            } else {
                res[index++] = m2[j];
                j++;
            }
        }

        while (i < m1.length) {
            res[index++] = m1[i];
            i++;
        }
        while (j < m2.length) {
            res[index++] = m2[j];
            j++;
        }

        return res;
    }

    private static int[] max(int[] m1, int[] m2) {
        if (m1 == null) {
            return m2;
        }
        if (m2 == null) {
            return m1;
        }
        return Arrays.toString(m1).compareTo(Arrays.toString(m2)) > 0 ? m1 : m2;
    }
}
