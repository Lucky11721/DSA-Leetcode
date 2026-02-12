class NumArray {
    int[] segmentTree;
    int n;
    public NumArray(int[] nums) {
         n  = nums.length;
        segmentTree = new int[4*n];
        buildTree(nums , 0 , 0 , n-1);
    }
    
    public int sumRange(int left, int right) {
        return query(left , right , 0 , 0 , n-1);
    }

    public int query(int start , int end , int idx , int i , int j){
        if(i > end || j < start) return 0;
        if(i >= start && j <= end){
            return segmentTree[idx];
        }
        int mid = i + (j-i)/2;
        return query(start , end , 2*idx+1 , i , mid) + query(start , end , 2*idx+2 , mid+1 , j);
    }


    public void buildTree(int[] nums , int idx , int left , int right){
        if(left == right){
            segmentTree[idx] = nums[left];
            return;
        }
        int mid = left + (right - left)/2;
        buildTree(nums , 2 *idx +1 , left , mid);
        buildTree(nums , 2  * idx +2 , mid + 1 , right);
        segmentTree[idx] = segmentTree[2*idx+1] + segmentTree[2*idx+2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */