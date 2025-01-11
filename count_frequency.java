class Solution {
    
    int firstOccurence(int arr[], int x) {
        int n = arr.length;
        int first = -1;
        int low = 0;
        int high = n-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] == x) {
                first = mid;
                high = mid-1;
            } else if(arr[mid] < x) {
                low = mid+1;
            }  else{
                high = mid-1;
            }
        }
        return first;
    }
    
    int lastOccurence(int arr[], int x) {
        int n = arr.length;
        int last = -1;
        int low = 0;
        int high = n-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] == x) {
                last = mid;
                low = mid+1;
            } else if(arr[mid] < x) {
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return last;
    }
    
    int[] firstAndLastPosition(int arr[], int x) {
        int first = firstOccurence(arr, x);
        if (first == -1) {
            return new int[] {-1, -1};
        }
        int last = lastOccurence(arr, x);
        
        return new int[] {first, last};
    }
    int countFreq(int[] arr, int target) {
        int ans[] = firstAndLastPosition(arr, target);
        if(ans[0] == -1) {
            return 0;
        } 
        return (ans[1] - ans[0] + 1);
    }
}
