package 校招2019.远景能源;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 2018/9/6 15:40.
 */
public class Solution2 {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

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

}
