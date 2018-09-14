package 校招2019.链家;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/3 14:43.
 */
public class Main1 {
    public static void main(String[] args) {
        // 我觉得就是弄一个数组，下标表示是哪个人，然后里面存的就是直接祖先，
        // 然后继续下去，直到找到-1也没匹配成功的话就没找到
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] infos = new int[n+1];
        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt();
            infos[idx] = sc.nextInt();
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int man1 = sc.nextInt();
            int man2 = sc.nextInt();
            System.out.println(slove(infos, man1, man2));
        }
    }
    public static int slove(int[] infos, int man1, int man2){
        int man1new = man1;
        while(infos[man1] != -1){
            if(infos[man1] == man2){
                return 2;
            }
            man1 = infos[man1];
        }
        while(infos[man2] != -1){
            if(infos[man2] == man1new){
                return 1;
            }
            man2 = infos[man2];
        }
        return 0;
    }

}