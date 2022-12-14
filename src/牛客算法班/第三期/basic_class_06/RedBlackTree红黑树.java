package 牛客算法班.第三期.basic_class_06;

/**
 * 1）头节点叶节点必为黑
 * 2）红色节点不能相邻
 * 3）每条链黑色节点数一样
 *
 * 目的就是为了做到任何链的长度不能超过两倍
 * 所有的平衡树只是在常数级别的调整，时间复杂度都是一样的。
 * 红黑树慢慢不受欢迎了，开始使用sb树
 *
 * 恢复红黑树的属性需要少量(O(log n))的颜色变更(实际是非常快速的)和不超过三次树旋转(对于插入操作是两次)。
 *
 * 红黑是用非严格的平衡来换取增删节点时候旋转次数的降低，任何不平衡都会在三次旋转之内解决，而AVL是严格平衡树，
 * 因此在增加或者删除节点的时候，根据不同情况，旋转的次数比红黑树要多。所以红黑树的插入效率更高！！！
 * 平衡因子 = 右子树的高度 - 左子树的高度
 *
 * Not implemented by zuochengyun
 * 
 * Red-Black tree implementation. From Introduction to Algorithms 3rd edition.
 * 
 * @author Ignas Lelys
 * @created May 6, 2011
 * 
 */
public class RedBlackTree红黑树 extends AbstractSelfBalancingBinarySearchTree {

    protected enum ColorEnum {
        RED,
        BLACK
    };

    protected static final RedBlackNode nilNode = new RedBlackNode(null, null, null, null, ColorEnum.BLACK);

    /**
     * @see trees.AbstractBinarySearchTree#insert(int)
     */
    @Override
    public Node insert(int element) {
        Node newNode = super.insert(element);
        newNode.left = nilNode;
        newNode.right = nilNode;
        root.parent = nilNode;
        insertRBFixup((RedBlackNode) newNode);
        return newNode;
    }
    
    /**
     * Slightly modified delete routine for red-black tree.
     * 
     * {@inheritDoc}
     */
    @Override
    protected Node delete(Node deleteNode) {
        Node replaceNode = null; // track node that replaces removedOrMovedNode
        if (deleteNode != null && deleteNode != nilNode) {
            Node removedOrMovedNode = deleteNode; // same as deleteNode if it has only one child, and otherwise it replaces deleteNode
            ColorEnum removedOrMovedNodeColor = ((RedBlackNode)removedOrMovedNode).color;
        
            if (deleteNode.left == nilNode) {
                replaceNode = deleteNode.right;
                rbTreeTransplant(deleteNode, deleteNode.right);
            } else if (deleteNode.right == nilNode) {
                replaceNode = deleteNode.left;
                rbTreeTransplant(deleteNode, deleteNode.left);
            } else {
                removedOrMovedNode = getMinimum(deleteNode.right);
                removedOrMovedNodeColor = ((RedBlackNode)removedOrMovedNode).color;
                replaceNode = removedOrMovedNode.right;
                if (removedOrMovedNode.parent == deleteNode) {
                    replaceNode.parent = removedOrMovedNode;
                } else {
                    rbTreeTransplant(removedOrMovedNode, removedOrMovedNode.right);
                    removedOrMovedNode.right = deleteNode.right;
                    removedOrMovedNode.right.parent = removedOrMovedNode;
                }
                rbTreeTransplant(deleteNode, removedOrMovedNode);
                removedOrMovedNode.left = deleteNode.left;
                removedOrMovedNode.left.parent = removedOrMovedNode;
                ((RedBlackNode)removedOrMovedNode).color = ((RedBlackNode)deleteNode).color;
            }
            
            size--;
            if (removedOrMovedNodeColor == ColorEnum.BLACK) {
                deleteRBFixup((RedBlackNode)replaceNode);
            }
        }
        
        return replaceNode;
    }
    
    /**
     * @see trees.AbstractBinarySearchTree#createNode(int, trees.AbstractBinarySearchTree.Node, trees.AbstractBinarySearchTree.Node, trees.AbstractBinarySearchTree.Node)
     */
    @Override
    protected Node createNode(int value, Node parent, Node left, Node right) {
        return new RedBlackNode(value, parent, left, right, ColorEnum.RED);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getMinimum(Node node) {
        while (node.left != nilNode) {
            node = node.left;
        }
        return node;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getMaximum(Node node) {
        while (node.right != nilNode) {
            node = node.right;
        }
        return node;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected Node rotateLeft(Node node) {
        Node temp = node.right;
        temp.parent = node.parent;
        
        node.right = temp.left;
        if (node.right != nilNode) {
            node.right.parent = node;
        }

        temp.left = node;
        node.parent = temp;

        // temp took over node's place so now its parent should point to temp
        if (temp.parent != nilNode) {
            if (node == temp.parent.left) {
                temp.parent.left = temp;
            } else {
                temp.parent.right = temp;
            }
        } else {
            root = temp;
        }
        
        return temp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node rotateRight(Node node) {
        Node temp = node.left;
        temp.parent = node.parent;

        node.left = temp.right;
        if (node.left != nilNode) {
            node.left.parent = node;
        }

        temp.right = node;
        node.parent = temp;

        // temp took over node's place so now its parent should point to temp
        if (temp.parent != nilNode) {
            if (node == temp.parent.left) {
                temp.parent.left = temp;
            } else {
                temp.parent.right = temp;
            }
        } else {
            root = temp;
        }
        
        return temp;
    }

    
    /**
     * Similar to original transplant() method in BST but uses nilNode instead of null.
     */
    private Node rbTreeTransplant(Node nodeToReplace, Node newNode) {
        if (nodeToReplace.parent == nilNode) {
            this.root = newNode;
        } else if (nodeToReplace == nodeToReplace.parent.left) {
            nodeToReplace.parent.left = newNode;
        } else {
            nodeToReplace.parent.right = newNode;
        }
        newNode.parent = nodeToReplace.parent;
        return newNode;
    }
    
    /**
     * Restores Red-Black tree properties after delete if needed.
     */
    private void deleteRBFixup(RedBlackNode x) {
        while (x != root && isBlack(x)) {
            
            if (x == x.parent.left) {
                RedBlackNode w = (RedBlackNode)x.parent.right;
                if (isRed(w)) { // case 1 - sibling is red
                    w.color = ColorEnum.BLACK;
                    ((RedBlackNode)x.parent).color = ColorEnum.RED;
                    rotateLeft(x.parent);
                    w = (RedBlackNode)x.parent.right; // converted to case 2, 3 or 4
                }
                // case 2 sibling is black and both of its children are black
                if (isBlack(w.left) && isBlack(w.right)) {
                    w.color = ColorEnum.RED;
                    x = (RedBlackNode)x.parent;
                } else if (w != nilNode) {
                    if (isBlack(w.right)) { // case 3 sibling is black and its left child is red and right child is black
                        ((RedBlackNode)w.left).color = ColorEnum.BLACK;
                        w.color = ColorEnum.RED;
                        rotateRight(w);
                        w = (RedBlackNode)x.parent.right;
                    }
                    w.color = ((RedBlackNode)x.parent).color; // case 4 sibling is black and right child is red
                    ((RedBlackNode)x.parent).color = ColorEnum.BLACK;
                    ((RedBlackNode)w.right).color = ColorEnum.BLACK;
                    rotateLeft(x.parent);
                    x = (RedBlackNode)root;
                } else {
                    x.color = ColorEnum.BLACK;
                    x = (RedBlackNode)x.parent;
                }
            } else {
                RedBlackNode w = (RedBlackNode)x.parent.left;
                if (isRed(w)) { // case 1 - sibling is red
                    w.color = ColorEnum.BLACK;
                    ((RedBlackNode)x.parent).color = ColorEnum.RED;
                    rotateRight(x.parent);
                    w = (RedBlackNode)x.parent.left; // converted to case 2, 3 or 4
                }
                // case 2 sibling is black and both of its children are black
                if (isBlack(w.left) && isBlack(w.right)) {
                    w.color = ColorEnum.RED;
                    x = (RedBlackNode)x.parent;
                } else if (w != nilNode) {
                    if (isBlack(w.left)) { // case 3 sibling is black and its right child is red and left child is black
                        ((RedBlackNode)w.right).color = ColorEnum.BLACK;
                        w.color = ColorEnum.RED;
                        rotateLeft(w);
                        w = (RedBlackNode)x.parent.left;
                    }
                    w.color = ((RedBlackNode)x.parent).color; // case 4 sibling is black and left child is red
                    ((RedBlackNode)x.parent).color = ColorEnum.BLACK;
                    ((RedBlackNode)w.left).color = ColorEnum.BLACK;
                    rotateRight(x.parent);
                    x = (RedBlackNode)root;
                } else {
                    x.color = ColorEnum.BLACK;
                    x = (RedBlackNode)x.parent;
                }
            }
            
        }
    }
    
    private boolean isBlack(Node node) {
        return node != null ? ((RedBlackNode)node).color == ColorEnum.BLACK : false;
    }
    
    private boolean isRed(Node node) {
        return node != null ? ((RedBlackNode)node).color == ColorEnum.RED : false;
    }

    /**
     * Restores Red-Black tree properties after insert if needed. Insert can
     * break only 2 properties: root is red or if node is red then children must
     * be black.
     */
    private void insertRBFixup(RedBlackNode currentNode) {
        // current node is always RED, so if its parent is red it breaks
        // Red-Black property, otherwise no fixup needed and loop can terminate
        while (currentNode.parent != root && ((RedBlackNode) currentNode.parent).color == ColorEnum.RED) {
            RedBlackNode parent = (RedBlackNode) currentNode.parent;
            RedBlackNode grandParent = (RedBlackNode) parent.parent;
            if (parent == grandParent.left) {
                RedBlackNode uncle = (RedBlackNode) grandParent.right;
                // case1 - uncle and parent are both red
                // re color both of them to black
                if (((RedBlackNode) uncle).color == ColorEnum.RED) {
                    parent.color = ColorEnum.BLACK;
                    uncle.color = ColorEnum.BLACK;
                    grandParent.color = ColorEnum.RED;
                    // grandparent was recolored to red, so in next iteration we
                    // check if it does not break Red-Black property
                    currentNode = grandParent;
                } 
                // case 2/3 uncle is black - then we perform rotations
                else {
                    if (currentNode == parent.right) { // case 2, first rotate left
                        currentNode = parent;
                        rotateLeft(currentNode);
                    }
                    // do not use parent
                    parent.color = ColorEnum.BLACK; // case 3
                    grandParent.color = ColorEnum.RED;
                    rotateRight(grandParent);
                }
            } else if (parent == grandParent.right) {
                RedBlackNode uncle = (RedBlackNode) grandParent.left;
                // case1 - uncle and parent are both red
                // re color both of them to black
                if (((RedBlackNode) uncle).color == ColorEnum.RED) {
                    parent.color = ColorEnum.BLACK;
                    uncle.color = ColorEnum.BLACK;
                    grandParent.color = ColorEnum.RED;
                    // grandparent was recolored to red, so in next iteration we
                    // check if it does not break Red-Black property
                    currentNode = grandParent;
                }
                // case 2/3 uncle is black - then we perform rotations
                else {
                    if (currentNode == parent.left) { // case 2, first rotate right
                        currentNode = parent;
                        rotateRight(currentNode);
                    }
                    // do not use parent
                    parent.color = ColorEnum.BLACK; // case 3
                    grandParent.color = ColorEnum.RED;
                    rotateLeft(grandParent);
                }
            }

        }
        // ensure root is black in case it was colored red in fixup
        ((RedBlackNode) root).color = ColorEnum.BLACK;
    }

    protected static class RedBlackNode extends Node {
        public ColorEnum color;

        public RedBlackNode(Integer value, Node parent, Node left, Node right, ColorEnum color) {
            super(value, parent, left, right);
            this.color = color;
        }
    }

}
