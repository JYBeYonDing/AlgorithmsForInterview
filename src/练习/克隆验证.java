package 练习;

/**
 * Created by 杨杰 on 2018/8/12 20:19.
 */
public class 克隆验证 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Wine w1 = new Wine(2018, "Fake_Lafite");
        Wine w2 = (Wine)w1.clone();
        w2.setName("True_Lafite");// 虽然clone只是复制引用，但是这里setName使得w2中的name指向了其他的地方。w1中的仍然没变。
        w2.setYear(1982);
        System.out.println(w1.getYear());
        System.out.println(w1.getName());
    }
}
class Wine implements Cloneable{
    private int year;
    private String name;

    public Wine(int year, String name){
        this.year = year;
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}