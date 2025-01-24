import java.util.ArrayList;

public class Solution {
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int n = boards.size();
        int max = Integer.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, boards.get(i));
            sum += boards.get(i);
        }

        int low = max;
        long high = sum;

        while (low <= high) {
            int mid = (int)((low + high) / 2);
            if (count_Painters(boards, mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int count_Painters(ArrayList<Integer> boards, int time) {
        int painters = 1;
        long board_painters = 0;

        for (int i = 0; i < boards.size(); i++) {
            if (board_painters + boards.get(i) <= time) {
                board_painters += boards.get(i);
            } else {
                painters++;
                board_painters = boards.get(i);
            }
        }
        return painters;
    }
}
