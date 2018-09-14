package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 2018/9/3 15:40.
 */
public class Q401二进制手表 {


    List<String> res = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {

        res.clear();

        int[] times = {1, 2, 4, 8,10, 20, 40, 80, 160, 320};

        LinkedList<Integer> list = new LinkedList<>();
        if (num == 0) {
            res.add("0:00");
        }

        for (int i = 0; i < times.length; i++) {
            list.addLast(times[i]);
            combination(times, num - 1, list, i + 1);
            list.removeLast();
        }

        return res;
    }

    private void combination(int[] times, int num, LinkedList<Integer> list, int index) {
        if (num == 0) {
            String time = list2time((List<Integer>) list.clone());
            if (time != null) {

                res.add(time);

            }
            return;
        }

        for (int i = index; i < times.length; i++) {
            list.addLast(times[i]);
            combination(times, num - 1, list, i + 1);
            list.removeLast();
        }

    }

    private String list2time(List<Integer> list) {
        int h = 0;
        int s = 0;
        for (int i : list) {
            if (i < 10) {
                h += i;
            } else {
                s += i / 10;
            }
        }

        if (h < 12 && s < 60) {
            if (s < 10) {
                return h + ":" + "0" + s;
            } else {
                return h + ":" + s;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        List<String> res = new Q401二进制手表().readBinaryWatch(2);
        for (String s : res) {
            System.out.println(s);
        }

    }









    //*****************************************************************************

    public static int[] time = new int[] { 8, 4, 2, 1, 32, 16, 8, 4, 2, 1 };
    public static int n = 0;
    public static List<String> readBinaryWatch2(int num) {
        List<String> res = new ArrayList<String>();
        boolean[] temp = new boolean[10];
        n = num;
        dfs(res, temp, 0, 0);
        return res;
    }

    private static void dfs(List<String> res, boolean[] temp, int count, int p) {
        if (count == n) {
            String str = getBinaryValue(temp);
            if (!"".equals(str))
                res.add(str);
            return;
        } else {
            while (p < 10) {
                temp[p] = true;
                dfs(res, temp, count + 1, p + 1);
                temp[p] = false;
                p++;
            }
        }
    }

    private static String getBinaryValue(boolean[] temp) {
        int h = 0;
        int m = 0;
        for (int i = 0; i < 4; i++)
            if (temp[i])
                h += time[i];
        for (int i = 4; i < 10; i++)
            if (temp[i])
                m += time[i];
        if (h > 11 || m > 59)
            return "";
        if (m < 10)
            return "" + h + ":" + "0" + m;
        return "" + h + ":" + m;

    }

}
