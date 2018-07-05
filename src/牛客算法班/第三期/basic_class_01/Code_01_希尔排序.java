package 牛客算法班.第三期.basic_class_01;

/**
 * Created by 杨杰 on 2018/6/26 14:30.
 */
public class Code_01_希尔排序 {
    // 我们的算法类不允许产生任何实例
    private Code_01_希尔排序(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n/3){
            h = 3*h + 1;
        }
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable temp = arr[i];
                int j = i-h;
                for ( ; j >= 0 && temp.compareTo(arr[j]) < 0 ; j -= h){
                    arr[j+h] = arr[j];
                }
                arr[j+h] = temp;
            }
            h /= 3;
        }
    }
}
