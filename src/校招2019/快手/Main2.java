package 校招2019.快手;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/25 20:11.
 */
public class Main2 {
    static int index = 0;
    static int[] res;
    public static void main(String[] args) {
        index=0;
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String[] strs = sc.nextLine().split(" ");

        int[] preNums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            preNums[i] = Integer.parseInt(strs[i]);
        }


        strs = sc.nextLine().split(" ");

        int[] inNums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            inNums[i] = Integer.parseInt(strs[i]);
        }

        res = new int[strs.length];

        TreeNode root = reConstructBinaryTree(preNums, inNums);
        posOrderRecur(root);

        inOrderRecur(root);

        for (int i=0;i<res.length-1;i++) {

            System.out.print(res[i]+" ");
        }

        System.out.println(res[res.length-1]);
    }

    public static void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        res[index] = head.sum;
        index++;
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        if (head.left != null && head.right != null) {
            head.sum = head.left.val + head.right.val;
        }
    }


    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        int preStart = 0;
        int preEnd = pre.length - 1;
        int inStart = 0;
        int inEnd = in.length - 1;
        return reConstructBinaryTreeRec(pre, in, preStart, preEnd, inStart, inEnd);
    }

    private static TreeNode reConstructBinaryTreeRec(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootValue = pre[preStart];
        TreeNode tempRoot = new TreeNode(rootValue);
        int inIndex = find(in, inStart,rootValue);
        int leftLen = inIndex - inStart;
        int leftPreStart = preStart + 1;
        int leftPreEnd = preStart + leftLen;
        int leftInEnd = inIndex - 1;
        tempRoot.left = reConstructBinaryTreeRec(pre, in, leftPreStart, leftPreEnd, inStart, leftInEnd);
        int rightPreStart = leftPreEnd + 1;
        int rightInStart = inIndex + 1;
        tempRoot.right = reConstructBinaryTreeRec(pre, in, rightPreStart, preEnd, rightInStart, inEnd);
        return tempRoot;
    }

    private static int find(int[] in, int inStart, int rootValue) {
        for (int i = inStart; i < in.length; i++) {
            if (in[i] == rootValue) {
                return i;
            }
        }
        return -1;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        int sum = 0;

        TreeNode(int x) {
            val = x;
        }
    }






























//    作者：offer求一个
//    链接：https://www.nowcoder.com/discuss/117952
//    来源：牛客网

    public static void main2(String[]args){
        Scanner s=new Scanner(System.in);
        String data1[]=s.nextLine().split(" ");
        String data2[]=s.nextLine().split(" ");
        int pre[]=new int[data1.length];
        int in[]=new int[data2.length];
        for(int i=0;i<data1.length;i++)pre[i]=Integer.valueOf(data1[i]);
        for(int i=0;i<data2.length;i++)in[i]=Integer.valueOf(data2[i]);
        f(pre,in);
    }

    public static  void f(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return ;
        }
        int rel[]=new int[pre.length];
        dfs(pre, 0, pre.length - 1, in, 0, in.length - 1,rel);
        for(int i:rel)
            System.out.print(i+" ");
    }
    public static void dfs(int [] pre,int pstart, int pend, int [] in, int istart, int iend,int []rel) {
        if (pstart > pend || istart > iend) {
            return ;
        }
        int sum=0;
        for(int i=pstart+1;i<=pend;i++)sum+=pre[i];
        for(int i = istart; i <= iend; i++)
            if(in[i] == pre[pstart]){
                rel[i]=sum;
                dfs(pre, pstart + 1, pstart + i - istart, in, istart, i - 1,rel);
                dfs(pre, i - istart + pstart + 1, pend, in, i + 1, iend,rel);
            }
        return ;
    }
}