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
        Object a=1;
        System.out.println('b'+21);
        Arrays.binarySearch(args, a);
        List<Object> aff = null;
        List<String> af = null;

        double v = Math.log10(10)/Math.log10(2);
        List<?>[] lists = new ArrayList<?>[10];

    }
    public int hammingWeight(int n) {
        int num=((1&n)==1)?1:0;
        for(int i=1;i<32;i++){
            if((1&(n>>>=1))==0){
                num++;
            }
        }
        return num;
    }

    public void selector() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Selector selector = Selector.open();//调用 Selector 的静态工厂创建一个选择器
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);//设置为非阻塞方式
        ssc.socket().bind(new InetSocketAddress(8080));
        ssc.register(selector, SelectionKey.OP_ACCEPT);//注册监听的事件
        while (true) {
            Set selectedKeys = selector.selectedKeys();//取得所有key集合
            Iterator it = selectedKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                    ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssChannel.accept();//接受到服务端的请求
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    it.remove();
                } else if
                        ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    while (true) {
                        buffer.clear();
                        int n = sc.read(buffer);//读取数据
                        if (n <= 0) {
                            break;
                        }
                        buffer.flip();
                    }
                    it.remove();
                }
            }
        }
    }
}
class Outer{
    private int a = 0;
    class Inner{
        int b = a+3;
        int fff(){
            int c = 0;
            return b+c;
        }
    }
}