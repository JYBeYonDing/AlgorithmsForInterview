
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }
        for (int sandwich : sandwiches) {
            if (count[sandwich] == 0) {
                return count[0] + count[1];
            }
            count[sandwich]--;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
