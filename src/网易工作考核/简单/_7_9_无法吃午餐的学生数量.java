package 网易工作考核.简单;

import java.util.Scanner;

public class _7_9_无法吃午餐的学生数量 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String strStu = in.nextLine();
        String strSan = in.nextLine();
        String[] stuList = strStu.split(" ");
        String[] sanList = strSan.split(" ");
        int sanIdx = 0;
        int last = 0;

        for (int i = 0; i < stuList.length;) {
            if (sanList[sanIdx].equals(stuList[i])) {
                last = i;
                sanIdx++;
                stuList[i] = "2";
                if (sanIdx >= sanList.length) {
                    break;
                }
            }
            i++;
            if (i == stuList.length) {
                i = 0;
            }
            if (last == i) {
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < stuList.length; i++) {
            if (!stuList[i].equals("2")) {
                res++;
            }
        }
        System.out.println(res);
    }
}
