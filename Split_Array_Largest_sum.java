class Solution {
    public int splitArray(int[] nums, int k) {
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        int low = max;
        int high = sum;
        while(low <= high) {
            int mid = (low + high) / 2;
            int partitions = count_Partition(nums, mid);
            if(partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
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
