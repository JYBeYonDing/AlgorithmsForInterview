package 牛客算法班.第三期.advanced_class_05;


/**
 * 表达式得到期望结果的组成种数
 * 【题目】
 * 给定一个只由0（假） 、 1(真)、 &(逻辑与)、 |（逻辑或） 和^(异或)五种字符组成的字符
 * 串express， 再给定一个布尔值desired。 返回express能有多少种组合方式， 可以达到
 * desired的结果。
 * 【举例】
 * express="1^0|0|1"， desired=false。
 * 只有1^((0|0)|1)和1^(0|(0|1))的组合可以得到false， 返回2。
 * express="1"， desired=false。
 * 无组合则可以得到false， 返回0。
 */
public class Code_05_ExpressionNumber {

    public static boolean isValid(char[] exp) {
        if ((exp.length & 1) == 0) {//长度为偶数，表达式肯定是无效的
            return false;
        }
        for (int i = 0; i < exp.length; i = i + 2) {
            if ((exp[i] != '1') && (exp[i] != '0')) {
                return false;
            }
        }
        for (int i = 1; i < exp.length; i = i + 2) {
            if ((exp[i] != '&') && (exp[i] != '|') && (exp[i] != '^')) {
                return false;
            }
        }
        return true;
    }

    public static class ReturnData {
        public int trueNums;
        public int falseNums;

        public ReturnData(int trueNums, int falseNums) {
            this.trueNums = trueNums;
            this.falseNums = falseNums;
        }
    }

    /*递归*/
    public static int getNum(String str, boolean aim) {
        char[] chs = str.toCharArray();
        ReturnData res = getInvidNum(chs, 0, chs.length - 1);
        return aim ? res.trueNums : res.falseNums;
    }

    /**
     * L R位置一定要为0 或 1
     */
    public static ReturnData getInvidNum(char[] chs, int L, int R) {
        if (L == R) {
            if (chs[L] == '0') {
                return new ReturnData(0, 1);
            } else {
                return new ReturnData(1, 0);
            }
        }

        int trueNums = 0;
        int falseNums = 0;
        for (int i = L + 1; i < R; i += 2) {
            ReturnData leftPart = getInvidNum(chs, L, i - 1);
            ReturnData rightPart = getInvidNum(chs, i + 1, R);
            int a = leftPart.trueNums;
            int b = leftPart.falseNums;
            int c = rightPart.trueNums;
            int d = rightPart.falseNums;
            if (chs[i] == '&') {
                trueNums += a * c;
                falseNums += a * d + b * d + b * c;
            } else if (chs[i] == '|') {
                trueNums += a * c + b * c + a * d;
                falseNums += b * d;
            } else {// ^
                trueNums += a * d + b * c;
                falseNums += a * c + b * d;
            }
        }
        return new ReturnData(trueNums, falseNums);
    }


    /*递归改动态规划*/
    public static int getNum2(String str, boolean aim) {
        if (str == null || str.length() == 0) {
            // throw
            return 0;
        }
        if (str.length() == 1) {
            return aim ? (str.equals("1") ? 1 : 0) : (str.equals("0") ? 1 : 0);
        }
        char[] chs = str.toCharArray();
        if (!isValid(chs)) {
            //throw
            return 0;
        }
        int size = chs.length;
        int[][] trueDP = new int[size][size];
        int[][] falseDP = new int[size][size];

        for (int i = 0; i < size; i += 2) {
            trueDP[i][i] = chs[i] == '1' ? 1 : 0;
            falseDP[i][i] = chs[i] == '0' ? 1 : 0;
        }

        for(int row = size-3;row>=0;row-=2) {
            for(int col = row+2 ; col<size;col+=2) {
                int trueNums=0;
                int falseNums = 0;
                for(int split = row+1;split<col;split+=2) {
                    int a = trueDP[row][split - 1];
                    int b = falseDP[row][split - 1];
                    int c = trueDP[split + 1][col];
                    int d = falseDP[split + 1][col];
                    if (chs[split] == '&') {
                        trueNums += a * c;
                        falseNums += a * d + b * d + b * c;
                    } else if (chs[split] == '|') {
                        trueNums += a * c + b * c + a * d;
                        falseNums += b * d;
                    } else {// ^
                        trueNums += a * d + b * c;
                        falseNums += a * c + b * d;
                    }

                }
                trueDP[row][col] = trueNums;
                falseDP[row][col] = falseNums;
            }
        }

        return aim ? trueDP[0][size - 1] : falseDP[0][size - 1];
    }





    public static int num1(String express, boolean desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        return p(exp, desired, 0, exp.length - 1);
    }

    public static int p(char[] exp, boolean desired, int l, int r) {
        if (l == r) {
            if (exp[l] == '1') {
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;
            }
        }
        int res = 0;
        if (desired) {
            for (int i = l + 1; i < r; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                    case '|':
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                    case '^':
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                }
            }
        } else {
            for (int i = l + 1; i < r; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                    case '|':
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                    case '^':
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                }
            }
        }
        return res;
    }

    public static int num2(String express, boolean desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        int[][] t = new int[exp.length][exp.length];
        int[][] f = new int[exp.length][exp.length];
        t[0][0] = exp[0] == '0' ? 0 : 1;
        f[0][0] = exp[0] == '1' ? 0 : 1;
        for (int i = 2; i < exp.length; i += 2) {
            t[i][i] = exp[i] == '0' ? 0 : 1;
            f[i][i] = exp[i] == '1' ? 0 : 1;
            for (int j = i - 2; j >= 0; j -= 2) {
                for (int k = j; k < i; k += 2) {
                    if (exp[k + 1] == '&') {
                        t[j][i] += t[j][k] * t[k + 2][i];
                        f[j][i] += (f[j][k] + t[j][k]) * f[k + 2][i] + f[j][k] * t[k + 2][i];
                    } else if (exp[k + 1] == '|') {
                        t[j][i] += (f[j][k] + t[j][k]) * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i];
                    } else {
                        t[j][i] += f[j][k] * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i] + t[j][k] * t[k + 2][i];
                    }
                }
            }
        }
        return desired ? t[0][t.length - 1] : f[0][f.length - 1];
    }

    public static void main(String[] args) {
        String express = "1^0&0|1&1^0&0^1|0|1&1";
        boolean desired = true;
        System.out.println(num1(express, desired));
        System.out.println(num2(express, desired));
        System.out.println(getNum(express,desired));
        System.out.println(getNum2(express,desired));
    }

}
