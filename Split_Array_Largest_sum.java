class Solution {
    public int splitArray(int[] nums, int k) {
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        for(int i = max; i <= sum; i++) {
            if(count_Partition(nums, i) == k) {
                return i;
            }
        }
        return max;
    }
    public int count_Partition(int nums[], int max_sum) {
        int partition = 1;
        int subarray_sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(subarray_sum + nums[i] <= max_sum) {
                subarray_sum += nums[i];
            } else {
                partition++;
                subarray_sum = nums[i];
            }
        }
        return partition;
    }
}
