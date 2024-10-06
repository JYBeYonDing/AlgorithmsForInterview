package 网易工作考核.简单;

import com.alibaba.fastjson2.JSON;

import java.util.Scanner;

public class _7_3跳跃 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] m = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            m[i] = in.nextInt();
        }
        int start = in.nextInt();

        //        System.out.println(JSON.toJSONString(m));

        boolean resut = jump(m, visited, start);
        if (resut) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static boolean jump(int[] m, boolean[] v, int start) {
        if (start >= m.length || start < 0 || v[start]) {
            return false;
        }
        v[start] = true;
        if (m[start] == 0) {
            return true;
        }
        return jump(m, v, start + m[start]) || jump(m, v, start - m[start]);
    }

}
