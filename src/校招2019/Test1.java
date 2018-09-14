package 校招2019;

/**
 * Created by James on 2018/9/4 19:17.
 */
public class Test1 {

    public final void sort(Comparable[] a) {

        int N = a.length;
        int h =1;

        while (h < N / 3) {
            h = 3 * h + 1;

        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && compareElement(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h=h/3;
        }
    }


    public boolean compareElement(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


//    public static void main(String[] args) {
//        Test1 t = new Test1();
//        t.sort(new int[]{15, 0, 6, 9, 3});
//
//        System.out.println();
//    }
}
