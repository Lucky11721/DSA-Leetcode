/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int n = arr.length();

        int left = 1;
        int right = n-2;
        int peak = 0;
        while(left <= right){
            int mid = left +(right - left)/2;

            int left_ele = arr.get(mid-1);
            int middle = arr.get(mid);
            int right_ele = arr.get(mid +1);

            if(left_ele < middle && middle > right_ele){
                peak = mid;
                break;
            }
            else if(left_ele < middle && middle < right_ele){
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }
        System.out.println(peak);

        // search left part
        int a = 0;
        int b = peak;

        while(a <= b){
            int mid = a +(b-a)/2;

            if(arr.get(mid) == target){
                return mid;
            }
            else if(arr.get(mid) > target){
                b =mid -1;
            }
            else{
                a = mid +1;
            }
        }
        // right part
        int x = peak +1;
        int y = n-1;

        while(x <= y){
            int mid = x +(y-x)/2;

            if(arr.get(mid) == target){
                return mid;
            }
            else if(arr.get(mid) < target){
                y = mid -1;
            }
            else{
                x = mid +1;
            }
        }

        return -1;
    }
}