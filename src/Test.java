import java.util.HashSet;

/**
 * Created by James on 2018/9/6 12:14.
 */
public class Test {

    public static void main(String[] args) {

        String string = "BAACAACCBAAA";
        System.out.println(isPure(string));
    }

    public static boolean isPure(String string) {
        if (string == null || string.length() < 3) {
            return false;
        }

        int left = 0;
        int right = 2;
        HashSet<Character> set = new HashSet<>();

        while (right < string.length()) {
            set.clear();
            for (int i = left; i <= right; i++) {
                set.add(string.charAt(i));
            }
            if (set.size() == 3) {
                return true;
            }
            right++;
            left++;

        }
        return false;
    }
}
