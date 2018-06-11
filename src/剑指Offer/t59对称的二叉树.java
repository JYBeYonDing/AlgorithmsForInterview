package 剑指Offer;

import java.util.ArrayDeque;

/**
 * Created by 杨杰 on 2018/6/2 21:30.
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 一开始的思路：
 * 先中序遍历，放到一个双端队列中
 * 然后从前后各取一个节点，如果相等，则说明对称。
 *
 * 以上这种思路不对，因为如果所有节点的相同时，在有的是左子树，有的是右子树，这种情况应该为false，但是检测不出来。
 *
 *
 * 正确的做法是重新设计一种和前序遍历对称的遍历方式
 * 比较两个遍历的结果
 *
 *
 */
public class t59对称的二叉树 {
    public static void main(String[] args) {

    }

    boolean isSymmetrical2(TreeNode pRoot){
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical2(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical2(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }
        return left.val == right.val && isSymmetrical2(left.left, right.right) && isSymmetrical2(left.right, right.left);
    }


    //*****************************************************************************
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }
        ArrayDeque<String> queuePre = new ArrayDeque<>();
        recPre(pRoot, queuePre);
        ArrayDeque<String> queuePreFlip = new ArrayDeque<>();
        recPreFlip(pRoot, queuePreFlip);

        while (!queuePre.isEmpty()) {
            if (!queuePre.poll().equals(queuePreFlip.poll()) ) {
                return false;
            }
        }
        return true;
    }

    private void recPre(TreeNode pRoot, ArrayDeque<String> queue) {
        if (pRoot == null) {
            queue.addLast("#");
            return;
        }
        queue.addLast(pRoot.val + "");
        recPre(pRoot.left, queue);
        recPre(pRoot.right,queue);
    }
    private void recPreFlip(TreeNode pRoot, ArrayDeque<String> queue) {
        if (pRoot == null) {
            queue.addLast("#");
            return;
        }
        queue.addLast(pRoot.val + "");
        recPreFlip(pRoot.right,queue);
        recPreFlip(pRoot.left, queue);
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}