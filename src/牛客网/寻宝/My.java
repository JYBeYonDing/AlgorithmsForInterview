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
 *
 *
 */
import java.util.Arrays;
import java.util.Scanner;

public class My {
    int[] parent;
    int[] size;//记录每一连通区的大小
    int rst;//存放最终的结果

    public My(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        for (int i=0; i<n;i++) {
            parent[i] = i;//初始化时先都指向自己
            size[i] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = 0;
        int y = 0;
        int val =0;

        My my = new My(n+1);//这里n+1是因为输入中没有0节点，所以0索引位置不用
        Edge[] edges = new Edge[m];
        for (int i=0; i<m;i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            val = sc.nextInt();

            edges[i] = new Edge(x, y, val);
        }

        // 将edges按val大小进行排序
        Arrays.sort(edges, (e1, e2) -> (e1.val - e2.val));

        for(int i = 0 ; i<m ; i++) {
            x = edges[i].x;
            y = edges[i].y;
            val = edges[i].val;
            if (my.connected(x, y)) {
                continue;
            }
            if (my.rst < val) {
                my.rst = val;
            }
            my.union(x, y);
        }
        System.out.println(my.rst);
    }

    private void union(int x, int y) {
        if (size[x] < size[y]) {
            parent[x] = y;
            size[y] += size[x];
        } else {
            parent[y] = x;
            size[x] += size[y];
        }
    }

    private boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    /**
     * 查找x属于哪一个连通区
     * @param x
     * @return
     */
    private int find(int x) {
        if (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }
}
