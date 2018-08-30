package 校招2019.拼多多2;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/8/30 19:16.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int HP = sc.nextInt();
        int normalAttack = sc.nextInt();
        int buffedAttack = sc.nextInt();

        System.out.println(solution(HP, normalAttack, buffedAttack));

    }

    private static int solution(int hp, int normalAttack, int buffedAttack) {
        if (2 * normalAttack >= buffedAttack) {
            int a = hp / normalAttack;
            int b = hp % normalAttack;
            if (b != 0) {
                return a + 1;
            } else {
                return a;
            }
        } else {
            int ju = hp / buffedAttack;
            hp = hp - ju * buffedAttack;

            if (hp > 2 * normalAttack) {
                return ju * 2 + 2;
            }

            int a = hp / normalAttack;
            int b = hp % normalAttack;
            int c = 0;
            if (b != 0) {
                c= a + 1;
            } else {
                c= a;
            }

            return ju * 2+c ;
        }

    }

}