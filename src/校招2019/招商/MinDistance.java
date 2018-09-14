package 校招2019.招商;

import java.util.*;

public class MinDistance {
    static class VNode{
        int index;
        int distance;
        int cost;
        public VNode(int index, int distance, int cost) {
            super();
            this.index = index;
            this.distance = distance;
            this.cost = cost;
        }

    }

    public static void main(String[] args) {
        Map<Integer,List<VNode>> graph = new HashMap<Integer,List<VNode>>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (m == 0 && n == 0) {
                break;
            }
            for(int i=1;i<=n;i++){
                graph.put(i,new LinkedList<VNode>());
            }

            int v1,v2,distance,cost;
            for(int i=0;i<m;i++){
                v1 = scanner.nextInt();
                v2 = scanner.nextInt();
                distance = scanner.nextInt();
                cost = scanner.nextInt();
                graph.get(v1).add(new VNode(v2,distance,cost));
                graph.get(v2).add(new VNode(v1,distance,cost));
            }
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if(start==0&&end==0)
                break;
//            ___________【2】__________;

            calc(start, end, n, graph);
        }
    }

    public  static void calc(int start ,int end ,int n,Map<Integer,List<VNode>> graph){
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int[] values = new int[n+1];
        Arrays.fill(values,Integer.MAX_VALUE);
        distance[start] = 0;
        values[start] = 0;
        Set<Integer> open = new HashSet<Integer>();
        Set<Integer> close = new HashSet<Integer>();
        for(int i=1;i<=n;i++){
            open.add(i);
        }
        while(!open.isEmpty()){
            int minDistance = Integer.MAX_VALUE;
            int u = 0;
            for(int index: open){
                if(minDistance>distance[index]){
                    minDistance = distance[index];

                    u += 1;

                }
            }
            if(u==end)
            {
                System.out.println(distance[end]+" "+values[end]);
                return;
            }
            close.add(u);
            open.remove(u);
            for(VNode node:graph.get(u)){
                int vextice = node.index;
                if( distance[vextice]>distance[u]+node.distance ){
                    distance[vextice] = distance[u]+node.distance;
                    values[vextice] = Math.min(values[vextice], values[u] + node.cost);
                }else if(distance[vextice]==distance[u]+node.distance){
                    values[vextice] = Math.min(values[vextice], values[u]+node.cost);
                }
            }
        }
    }
}