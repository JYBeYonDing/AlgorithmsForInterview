package 校招2019.中兴;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by James on 2018/8/28 10:42.
 *
 * 没做出来
 */
public class 工程师 {
    public static void main(String[] args) {
        String  network = "111110000010000";// 输出324334
        String[] strings = network.split("");

        int[] pathLeft = new int[strings.length];
        int[] pathRight = new int[strings.length];
        for (int i = strings.length - 1; i >= 0; i--) {
            if(strings[i].equals("1")){
                if (2 * i + 1 >= strings.length) {
                    pathLeft[i] = 1;
                    pathRight[i] = 1;
                } else {
                    pathLeft[i] = 1 + Math.max(pathLeft[2 * i + 1],pathRight[2 * i + 1]);
                    pathRight[i] = 1 + Math.max(pathLeft[2 * i + 2],pathRight[2 * i + 2]);
                }

            }
        }

        for (int i = 0; i < strings.length; i++) {
            pathLeft[i]--;
            pathRight[i]--;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("1")) {
                int temp = 0;
                int tempIndex = i;
                int preTemp = 0;
                int tempMax = Math.max(pathLeft[i], pathRight[i]);
                while (tempIndex != 0) {
                    temp++;
                    if (tempIndex % 2 == 0) {
                        // 右边分支，求左边
                        tempMax = Math.max(tempMax, temp + pathLeft[(tempIndex-1)/2]);

                    } else {
                        // 左边分支，求右边
                        tempMax = Math.max(tempMax, temp + pathRight[(tempIndex-2)/2]);
                    }

                    tempIndex = (tempIndex - 1 )/2;
                }

                res.add(tempMax);
            }
        }

        for (int i : res) {
            System.out.println(i);
        }
    }







    //*****************************************************************************************************


    private static List<Integer> minStrength(String network) {
        List<Integer> res = new ArrayList<>();
        Node root = reconByLevelString(network);//根据按层遍历字符串重建二叉树
        findmaxdistance(root);

        for (int i = 0; i < network.length(); i++) {

            //第i位到根的距离

            //第i位到末尾的距离

            //
        }
        return null;
    }


    //根据按层遍历字符串重建二叉树
    private static Node reconByLevelString(String levelStr) {
        int index = 0;
        Node head = generateNodeByString(levelStr.charAt(index++));
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(levelStr.charAt(index++));
            node.right = generateNodeByString(levelStr.charAt(index++));
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }
    public static Node generateNodeByString(char val) {
        if (val=='0') {
            return null;
        }
        return new Node(val);
    }

    static class Node{
        public int data;
        public Node left;
        public Node right;
        public int leftmaxdistance;
        public int rightmaxdistance;
        public Node(int data) {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    private static int maxlen=0;
    private static int max(int a,int b) {
        return a>=b?a:b;
    }
    public static void findmaxdistance(Node root) {
        if(root==null) {
            return ;
        }
        if(root.left==null) {
            root.leftmaxdistance=0;
        }else {
            findmaxdistance(root.left);
        }
        if(root.right==null) {
            root.rightmaxdistance=0;
        }else {
            findmaxdistance(root.right);
        }
        if(root.left!=null) {
            root.leftmaxdistance=max(root.left.leftmaxdistance,root.rightmaxdistance)+1;
        }
        if(root.right!=null) {
            root.rightmaxdistance=max(root.right.leftmaxdistance,root.right.rightmaxdistance)+1;
        }
        if(root.leftmaxdistance+root.rightmaxdistance>maxlen) {
            maxlen=root.leftmaxdistance+root.rightmaxdistance;
        }

    }
}
