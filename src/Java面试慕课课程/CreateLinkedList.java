package Java面试慕课课程;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 杨杰 on 2018/6/22 14:59.
 */
public class CreateLinkedList {
    /**
     * create a linked list
     * @param data the data to create the list
     * @return head of the linked list. The returned linked list ends with last node with getNext()==null.
     */
    public Node createLinkedList(List<Integer> data) {
        if (data.isEmpty()) {
            return null;
        }
        Node firstNode = new Node(data.get(0));
        firstNode.setNext(createLinkedList(data.subList(1, data.size())));
        return firstNode;
    }

    public static void main(String[] args) {
        CreateLinkedList c = new CreateLinkedList();
        Node.printLinkedList(c.createLinkedList(new ArrayList<>()));
        Node.printLinkedList(c.createLinkedList(Arrays.asList(1)));
        Node.printLinkedList(c.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));
    }

}
