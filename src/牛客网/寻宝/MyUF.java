package 牛客网.寻宝;

/*
题目描述
牛牛解出了卷轴隐藏的秘密，来到了一片沼泽地。这里有很多空地，而面试直通卡可能埋在任意一块空地中，好在亮亮发现了一堆木材，
他可以将木材铺在两个空地之间的沼泽地上。
因为亮亮不知道面试直通卡具体在哪一块空地中，所以必须要保证任意一块空地对于亮亮来说是可以抵达的。
“怎么还有鳄鱼！没办法，看来有些空地不能直接到达了。” 亮亮虽然没有洁癖，但是沼泽地实在太臭了，所以亮亮不会循环利用木材。
而且木材不能拼接在一起使用，所以亮亮必须要知道在耗费木材最少的情况下，最长的那根木材至少需要多长。
输入描述:
第一行包含两个整数N(1≤N≤10000),M(1≤M≤1000000)。N表示公有N块空地。
接下来M行，每行包含三个整数P(1≤P≤N),Q(1≤Q≤N),K代表P,Q两个间没有鳄鱼，需要耗费K的木材。
输出描述:
一个整数，即耗费木材最少的情况下，最长的那根木材长度。
示例1
输入
4 3
1 2 1
2 3 1
3 4 2
输出
2
 */

/*
 * 思路：
 * 使用union find 算法
 * 使用的是算法4中的WeightedQuickUnionUF模板
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class MyUF {
    private int[] parent;   // parent[i] = parent of i
    private int[] size;     // size[i] = number of sites in subtree rooted at i
//    private int count;      // number of components

    public MyUF(int n) {
//        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
//        validate(p);
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    // validate that p is a valid index
//    private void validate(int p) {
//        int n = parent.length;
//        if (p < 0 || p > n) {
//            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n-1));
//        }
//    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
//        count--;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        MyUF myUF = new MyUF(n+1);
        int rst = 0;
        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int val = sc.nextInt();

            edges[i] = new Edge(x, y, val);
        }
        //需要对edges进行排序，val从小开始
        Arrays.sort(edges, (Edge e1, Edge e2) -> (e1.val - e2.val));

        for(int i = 0; i<m ; i++) {
            int x = edges[i].x;
            int y = edges[i].y;
            int val = edges[i].val;

            if (myUF.connected(x, y)) {
                continue;
            }
            myUF.union(x,y);
            if (rst < val) {
                rst = val;
            }
        }

        System.out.println(rst);
    }

}

class Edge {
    int x;
    int y;
    int val;

    public Edge(int x, int y, int val) {
        this.x = x;
        this.y = y ;
        this.val = val;
    }
}