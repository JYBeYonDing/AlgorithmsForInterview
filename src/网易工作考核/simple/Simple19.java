package org.example.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 奖励最顶尖的 K 名学生
 * 分数 30
 * 作者 
 * 单位 
 * 给定两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和负面的。
 * positive_feedback = ["smart","brilliant","studious"]
 * negative_feedback = ["not"]
 *
 * 一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减  1 分。
 *
 * 给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中 student_id[i] 表示这名学生的 ID ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
 *
 * 给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。
 *
 * 输入格式:
 * 五部分：正向评语数组positive_feedback，负向评价数组negative_feedback，评语数组report，学生ID数组ID，输出top几名k
 *
 * 以-连接：
 *
 * 输出格式:
 * 最顶尖学生的ID数组
 * 注：拼接字符串时，如果是多个学生的情况，如[1, 2, 3]，需要拼接 ‘, ‘，逗号后面要带上空格
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * ["smart","brilliant","studious"]-["not"]-["this student is studious","the student is smart"]-[1,2]-1
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * [1]
 */
public class Simple19 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();

        String[] inputs = input.split("-");

        //map解决正反向的分数问题
        Map<String, Integer> scoreMap = new HashMap<>();

        //核心是这里替换包括中括号和引号
        String[] pf = inputs[0].replaceAll("[\\[\"\\]]","").split(",");
        for(String s : pf) {
            scoreMap.put(s,3);
        }

        String[] nf = inputs[1].replaceAll("[\\[\"\\]]","").split(",");
        for(String s : nf) {
            scoreMap.put(s, -1);
        }

        String[] reports = inputs[2].replaceAll("[\\[\"\\]]","").split(",");
        String[] sids = inputs[3].replaceAll("[\\[\"\\]]","").split(",");

        int k = Integer.parseInt(inputs[4]);

        int[][] result = new int[sids.length][2];

        for(int i = 0; i < sids.length; i++) {
            int sid = Integer.parseInt(sids[i]);
            int score = 0;
            for(String w : reports[i].split(" ")) {
                //使用default省去判断
                score += scoreMap.getOrDefault(w, 0);
            }
            result[i][0] = score;
            result[i][1] = sid;
        }

        //二重排序判断
        Arrays.sort(result, (a,b) -> a[0] != b[0] ? b[0] - a[0]: a[1] - b[1]);

        int [] topK = new int[k];
        for(int i = 0; i< k; i++){
            topK[i] = result[i][1];
        }

        //必须显示toString，否则是对象地址
        System.out.println(Arrays.toString(topK));
    }
}
