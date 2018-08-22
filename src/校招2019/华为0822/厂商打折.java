package 校招2019.华为0822;

import java.util.Scanner;

/**
 * Created by James on 2018/8/22 18:57.
 *
 * 没有AC，不知道哪里有问题
 */
public class 厂商打折 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int nums = Integer.parseInt(strings[0]);
        double price = Double.parseDouble(strings[1]);

        System.out.println(solution(nums, price));
    }

    private static int solution(int nums, double price) {
        double price1 = nums * price;
        if (nums >= 3) {
            price1 = price1 * 0.7;
        }
        if (price1 < 50) {
            price1 = price1 + 10;
        }
        price1 = (double)Math.round(price1*100)/100;


        double price2 = nums * price;
        int cut = (int) price2 / 10 * 2;
        price2 = price2 - cut;
        if (price2 < 99) {
            price2 += 6;
        }

        price2 = (double)Math.round(price2*100)/100;


        if (Math.abs(price1-price2)<0.01) {
            return 0;
        } else if (price1 > price2) {
            return 2;
        } else {
            return 1;
        }

    }
}
