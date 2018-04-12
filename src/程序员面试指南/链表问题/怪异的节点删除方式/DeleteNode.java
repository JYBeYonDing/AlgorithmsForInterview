package 程序员面试指南.链表问题.怪异的节点删除方式;

/**
 * Created by 杨杰 on 2018/4/4.
 */
public class DeleteNode {
    private static class Node{
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 这种删除方式有很大问题：并没有真正地删除节点，只是复制了，没法删除最后一个节点。
     *
     * @param node
     */
    public void removeNodeWired(Node node) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            node.value = node.next.value;
            node.next = node.next.next;
        } else {
            throw new RuntimeException("无法删除最后的节点");
        }
    }
}
