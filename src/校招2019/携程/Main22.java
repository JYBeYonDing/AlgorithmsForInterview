package 校招2019.携程;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by James on 2018/9/4 20:38.
 */
public class Main22 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = Integer.valueOf(sc.nextLine());
            List<Integer> list = new ArrayList<>();
            long curTime = getLongFromString(sc.nextLine());
            for(int i = 0;i < n;i ++){
                Integer result = getOrderId(sc.nextLine(),curTime);
                if(result!=null)
                    list.add(result);
            }

            Collections.sort(list);

            if(list==null||list.size()==0){
                System.out.println("null");
            }else{
                for(Integer i:list)
                    System.out.println(i);
            }
        }
        sc.close();
    }

    public static Integer getOrderId(String s,long curtime){
        String arr[] = s.split("\\s+");
        long start = getLongFromString(arr[1]);
        long end = getLongFromString(arr[2]);
        if(start<=curtime && curtime<=end)
            return Integer.valueOf(arr[0]);
        return null;
    }

    public static long getLongFromString(String dateTime){
        StringBuffer buffer = new StringBuffer();
        char[] charArray = dateTime.toCharArray();
        for (int i = 0; i < charArray.length; i ++) {
            if (Character.isDigit(charArray[i])) {
                buffer.append(charArray[i]);
            }
        }
        dateTime = buffer.toString();
        buffer = null;
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("yyyyMMdd").parse(dateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.getTimeInMillis();
    }
}
