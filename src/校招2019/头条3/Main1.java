package 校招2019.头条3;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/9 10:03.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String str = sc.nextLine();

        if (str == null || str.length() == 0) {
            System.out.println(0);
        }
        if (str.length() == 1) {
            System.out.println(1);
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for(int i=0;i<str.length();i++) {
            if (map.containsKey(str.charAt(i))) {
                maxLength = Math.max(maxLength, i - left);
                left = Math.max(left,map.get(str.charAt(i))+1);
            }
            map.put(str.charAt(i),i);
        }
        maxLength = Math.max(maxLength, str.length()-left);
        System.out.println(maxLength);
    }

}