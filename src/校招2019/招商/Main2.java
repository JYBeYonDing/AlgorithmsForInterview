package 校招2019.招商;

import java.io.*;
import java.util.*;

/**
 * Created by James on 2018/9/8 11:38.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));

        int num = scanner.nextInt();

        for(int i=0;i<num;i++){
            for (int j = i + 1; j < num; j++) {
                if (j * j - i * i + i + j == 2 * num) {
                    System.out.print("[");
                    for (int k = i; k < j; k++) {
                        System.out.print(k+",");
                    }
                    System.out.println(j+"]");

                }
            }
        }
    }
}
