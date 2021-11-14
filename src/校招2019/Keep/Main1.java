package 校招2019.Keep;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by James on 2018/9/29 12:25.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        String[] nums = strings[0].split(",");
        int[] arr = new int[nums.length];
        for(int i=0;i<arr.length;i++){
            arr[i]= Integer.parseInt(nums[i]);
        }
        int n = Integer.parseInt(strings[1]);
        int res = Arrays.binarySearch(arr,n);
        if(res<0){
            res = -(res+1);
        }
        System.out.println(res);
    }
}
