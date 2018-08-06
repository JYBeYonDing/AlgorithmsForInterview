package LeetCode;

/**
 * Created by 杨杰 on 2018/7/22 0:24.
 */
public class Q12整数转罗马数字 {
    public String intToRoman2(int num) {
        int[] numbers =    { 1000,  900,  500,  400,  100,   90,  50,   40,   10,    9,    5,     4,    1 };
        String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC", "L",  "XL",  "X",  "IX", "V",  "IV", "I" };
        StringBuilder res =new StringBuilder() ;
        for(int i = 0;i<13;i++){
            if(num >= numbers[i]){
                int count = num/numbers[i];
                num = num%numbers[i];
                for(int j=0;j<count ;j++){
                    res= res.append(letters[i]);
                }
            }
        }
        return res.toString();
    }

    // 还是有错误，细节还没有考虑清楚
    public static String intToRoman(int num) {
        if (num == 4) {
            return "IV";
        }
        if (num == 9) {
            return "IX";
        }
        if (num == 40) {
            return "XL";
        }
        if (num == 90) {
            return "XC";
        }
        if (num == 400) {
            return "CD";
        }
        if (num == 900) {
            return "CM";
        }
        int numI = num % 5;
        num = num - numI;
        int numV = num % 10/5;
        num = num - numV * 5;
        int numX = num % 50/10;
        num = num - numX * 10;
        int numL = num % 100/50;
        num = num - numL * 50;
        int numC = num % 500/100;
        num = num - numC * 100;
        int numD = num % 1000/500;
        num = num - numD * 500;
        int numM = num / 1000;
        StringBuilder sb = new StringBuilder();
        if (numM == 4) {
            sb.append("CM");
        } else {
            for(int i = 0; i<numM;i++) {
                sb.append("M");
            }
        }
        if (numD == 4) {
            sb.append("CM");
        } else {
            for(int i = 0; i<numD;i++) {
                sb.append("D");
            }
        }
        if (numC == 4) {
            sb.append("XC");
        } else {
            for(int i = 0; i<numC;i++) {
                sb.append("C");
            }
        }
        if (numL == 4) {
            sb.append("XL");
        } else {
            for(int i = 0; i<numL;i++) {
                sb.append("L");
            }
        }
        if (numX == 4) {
            sb.append("IX");
        } else {
            for(int i = 0; i<numX;i++) {
                sb.append("X");
            }
        }
        if (numV == 4) {
            sb.append("IV");
        } else {
            for(int i = 0; i<numV;i++) {
                sb.append("V");
            }
        }
        if (numI == 4) {
            sb.append("IV");
        } else {
            for(int i = 0; i<numI;i++) {
                sb.append("I");
            }
        }

        return new String(sb);
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
