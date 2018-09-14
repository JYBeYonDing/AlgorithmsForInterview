package 校招2019.招商;

/**
 * Created by James on 2018/9/8 11:24.
 */
public class Main {
}
/**
 * 订单
 */
class Order {
    public String custName;// 客户名
    public Order(String custName) {
        this.custName = custName;
    }
}

class CustSort {
    public Order[] flow; // 记录订单流水
    public int total; // 总客户数
    public int current; // 当前订单

    public CustSort(int total) {
        this.total = total;
        current = 0;
        flow = new Order[total];
    }

    /**
     * 生成订单
     * @param custName
     */
    public boolean createOrder(String custName) {
        Order newOrder = new Order(custName);
        flow[current] = newOrder;
        moveUp(current);
        return true;
    }

    /**
     * 向上调整，使各节点的值不大于其双亲节点
     * @param index
     */
    public void moveUp(int index) {
        int parent = (index - 1) / 2;
        Order bottom = flow[index];
        while (index > 0 && flow[parent].custName.compareTo(flow[index].custName) < 0) {
            flow[index] = flow[parent];
            index = parent;
            parent = (index - 1) / 2;
        }
        flow[index] = bottom;
    }

    /**
     * 获取并删除
     */
    public Order get() {
        Order root = flow[0];
        flow[0] = flow[current];
        moveDown(0);
        return root;
    }

    /**
     * 向下调整，是堆顶元素不小于子节点的值
     * @param index
     */
    public void moveDown(int index) {
        int largeChild;
        Order top = flow[index];
        while (index < current / 2) {
            int leftChild = 2* index + 1;
            int rightChild = leftChild + 1;
            if (rightChild < total
                    && flow[leftChild].custName.compareTo(flow[rightChild].custName) < 0) {
                largeChild = rightChild;
            } else {
                largeChild = leftChild;
            }
            if (top.custName.compareTo(flow[largeChild].custName) >= 0) {
                break;
            }
            flow[index] = flow[largeChild];
            index = largeChild;
        }
        flow[index] = top;
    }
}