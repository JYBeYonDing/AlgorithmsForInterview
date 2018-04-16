package 牛客算法班.第三期.basic_class_03;

/**
 * Created by 杨杰 on 2018/4/16 19:28.
 *
 * 布隆过滤器   有失误的一种set  bit类型的map
 *
 * k个哈希函数
 *
 * 布隆过滤器的大小 m = -(n*lnp)/((ln2)^2) bit 其中 n:样本量 p:失误率
 * 哈希函数的个数 k = ln2*m/n = 0.7*m/n
 * 真实失误率 (1-e^(-n*k/m))^k
 *
 * 公式怎么推的可以查博客
 */
public class 布隆过滤器 {


    public static void main(String[] args) {
        int[] arr = new int[1000];// 32000 可以是long类型，还可以做成矩阵
        int index = 300000;

        int intIndex = index / 32;
        int bitIndex = index % 32;

        arr[intIndex] = arr[intIndex] | (1 << bitIndex);
    }
}
