package 剑指Offer;

/**
 * Created by 杨杰 on 2018/6/2 21:14.
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class t58二叉树的下一个节点 {
    public static void main(String[] args) {

    }

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode.right != null) {
            TreeLinkNode mostLeft = pNode.right;
            while (mostLeft.left != null) {
                mostLeft = mostLeft.left;
            }
            return mostLeft;
        } else {
            while ( pNode.next!=null && pNode != pNode.next.left) {
                pNode = pNode.next;
            }
            return pNode.next;
        }
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}