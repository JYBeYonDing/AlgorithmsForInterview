package 校招2019.百度;

import java.util.HashSet;
import java.util.List;

/**
 * Created by James on 2018/9/11 20:43.
 */
public class Main3 {


    public int minRoutes(int numOfPickupLoc, List<Integer> baseCoor,
                         List<List<Integer>> pickupLocCoor)
    {

//        int[] base = new int[2];
//        base[0] = baseCoor.get(0);
//        base[1] = baseCoor.get(1);
//

        HashSet<Double> set = new HashSet<>();

        for (List<Integer> list : pickupLocCoor) {

            double y = list.get(1) - baseCoor.get(1);
            double x = list.get(0) - baseCoor.get(0);

            if (x == 0) {
                set.add(Double.MAX_VALUE);
            }else {
                set.add(Math.abs(y / x));
            }
        }

        return set.size();
        // WRITE YOUR CODE HERE
    }
}
