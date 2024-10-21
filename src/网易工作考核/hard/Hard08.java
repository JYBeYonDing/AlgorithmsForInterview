package org.example.hard;

/**
 * 解码异或后的排列
 * 分数 60
 * 作者 
 * 单位 
 * 给你一个整数数组 perm ，它是前 n 个正整数（1,2,3,4,5,…,n-1,n 共n个正整数）的排列，且 n 是个奇数 。
 *
 * 它被加密成另一个长度为 n-1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i+1]。比方说，如果 perm=[1,3,2] ，那么 encoded=[2,1]。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 * 提示：
 *
 * n 是奇数。
 *
 * 3 <= n < 10^5
 *
 * encoded.length == n - 1
 *
 * 输入格式:
 * 整数数组encoded，以",”分隔字符串形式作为输入
 *
 * 输出格式:
 * 解码后的原始整数数组perm，以",”分隔字符串形式作为输出
 *
 *
 * 输入样例:
 * 加密后的整数数组encoded：
 *
 * 6,5,4,6
 * 输出样例:
 * 原始数组perm：
 *
 * 2,4,1,5,3
 */
public class Hard08 {
}
