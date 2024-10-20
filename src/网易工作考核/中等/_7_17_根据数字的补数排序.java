package 网易工作考核.中等;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 *
 * 例如，整数 5 的二进制表示是 "101" （没有前导零位），取反后得到 "010" ，再转回十进制表示得到补数 2 。
 *
 * 给你一个整数数组 arr 。请你将数组中的元素按照其补数升序排序。如果补数相同，则按照原数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 * 提示：
 *
 * 1 <= arr.length <= 500
 *
 * 0 <= arr[i] <= 10^4
 *
 * 输入格式:
 * 整数数组arr，以",”分隔字符串的形式作为输入
 *
 * 输出格式:
 * 排好序的整数数组，以",”分隔字符串的形式作为输出
 *
 * 输入样例:
 * 原始数组arr：
 *
 * 5,10,4,2
 * 输出样例:
 * 排序后的arr：
 *
 * 2,5,4,10
 */
public class _7_17_根据数字的补数排序 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        Node[] nodes = new Node[split.length];
        for (int i = 0; i < split.length; i++) {
            int v = Integer.parseInt(split[i]);
            Node node = new Node();
            node.value = v;
            node.buValue = calculate(v);
            nodes[i] = node;
        }
//        System.out.println(JSON.toJSONString(nodes));

        Arrays.sort(nodes, new Comparator<>() {

            @Override
            public int compare(Node o1, Node o2) {
                int dif = o1.getBuValue() - o2.getBuValue();
                return dif==0? o1.getValue()-o2.getValue() :dif;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.length; i++) {
            sb.append(nodes[i].getValue()).append(",");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static int calculate(int v) {
        int highBit = 0;
        for (int i = 0; i < 30; i++) {
            if (v >= (1 << i)) {
                highBit = i;
            }else{
                break;
            }
        }
        int mask = highBit == 30 ? Integer.MAX_VALUE : (1 << (highBit + 1)) - 1;
        return v ^ mask;
    }

    private static class Node{
        int value;

        int buValue;

        public int getValue() {
            return value;
        }

        public int getBuValue() {
            return buValue;
        }
    }

}
