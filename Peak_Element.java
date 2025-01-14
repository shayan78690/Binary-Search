import java.util.ArrayList;
public class Solution {
    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size();
        for(int i = 0; i < n; i++) {
            if((i == 0 || arr.get(i-1) < arr.get(i)) && (i == n-1 || arr.get(i) > arr.get(i+1))) {
                return i;
            }
        }
        return -1;
    }
};
