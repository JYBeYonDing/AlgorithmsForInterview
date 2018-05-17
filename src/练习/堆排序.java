package 练习;

/**
 * Created by 杨杰 on 2018/4/12 16:41.
 * 完成 17:15
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 2, 9, 0, 6, 8, 0, 4, 6, 3};
        heapSort(nums);
        for (int i : nums) {
            System.out.print(i +" ");
        }
    }

    private static void heapSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for(int i = 1 ; i<nums.length ; i++) {
            insertHeap(nums, i);
        }
        for (int i : nums) {
            System.out.print(i +" ");
        }
        System.out.println();
        int size = nums.length;
        while (size > 0) {
            swap(nums, 0, --size);
            heapfy(nums, 0, size);
        }
    }

    private static void heapfy(int[] nums, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = (left + 1) < size && (nums[left + 1] > nums[left]) ? left + 1 : left;
            largest = (nums[largest] > nums[index]) ? largest : index;
            if (largest == index) {
                break;
            }
            swap(nums, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private static void insertHeap(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


//    private static void heapSort(int[] nums) {
//        if (nums == null || nums.length < 2) {
//            return;
//        }
//
//        for(int i = 0 ; i<nums.length; i++) {
//            heapInsert(nums, i);
//        }
//
//        int size = nums.length;
//        while (size > 0) {
//            heapify(nums, size--);
//        }
//    }
//
//    private static void heapify(int[] nums, int size) {
//        swap(nums, 0, size-1);
//        size = size - 1;
//        int index = 0;
//        int left = index * 2 + 1;
//        while (left < size) {//有左节点
//            int max = ((left+1)<size)&&nums[left] < nums[left+1] ? left+1 : left;
//            max = nums[max] > nums[index] ? max : index;
//            if (max == index) {
//                return;
//            }
//            swap(nums, max, index);
//            index = max;
//            left = 2 * index + 1;
//        }
//    }
//
//    private static void heapInsert(int[] nums, int i) {
////        int parent = (i - 1) >> 1;
////        while (parent >= 0) {
////            if (nums[i] > nums[parent]) {
////                swap(nums, i, parent);
////                i = parent;
////                parent = (i - 1) >> 1;
////            } else {
////                return;
////            }
////        }
//
//        // i = 0 时 (i-1)/2 = 0 ; 也会推出循环
//        while (nums[i] > nums[(i - 1) / 2]) {
//            swap(nums, i, (i - 1) / 2);
//            i = (i - 1) / 2;
//        }
//    }
//
//    private static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
}
