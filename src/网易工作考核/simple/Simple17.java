package org.example.simple;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 交换和
 * 分数 30
 * 作者 
 * 单位 
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 * <p>
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。
 * 若有多个答案，返回所有满足条件的答案。若无满足条件的数值，不输出。
 * <p>
 * <p>
 * 输入格式:
 * 第一行输入第一个整数数组元素，以空格分开（结尾无空格）；
 * <p>
 * 第二行输入第二个整数数组元素，以空格分开（结尾无空格）。
 * <p>
 * 输入两个数组长度大于1，且小于10000
 * <p>
 * <p>
 * 输出格式:
 * 输出数组，长度为2，输出的数组第一个元素表示第一个数组中需要交换的元素值，第二个元素表示第二个数组中需要交换的元素值。且元素之间以空格分开（结尾无空格）。
 * 若有多个答案，请返回所有答案，多组答案输出顺序按每组答案的第一个元素进行升序输出（若第一个元素相同，则继续按照每组第二个元素升序输出），每组答案单独一行显示，如果结果中有重复答案，请仅显示一组。
 * <p>
 * 若无满足条件的数值，不输出。
 * <p>
 * <p>
 * 输入样例1:
 * 在这里给出一组输入。例如：
 * <p>
 * 4 1 2 1 1 2
 * 3 6 3 3
 * 输出样例1:
 * 在这里给出相应的输出。
 * 例如：多组答案输出顺序按照每组第一个元素由小到大顺序输出，如果第一个元素相同，则继续按照第二个元素由小到大输出
 * <p>
 * 1 3
 * 4 6
 * 输入样例2:
 * 在这里给出一组输入。例如：
 * <p>
 * 10 20 30 40 55
 * 60 70 5 9 99
 * 输出样例2:
 * 在这里给出相应的输出。
 * <p>
 * 55 99
 * 输入样例3:
 * 在这里给出一组输入。例如：
 * <p>
 * 11 22 33 44 55
 * 66 77 88 99 110
 * 输出样例3:
 * 在这里给出相应的输出。
 * [空串]
 */
public class Simple17 {

    /**
     * 如果S1 - S2是奇数；因为S1 + S2是偶数，因此2S1是奇数矛盾，所以S1 - S2是偶数
     * <p>
     * S1 - a + b = S2 - b + a
     * S1 - S2 = 2diff
     * 2(a - b) = 2diff
     * a - b = diff
     */
    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);

        LinkedList<Integer> list1 = new LinkedList<>();
        String s1 = in.nextLine();
        for (String s : s1.split(" ")) {
            list1.addLast(Integer.parseInt(s));
        }

        LinkedList<Integer> list2 = new LinkedList<>();
        String s2 = in.nextLine();
        for (String s : s2.split(" ")) {
            list2.addLast(Integer.parseInt(s));
        }

        int sum1 = list1.stream().reduce(0, Integer::sum);
        int sum2 = list2.stream().reduce(0, Integer::sum);

        int diff2 = Math.abs(sum1 - sum2);
        if (diff2 % 2 != 0) {
            System.out.println();
            return;
        }

        int diff = diff2 / 2;

        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        List<String> result = new ArrayList<>();
        for (Integer i : list1) {
            if (set2.contains(i + diff)) {
                result.add(i > i + diff ? ("" + (i + diff) + " " + i) : "" + i + " " + (i + diff));
            }
        }

        for (Integer i : list2) {
            if (set1.contains(i + diff)) {
                result.add(i > i + diff ? ("" + (i + diff) + " " + i) : "" + i + " " + (i + diff));
            }
        }

        result = result.stream().distinct().collect(Collectors.toList());

        Collections.sort(result);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
