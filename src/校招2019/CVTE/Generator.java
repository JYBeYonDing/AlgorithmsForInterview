package 校招2019.CVTE;

/**
 * Created by 杨杰 on 2018/7/20 20:10.
 */
public class Generator {
    long total = -1;
    long max = 62*62*62*62;
    public String generate(){
        total++;
        if(total==0){
            return parseID(total);
        }else if(total >= max){
            throw new RuntimeException("超出范围");
        }else {
            return parseID(total);
        }
    }
    private String parseID(long total){
        char[] chars = new char[4];
        chars[3] = long2char(total%62);
        total = total/62;
        chars[2] = long2char(total%62);
        total = total/62;
        chars[1] = long2char(total%62);
        total = total/62;
        chars[0] = long2char(total);
        return new String(chars);
    }
    private char long2char(long num){
        if(num<=9){
            return (char)('0'+num);
        }else if(num<=35){
            return (char)('A'+num-10);
        }else {
            return (char)('a'+num-36);
        }
    }
    public long getTotal(){
        return total+1;
    }

    public static void main(String[] args) {
        Generator generator = new Generator();
        for(int i=0;i<65;i++) {
            System.out.println(generator.generate());
            System.out.println(generator.total);
            System.out.println();
        }
    }
}
