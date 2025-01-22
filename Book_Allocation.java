import java.util.ArrayList;
public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(m > n) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, arr.get(i));
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr.get(i);
        }
        int low = max;
        int high = sum;
        while(low <= high) {
            int mid = (low + high) / 2;
            int no_of_students = count_Students(arr, mid);
            if(no_of_students > m) {
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return low;
    }
    public static int count_Students(ArrayList<Integer> arr, int pages) {
        int n = arr.size();
        int no_of_students = 1;
        long pages_Student = 0;
        for(int i = 0; i < n; i++) {
            if(pages_Student + arr.get(i) <= pages) {
                pages_Student += arr.get(i);
            } else {
                no_of_students++;
                pages_Student = arr.get(i);
            }
        }
        return no_of_students;
    }
}
