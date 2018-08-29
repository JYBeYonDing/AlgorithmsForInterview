package 校招2019.好未来;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/8/29 15:11.
 * 0 1 1 1 1 1 1 1 1 0
 *
 * 注意！！！用Collections可以对ArrayList进行排序
 */
public class Main3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String[] strs = sc.nextLine().split(" ");

        int[] nums = new int[strs.length];
        int count = 1;
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
            if (nums[i] == 0) {
                count <<= 1;//几个零就有几种组合，比如说有两个0，就有4种组合
            }
        }

        ArrayList<String> res = new ArrayList<>();


        for (int i = 0; i < count; i++) {
            String s = "";
            int[] numsTemp = nums.clone();
            int temp = i;
            for (int k = 0; k < numsTemp.length; k++) {
                if (numsTemp[k] == 0) {
                    numsTemp[k]= temp&1;// 将temp各个位上的数填入到nums对应的0位置处
                    temp>>=1;
                }
                if (numsTemp[k] == 1) {
                    s += k;
                }
            }
            res.add(s);
        }


        Collections.sort(res);// 用Collections可以对ArrayList进行排序

        for (String s : res) {
            System.out.println(s);
        }
    }
}