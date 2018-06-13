package 剑指Offer;

import java.util.HashMap;

/**
 * Created by 杨杰 on 2018/6/13 15:14.
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如，
 *    5
 *   / \
 *   3 7
 *  /\ /\
 * 2 4 6 8
 * 中，按结点数值大小顺序第三个结点的值为4。
 *
 * 其实这里不同全部遍历，中序遍历到第几个就可以了。
 */
public class t63二叉搜索树的第k个结点 {
    static int num=0;
    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        HashMap<Integer, TreeNode> hashMap = new HashMap<>();
        recIn(pRoot, hashMap);
        return hashMap.get(k);
    }

    private static void recIn(TreeNode pRoot, HashMap<Integer, TreeNode> hashMap) {
        if (pRoot == null) {
            return;
        }
        recIn(pRoot.left, hashMap);
        hashMap.put(++num, pRoot);
        recIn(pRoot.right, hashMap);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        System.out.println(KthNode(root, 3).val);
    }
}
