package 其他算法收集;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by 杨杰 on 2018/6/20 12:04.
 */
public class 二叉树的宽度和二叉树的深度 {
    private class BinaryTreeNode{
        int m_value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 求二叉树的宽度
     * 即节点最多一层的节点个数
     * 用按层遍历的方式
     * @param root
     * @return
     */
    int treeWidth(BinaryTreeNode root){
        if (root == null)
            return 0;

        int nLastLevelWidth = 0;//记录上一层的宽度
        int nCurLevelWidth = 0;//记录当前层的宽度

        Queue<BinaryTreeNode> myQueue = new ArrayDeque<>();
        myQueue.offer(root);//将根节点入队列
        int nWidth = 1;//二叉树的宽度
        nLastLevelWidth = 1;
        BinaryTreeNode pCur = null;

        while (!myQueue.isEmpty())//队列不空
        {
            while (nLastLevelWidth!= 0){
                pCur = myQueue.remove();//取出队列头元素

                if (pCur.left != null)
                    myQueue.offer(pCur.left);

                if (pCur.right != null)
                    myQueue.offer(pCur.right);
                nLastLevelWidth--;
            }

            nCurLevelWidth = myQueue.size();// 当前层的宽度就是队列中的节点数
            nWidth = nCurLevelWidth > nWidth ? nCurLevelWidth : nWidth;// 更新
            nLastLevelWidth = nCurLevelWidth;
        }
        return nWidth;
    }


    /**
     * 求二叉树的深度
     * @param root
     * @return
     */
    int treeDepth(BinaryTreeNode root){
        if(root==null){
            return 0;
        }
        int nLeft=treeDepth(root.left);
        int nRight=treeDepth(root.right);
        return nLeft>nRight?nLeft+1:nRight+1;
    }
}
