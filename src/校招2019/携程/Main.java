package 校招2019.携程;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by James on 2018/9/4 20:10.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = sc.nextInt();

        Main lru = new Main(n);

        ArrayList<Integer> res = new ArrayList<>();
        while (sc.hasNext()) {
            String[] strings = sc.nextLine().split(" ");
            if (strings[0].equals("p")) {
                lru.put(Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
            }
            if (strings[0].equals("g")) {
//                res.add(lru.get(Integer.parseInt(strings[1])));
                System.out.println(lru.get(Integer.parseInt(strings[1])));
            }

//            if (strings[0].equals("q")) {
//                break;
//            }
        }


//        for (int i : res) {
//            System.out.println(i);
//        }
    }



    class Node {
        Node pre;
        Node next;
        Integer key;
        Integer val;
        Node(Integer k, Integer v) {
            key = k;
            val = v;
        }
    }

    Map<Integer, Node> map = new HashMap<Integer, Node>();

    Node head;
    Node tail;
    int cap;
    public Main(int capacity) {
        cap = capacity;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }
    public int get(int key) {
        Node n = map.get(key);
        if(n!=null) {
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return n.val;
        }
        return -1;
    }
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n!=null) {
            n.val = value;
            map.put(key, n);
            return;
        }

        if(map.size() == cap) {
            Node tmp = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            map.remove(tmp.key);
        }

        n = new Node(key, value);

        appendTail(n);
        map.put(key, n);
    }

    private void appendTail(Node n) {
        n.next = tail;
        n.pre = tail.pre;
        tail.pre.next = n;
        tail.pre = n;
    }
}
