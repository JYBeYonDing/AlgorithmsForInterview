package 校招2019.快手;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/25 20:32.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = sc.nextInt();

        Block[] blocks = new Block[n];

        int length = 0;
        int width = 0;
        for (int i = 0; i < n; i++) {
            length = sc.nextInt();
            width = sc.nextInt();
            if (length < width) {
                int temp = length;
                length = width;
                width = temp;
            }
            blocks[i] = new Block(length, width);
        }

        Arrays.sort(blocks, new Comparator<Block>() {
            @Override
            public int compare(Block o1, Block o2) {
                return o1.width-o2.width ==0? o1.length-o2.length : o1.width-o2.width;
            }
        });


        Block temp = blocks[0];
        int res = 1;
        for (int i = 1; i < blocks.length; i++) {
            if (temp.width <= blocks[i].width && temp.length <= blocks[i].length) {
                res++;
                temp = blocks[i];
            }
        }
        System.out.println(res);
    }

    static class Block{
        int length;
        int width;

        public Block(int length, int width) {
            this.length = length;
            this.width = width;
        }
    }
}