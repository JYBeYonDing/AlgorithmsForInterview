package 练习;


/**
 * Created by 杨杰 on 2018/8/12 19:55.
 */
class Fruit{
    private Core c;
    protected class Core{
        public Core(){
            System.out.println("Fruit.Core()");
        }
    }
    public Fruit(){
        System.out.println("New Fruit()");
        c = new Core();
    }
}
class BigFruit extends Fruit{
    public class Core{
        public Core(){
            System.out.println("BigFruit.Core()");
        }
    }
}
public class 加载验证 {
    public static void main(String[] args) {
        BigFruit f = new BigFruit();
    }
}
