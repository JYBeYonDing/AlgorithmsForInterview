package Java面试慕课课程;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 杨杰 on 2018/6/22 16:22.
 */
public class Combinations {
    /**
     * Generate all combinations and output them,
     * selecting n elements from data.
     *
     * @param data
     * @param n
     */
    public void combinations(List<Integer> selected, List<Integer> data, int n) {
        // initial value for recursion
        // how to select elements
        // how to output
        if (n == 0) {
            //output all selected elements + empty list
            for (Integer i : selected) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        if (data.isEmpty()) {
            return;
        }

        // select element 0
        selected.add(data.get(0));
        combinations(selected,data.subList(1, data.size()), n - 1);
        // un-select element 0
        selected.remove(selected.size() - 1);
        combinations(selected, data.subList(1, data.size()), n);
    }
    public static void main(String[] args) {
        Combinations comb = new Combinations();
        comb.combinations(new ArrayList<>(),Arrays.asList(1,2,3,4), 2);
    }
}
