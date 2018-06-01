import edu.princeton.cs.algs4.In;
import jdk.nashorn.internal.runtime.ECMAException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.BindException;
import java.util.*;

/**
 * 临时测试用，可以清空
 * 用于进行一些编程的测试，每次要用时可以将这里的内容清空
 */
public class Test {
    public static void main(String[] args) {
        TreeSet<Fruit> treeSet = new TreeSet<>();
        treeSet.add(new Fruit("att1",1));
        treeSet.add(new Fruit("att1",2));
        System.out.println(treeSet);
        Class s = new Fruit("ad",2).getClass();
    }

}

class Fruit implements Comparable<Fruit>{
    String att1;
    int att2;

    public Fruit(String att1, int att2) {
        this.att1 = att1;
        this.att2 = att2;
    }

    @Override
    public boolean equals(Object obj) {
//        if (!(obj instanceof Fruit)) {
//            return false;
//        } else {
           return ((Fruit) obj).att1.equals(att1);
//        }
    }

    @Override
    public int compareTo(Fruit o) {
        return att2-o.att2;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "att1='" + att1 + '\'' +
                ", att2=" + att2 +
                '}';
    }

    @Override
    public int hashCode() {
        return att1.hashCode();
    }
}


//class GenericReading {
//    static List<Apple> apples = Arrays.asList(new Apple());
//    static List<Fruit> fruit = Arrays.asList(new Fruit());
//    static class Reader<T> {
//        T readExact(List<T> list) {
//            return list.get(0);
//        }
//    }
//    static void f1() {
//        Reader<Fruit> fruitReader = new Reader<Fruit>();
//        // Errors: List<Fruit> cannot be applied to List<Apple>.
////         Fruit f = fruitReader.readExact(apples);
//    }
//    static void f2() {
//        CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
//        Fruit f = fruitReader.readCovariant(fruit);
//        Fruit a = fruitReader.readCovariant(apples);
//    }
//    public static void main(String[] args) {
//        f1();
//    }
//}
//class CovariantReader<T> {
//    T readCovariant(List<? extends T> list) {
//        return list.get(0);
//    }
//}