class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        if(threshold < nums.length) {
            return -1;
        }
        int low = 1;
        int high = max;
        while(low <= high) {
            int mid = (low + high) / 2;
            int sum = sum_by_D(nums, mid);
            if(sum <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int sum_by_D(int nums[], int div) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += Math.ceil((double)(nums[i]) / (double)(div));
        }
        return sum;
    }
}
