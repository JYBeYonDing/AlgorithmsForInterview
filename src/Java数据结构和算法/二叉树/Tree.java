package Java数据结构和算法.二叉树;

/**
 *
 * 递归实现版本看algs4下的BST
 */
public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    /**
     * 查找节点
     * @param key
     * @return
     */
    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) { //到达末端而没有找到要找的节点，表明不存在
                return null;
            }
        }
        return current;
    }

    /**
     * 插入节点
     * @param id
     * @param dd
     */
    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {//不关心是否遇到id一样的节点，把有相同关键字值的节点当做关键字值比较大的节点处理
                parent = current;//用来存储遇到的最后一个不是null的节点
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 中序遍历
     *
     * 调用自身来遍历节点的左子树
     * 访问这个节点：意味着对节点做某种操作，显示节点等
     * 调用自身来遍历节点的右子树
     * @param localRoot
     */
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);

            System.out.println(localRoot.iData + " ");

            inOrder(localRoot.rightChild);
        }
    }


    /**
     * 查找最小节点
     * @return
     */
    public Node minimum() {
        Node current, last=null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }


    /**
     * 删除节点
     * 删除节点要从查找要删的节点开始入手，找到节点后，这个要删除的节点可能会有三种情况需要考虑：
     * 1.该节点是叶节点
     * 2.该节点有一个子节点
     * 3.该节点有两个子节点
     * @param key
     * @return
     */
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;//用于记录current是否是parent的左节点

        while (current.iData != key) {
            parent=current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null) {
                return false;
            }
        }

        //current就是要删除的节点
        //检查是不是真的没有子节点，如果没有子节点还要检查它是不是根
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }

        //删除有一个子节点的节点
        //有四种不同的情况：要删除的节点的子节点可能有左子节点或右子节点，
        // 并且每种情况中要删除的节点可能是自己父节点的左子节点或右子节点
        else if (current.rightChild == null) {//该节点有一个左子节点
            if (current == root) {//如果是根节点
                root = current.leftChild;
            } else if (isLeftChild) {//不是根节点，但是是父节点的左子节点
                parent.leftChild = current.leftChild;
            } else {//不是根节点，但是是父节点的右子节点
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {//该节点有一个右子节点
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        }

        //删除有两个子节点的节点
        //窍门：用它的中序后继来代替该节点。
        else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    /**
     * 得到中序后继节点
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {//????
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
}
