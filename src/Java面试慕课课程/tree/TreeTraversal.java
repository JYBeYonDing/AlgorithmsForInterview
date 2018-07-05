package Java面试慕课课程.tree;

/**
 * Created by 杨杰 on 2018/6/23 12:33.
 */
public class TreeTraversal {

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getValue());
        inOrder(root.getRight());
    }
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue());
    }

    public String postOrder(String preOrder, String inOrder) {
        if (preOrder.isEmpty()) {
            return "";
        }
        char rootValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootValue);
        return postOrder(preOrder.substring(1,1+rootIndex), inOrder.substring(0,rootIndex))+
                postOrder(preOrder.substring(1+rootIndex), inOrder.substring(1+rootIndex))+
                rootValue;

    }

    public static void main(String[] args) {
        TreeCreator creator = new TreeCreator();
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode sampleTree = creator.createSampleTree();
        treeTraversal.postOrder(sampleTree);
        System.out.println();

        treeTraversal.postOrder(creator.createTree("ABDEGCF", "DBGEACF"));
        System.out.println();
        System.out.println(treeTraversal.postOrder("ABDEGCF", "DBGEACF"));

    }

}
