package 练习;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

/**
 * Created by 杨杰 on 2018/4/12 10:23.
 */
public class Test {
    public static void main(String[] args) {
        Generic<Integer> genericInt = new Generic<>();
        genericInt.value=1;
        Generic<String> genericStr = new Generic<>();
        genericStr.value=2;
        System.out.println(genericInt.value);
    }

}
class Generic<T>{
    public static int value =0;
}