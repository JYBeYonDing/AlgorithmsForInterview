package 校招2019.大疆;

/**
 * Created by 杨杰 on 2018/7/5 21:56.
 */
import java.io.*;
import java.util.*;
class Test {
}
public class Main
{
    public static void main(String[] args) {
        new Main().convert();
    }
    public void convert() {
        int i = 10;
        char a = 'a';
//        char a = "a".charAt(0);
//        int a = 97;
        System.out.println(false ? i : a);
        System.out.println(false ? 65 : a);
        System.out.println(false ? 65.0 : a);
    }
}
