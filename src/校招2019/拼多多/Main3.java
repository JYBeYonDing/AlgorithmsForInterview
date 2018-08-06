package 校招2019.拼多多;

import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/8/5 18:30.
 *
 5 0
 1 2 3
 0 4
 0 4
 0 4
 1 2 3
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String[] strs = scanner.nextLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int target = Integer.parseInt(strs[1]);
        HashSet<Integer>[] friendLists = new HashSet[N];
        for(int i= 0;i<N;i++) {
            strs = scanner.nextLine().split(" ");
            friendLists[i] = new HashSet<>();
            for(int k=0;k<strs.length;k++) {
                friendLists[i].add(Integer.parseInt(strs[k]));
            }
        }

        int maxSameFriends = 0;
        int willBeFriend = -1;
        for(int i=0;i<N;i++) {
            if (i != target && !friendLists[target].contains(i)) {
                //求共同朋友数
                HashSet<Integer> temp = new HashSet<>(friendLists[target]);
                temp.retainAll(friendLists[i]);
                int size = temp.size();
                if (size > maxSameFriends) {
                    maxSameFriends = size;
                    willBeFriend = i;
                }
            }
        }

        System.out.println(willBeFriend);
    }
}
