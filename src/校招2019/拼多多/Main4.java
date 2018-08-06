package 校招2019.拼多多;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/8/5 18:30.
 *
 * 没过
5
3 5 2 4 1

6
1 2 4 3 3 3
 */
public class Main4 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
//        String str = scanner.nextLine();
//        int N = Integer.parseInt(str);
//        String[] strs = scanner.nextLine().split(" ");
//        ArrayList<Integer> numList = new ArrayList<>();
//        for(int i = 0;i<N ;i++) {
//            numList.add(Integer.parseInt(strs[i]));
//        }
//
//        int res = 0;
//        while (numList.size() > 1) {
//            int numSize = numList.size();
//            res++;
//            int upNum = 0;
//            int downNum =0;
//            ArrayList<Integer> temp1 = new ArrayList<>();
//            ArrayList<Integer> temp2 = new ArrayList<>();
//            temp1.add(numList.get(0));
//            temp2.add(numList.get(0));
//            for(int i=1;i<numSize;i++) {
//                temp1.add(numList.get(i));
//                temp2.add(numList.get(i));
//                if (numList.get(i) > numList.get(i-1)) {
//                    upNum++;
//                }
//                if (numList.get(i) < numList.get(i-1)) {
//                    downNum++;
//                }
//            }
//
////            if (upNum > downNum) {
////                for (int i = numSize-1; i > 0; i--) {
////                    if (temp1.get(i) > temp1.get(i - 1)) {
////                        temp1.remove(i);
////                    }
////                }
////            } else {
////                for (int i = numSize-1; i > 0; i--) {
////                    if (temp1.get(i) < temp1.get(i - 1)) {
////                        temp1.remove(i);
////                    }
////                }
////            }
//
//
//            for (int i = numSize-1; i > 0; i--) {
//                if (temp1.get(i) > temp1.get(i - 1)) {
//                    temp1.remove(i);
//                }
//            }
//            for (int i = numSize-1; i > 0; i--) {
//                if (temp2.get(i) < temp2.get(i - 1)) {
//                    temp2.remove(i);
//                }
//            }
//
//            int temp1up = 0;
//            int temp1down = 0;
//            int temp1Size = temp1.size();
//            for(int i=1;i<temp1Size;i++) {
//                if (temp1.get(i) > temp1.get(i-1)) {
//                    temp1up++;
//                }
//                if (temp1.get(i) < temp1.get(i-1)) {
//                    temp1down++;
//                }
//            }
//            int temp1num = Math.max(temp1up, temp1down);
//
//            int temp2up=0;
//            int temp2down=0;
//            int temp2Size = temp2.size();
//            for(int i=1;i<temp2Size;i++) {
//                if (temp2.get(i) > temp2.get(i-1)) {
//                    temp2up++;
//                }
//                if (temp2.get(i) < temp2.get(i-1)) {
//                    temp2down++;
//                }
//            }
//            int temp2num = Math.max(temp1up, temp1down);
//
//            if (temp2num + downNum > temp1num + upNum) {
//                numList = temp2;
//            } else {
//                numList = temp1;
//            }
//        }
//        System.out.println(res);
//    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String str = scanner.nextLine();
        int N = Integer.parseInt(str);
        String[] strs = scanner.nextLine().split(" ");
        ArrayList<Integer> numList = new ArrayList<>();
        for(int i = 0;i<N ;i++) {
            numList.add(Integer.parseInt(strs[i]));
        }

        int res = 0;
        while (numList.size() > 1) {
            int numSize = numList.size();
            res++;
            int upNum = 0;
            int downNum =0;
            ArrayList<Integer> temp1 = new ArrayList<>();

            temp1.add(numList.get(0));

            for(int i=1;i<numSize;i++) {
                temp1.add(numList.get(i));

                if (numList.get(i) > numList.get(i-1)) {
                    upNum++;
                }
                if (numList.get(i) < numList.get(i-1)) {
                    downNum++;
                }
            }

            if (upNum > downNum) {
                for (int i = numSize-1; i > 0; i--) {
                    if (temp1.get(i) > temp1.get(i - 1)) {
                        temp1.remove(i);
                    }
                }
            } else {
                for (int i = numSize-1; i > 0; i--) {
                    if (temp1.get(i) < temp1.get(i - 1)) {
                        temp1.remove(i);
                    }
                }
            }

            numList = temp1;
        }
        System.out.println(res-1);
    }
}
