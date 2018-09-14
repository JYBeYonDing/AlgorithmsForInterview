package 校招2019.大华;

/**
 * Created by James on 2018/9/13 10:32.
 */
public class Dahua {
    public static void main(String[] args) {
        A b = new B();
        b = new B();
    }
}

class A{
    static {
        System.out.println("a");
    }
    public A(){
        System.out.println("b");
    }
}

class B extends A{
    static {
        System.out.println("c");
    }
    public B(){
        System.out.println("d");

    }
}




