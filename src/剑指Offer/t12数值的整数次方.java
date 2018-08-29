package 剑指Offer;

/**
 * Created by James on 2018/8/27 19:12.
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 */
public class t12数值的整数次方 {
    public double Power(double base, int exponent) {
        if (equal(base, 0.0)) {
            if (exponent == 0) {
                return 1;
            } else {
                return 0;
            }
        }else{
            if (exponent == 0) {
                return 1;
            } else if (exponent < 0) {
                return 1.0 / positiveExponentPower(base, -exponent);
            } else {
                return positiveExponentPower(base, exponent);
            }
        }
    }

    // 用递归求base^exponent
    /**
     * a^n = a^(n/2)*a^(n/2)               n为偶数
     * a^n = a^((n-1)/2)*a^((n-1)/2)*a     n为奇数
     *
     */
    private double positiveExponentPower(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = positiveExponentPower(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result = result * base;
        }
        return result;
    }

    private boolean equal(double a, double b) {
        return Math.abs(a - b) < 0.000001;
    }
}
