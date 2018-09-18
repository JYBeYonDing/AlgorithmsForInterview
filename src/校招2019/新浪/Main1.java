package 校招2019.新浪;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by James on 2018/9/15 21:25.
 */
public class Main1 {

    public static void main(String[] args) {
        Integer c=null;
        System.out.println(c==1);// 会抛出异常NullPointerException
    }

//    public static void main(String[] args) {
//        HashMap<User, Integer> notReadCount = new HashMap<User, Integer>();
//
//
//    }
//
//    public void add(HashMap<User, Integer> notReadCount, User user,int count){
//        notReadCount.put(user, notReadCount.getOrDefault(user, 0) + count);
//    }
//
//    public int getNotReadCount(HashMap<User, Integer> notReadCount, User user) {
//        return notReadCount.getOrDefault(user, 0);
//    }
//
//    public void clear(HashMap<User, Integer> notReadCount, User user) {
//        notReadCount.put(user, 0);
//    }
}
