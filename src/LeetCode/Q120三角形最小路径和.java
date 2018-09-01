package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 2018/8/31 13:50.
 */
public class Q120三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {


        int[][] triangles = new int[triangle.size()][];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int[] temp = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                temp[j] = list.get(j);
            }
            triangles[i]=temp;
        }


        for (int i = 1; i < triangles.length; i++) {
            for (int j = 0; j < triangles[i].length; j++) {

                triangles[i][j] = Math.min((j-1)>=0?triangles[i-1][j-1]:Integer.MAX_VALUE,
                        (j>=i)?Integer.MAX_VALUE:triangles[i-1][j]) + triangles[i][j];
            }
        }

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < triangles[triangle.size()-1].length; j++) {
            min = Math.min(min, triangles[triangle.size()-1][j]);
        }
        return min;
    }


    public static void main(String[] args) {
        Q120三角形最小路径和 sanjiao = new Q120三角形最小路径和();

        List<List<Integer>> tri = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        tri.add(list);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        tri.add(list2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        tri.add(list3);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        tri.add(list4);

        System.out.println(sanjiao.minimumTotal(tri));

    }
}
