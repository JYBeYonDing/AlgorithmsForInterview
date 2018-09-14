package 校招2019.大华;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by James on 2018/9/13 10:34.
 */
public class Dahua1 {
    public static void main(String[] args) {
        String str1 = new String("dahua");
        String str2 = new String("dahua");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        Set hashset = new HashSet();
        hashset.add(str1);
        hashset.add(str2);


        Iterator it = hashset.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
