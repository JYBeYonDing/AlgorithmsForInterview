package 校招2019.新浪;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/15 21:46.
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        File f = new File("main.java");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String line = null;
        int count = 0;
        while ((line = reader.readLine()) != null) {

            if (isComment(line)) {
                count++;
            }

        }
        System.out.println(count);

    }

    private static boolean isComment(String line) {

        int index = line.indexOf("//");

        if (index < 0) {
            return false;
        }

        int index2 = line.indexOf("\"");
        int count=0;
        while (index2 >= 0 && index2 < index) {
            count++;
            index2 = line.indexOf("\"",index2+1);
        }

        if (count % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}