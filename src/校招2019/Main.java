package 校招2019;

/**
 * Created by James on 2018/9/4 19:03.
 */
public class Main {



    public static void main(String[] args) {
        A classA = new B();
        System.out.println(classA.a);
        classA.fun();
    }
}
class A {
    public int a=0;
    public void fun(){
        System.out.println("A");
    }

}

class B extends A{
    public int a = 1;
    public void fun(){
        System.out.println("B");
    }

}