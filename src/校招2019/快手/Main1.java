package 校招2019.快手;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/25 19:53.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = sc.nextInt();

        if (n <= 1) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;

        int res = 0;

        int sumLeft = 0;
        int sumRight =0;

        while (left < right) {

            if (sumLeft < sumRight) {
                sumLeft += arr[left++];
            }

            if (sumLeft > sumRight) {
                sumRight += arr[right--];
            }

            if (sumLeft == sumRight) {
                res = sumLeft;
                sumLeft += arr[left++];
                sumRight += arr[right--];
            }

        }
        if (sumLeft == sumRight) {
            res = sumLeft;
        }
        System.out.println(res);
    }























    public static void main2(String[]args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int data[]=new int[n];
        for(int i=0;i<n;i++)data[i]=in.nextInt();
        System.out.println(f(data,n));
    }

    public static long f(int data[],int len){
        if(len==1)return 0;
        long rel=0;
        int low=0;int hi=len-1;
        long count1=0,count2=0;
        while(low<=hi){
            while(count1==0||count1<count2){
                count1+=data[low++];
            }
            while(count2==0||count1>count2){
                count2+=data[hi--];
            }
            if(count1==count2){
                if(count1>rel)rel=count1;
                count1+=data[low++];
            }

        }
        return rel;
    }
}