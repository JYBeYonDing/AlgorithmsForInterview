package 校招2019.头条3;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/9 11:04.
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int N = sc.nextInt();

        int M = sc.nextInt();


        int[][] like = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            like[x][y] = 1;
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i!=j && like[i][j] == 1) {
                    // 如果i关注了j
                    for (int k = 1; k <= N; k++) {
                        if (k != i && like[j][k] == 1) {
                            like[i][k] = 1;

                        }
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i!=j && like[i][j] == 1) {
                    // 如果i关注了j
                    for (int k = 1; k <= N; k++) {
                        if (k != i && like[j][k] == 1) {
                            like[i][k] = 1;

                        }
                    }
                }
            }
        }

        int res = 0;
        for (int j = 1; j <= N; j++) {
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                if (like[i][j] == 1) {
                    sum++;
                }
            }
            if (sum == N-1) {
                res++;
            }

        }

        System.out.println(res);

    }






    public static void main2(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int n=scan.nextInt();//读第一行数
            int m=scan.nextInt();//读第二行数
            int[][] arr=new int[n+1][n+1];//创建一个二维数组
            for(int i=0;i<m;i++){//读第三行数据到二维数组arr中
                int a=scan.nextInt();
                int b=scan.nextInt();
                arr[a][b]=1;
            }
            //从第一列开始，循环两遍判断arr[i][j]==1
            for(int k=0;k<2;k++){
                for(int j=1;j<=n;j++){//代表列
                    for(int i=1;i<=n;i++){
                        if(arr[i][j]==1){//代表行
                            get(i,j,arr,n);//调用函数，自己定义的
                        }
                    }
                }
            }
            //依次循环arr二维数组，每一列加起来要=n-1才行
            int res=0;
            for(int i=1;i<=n;i++){
                int sum=0;
                for(int j=1;j<=n;j++){
                    if(arr[j][i]==1)sum++;
                }
                if(sum==n-1)res++;
            }
            System.out.println(res);//输出结果
        }
    }
    //自己定义的函数
    public static void get(int i,int j,int[][] arr,int n){
        for(int k=1;k<=n;k++){
            if((k!=j)&&(k!=i)&&(arr[k][i]==1))arr[k][j]=1;
        }
    }
}