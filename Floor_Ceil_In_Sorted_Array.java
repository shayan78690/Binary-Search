class Solution {
    
    public int floor(int x, int arr[]) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high) / 2;
            if(arr[mid] <= x) {
                ans = arr[mid];
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return ans;
    }
    
    public int ceil(int x, int arr[]) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high) / 2;
            if(arr[mid] >= x) {
                ans = arr[mid];
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return ans;
    }
    
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int floor = floor(x, arr);
        int ceil = ceil(x, arr);
        int ans[] = {floor, ceil};
        return ans;
    }
}
