/**
 * @(#)Main1.java, 2019/8/25.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package 校招2020.字节跳动;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 杨杰(yangjie7 @ corp.netease.com)
 * @date 2019/8/25 19:27.
 */
/**
 *
1
0 0 0 2
0 0 0 2
0 0 4 8
0 0 4 4

 2
 4
 0 0 0 0
 0 0 2 2
 0 2 8 8
 2 4 2 16
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int dir = Integer.parseInt(sc.nextLine());

        int[][] m = new int[4][4];

        int[][] matrix = new int[4][4];


        for (int i = 0; i < 4; i++) {
            String[] nums = sc.nextLine().split(" ");
            for (int j = 0; j < 4; j++) {
                m[i][j] = Integer.parseInt(nums[j]);
            }
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

            }
        }


        if (dir == 1) {
            for (int j = 0; j < 4; j++) {
                // 不是0的索引位置
                //                int nIndx = 0;
                for (int i = 0; i < 3; i++) {
                    if (m[i][j] != 0) {
                        //                        nIndx++;
                        if (m[i][j] == m[i + 1][j]) {
                            m[i][j] *= 2;
                            m[i + 1][j] = 0;
                            i++;
                        }
                    }
                }
                int zIndex = 0;
                for (int i = 0; i < 4; i++) {
                    if (m[i][j] != 0) {
                        m[zIndex][j] = m[i][j];
                        if (zIndex != i) {
                            m[i][j] = 0;
                        }
                        zIndex++;
                    }
                }
            }
        }
        if (dir == 2) {
            for (int j = 0; j < 4; j++) {
                // 不是0的索引位置
                //                int nIndx = 0;
                for (int i = 3; i > 0; i--) {
                    if (m[i][j] != 0) {
                        //                        nIndx++;
                        if (m[i][j] == m[i - 1][j]) {
                            m[i][j] *= 2;
                            m[i - 1][j] = 0;
                            i--;
                        }
                    }
                }
                int zIndex = 3;
                for (int i = 3; i >=0; i--) {
                    if (m[i][j] != 0) {
                        m[zIndex][j] = m[i][j];
                        if (zIndex != i) {
                            m[i][j] = 0;
                        }
                        zIndex--;
                    }
                }
            }
        }
        if (dir == 3) {
            for (int i = 0; i < 4; i++) {
                // 不是0的索引位置
                //                int nIndx = 0;
                for (int j = 0; j < 3; j++) {
                    if (m[i][j] != 0) {
                        //                        nIndx++;
                        if (m[i][j] == m[i][j+1]) {
                            m[i][j] *= 2;
                            m[i][j+1] = 0;
                            j++;
                        }
                    }
                }
                int zIndex = 0;
                for (int j = 0; j < 4; j++) {
                    if (m[i][j] != 0) {
                        m[i][zIndex] = m[i][j];
                        if (zIndex != j) {
                            m[i][j] = 0;
                        }
                        zIndex++;
                    }
                }
            }
        }
        if (dir == 4) {
            for (int i = 0; i < 4; i++) {
                // 不是0的索引位置
                //                int nIndx = 0;
                for (int j = 3; j > 0; j--) {
                    if (m[i][j] != 0) {
                        //                        nIndx++;
                        if (m[i][j] == m[i][j-1]) {
                            m[i][j] *= 2;
                            m[i][j-1] = 0;
                            j--;
                        }
                    }
                }
                int zIndex = 3;
                for (int j = 3; j >=0; j--) {
                    if (m[i][j] != 0) {
                        m[i][zIndex] = m[i][j];
                        if (zIndex != j) {
                            m[i][j] = 0;
                        }
                        zIndex--;
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(m[i][j]+ " ");
            }
            System.out.println();
        }

    }
}
