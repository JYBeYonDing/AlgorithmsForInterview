package 牛客网.华为2018届;

/**
 * Created by 杨杰 on 2018/6/27 20:04.
 */
public class 掷骰子 {
    public static void main(String[] args) {
        char[] init = {'1', '2', '3', '4', '5', '6'};
        String changes = "RA";
        char[] chs = changes.toCharArray();
        char temp;
        for (char c : chs) {
            switch (c) {
                case 'L':
                    temp = init[0];
                    init[0] = init[4];
                    init[4] = init[1];
                    init[1] = init[5];
                    init[5] = temp;
                    break;
                case 'R':
                    temp = init[0];
                    init[0] = init[5];
                    init[5] = init[1];
                    init[1] = init[4];
                    init[4] = temp;
                    break;
                case 'F':
                    temp = init[2];
                    init[2] = init[4];
                    init[4] = init[3];
                    init[3] = init[5];
                    init[5] = temp;
                    break;
                case 'B':
                    temp = init[2];
                    init[2] = init[5];
                    init[5] = init[3];
                    init[3] = init[4];
                    init[4] = temp;
                    break;
                case 'A':
                    temp = init[0];
                    init[0] = init[3];
                    init[3] = init[1];
                    init[1] = init[2];
                    init[2] = temp;
                    break;
                case 'C':
                    temp = init[0];
                    init[0] = init[2];
                    init[2] = init[1];
                    init[1] = init[3];
                    init[3] = temp;
                    break;

            }

        }
        System.out.println(new String(init));
    }
}
