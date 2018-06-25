package Java面试慕课课程.tree;

/**
 * Created by 杨杰 on 2018/6/23 16:43.
 */
public class InOrder {
    public TreeNode next(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() != null) {
            return first(node.getRight());
        } else {
            while (node.getParent()!=null && node.getParent().getRight()== node) {
                node = node.getParent();
            }
            return node.getParent();
        }
    }

    public TreeNode first(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public void traverse(TreeNode root) {
        for (TreeNode node = first(root); node != null; node = next(node)) {
            System.out.print(node.getValue());
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TreeCreator creator = new TreeCreator();
        InOrder inOrder = new InOrder();
        TreeNode sampleTree = creator.createSampleTree();

        inOrder.traverse(sampleTree);

        inOrder.traverse(creator.createTree("", ""));
        inOrder.traverse(creator.createTree("A", "A"));
        inOrder.traverse(creator.createTree("AB", "BA"));

    }
}
