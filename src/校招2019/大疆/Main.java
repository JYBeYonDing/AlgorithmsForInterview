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
//    public static void main(String args[])
//    {
//        Scanner cin = new Scanner(System.in);
//        int a, b;
//        while(cin.hasNextInt())
//        {
//            a = cin.nextInt();
//            b = cin.nextInt();
//            System.out.println(a + b);
//        }
//    }

    public static void main(String[] args){
        int[] num = {2,3,1,1,4};
        int  n = solution(num);
        System.out.println(n);
    }

    private static int solution(int[] num) {
        int index= 0;
        int step= 0;
        int len = num.length;
        int p= 0;
        while(p<len){
            if(p+num[p]>=len-1){return step+1;}
            int max=-1;
            for(int i = p+1;i<=p+num[p];i++){
                if(max<i+num[i]){
                    max = i+num[i];
                    index = i;
                }
            }
            step++;
            p=index;
        }
        return step;
    }
}
