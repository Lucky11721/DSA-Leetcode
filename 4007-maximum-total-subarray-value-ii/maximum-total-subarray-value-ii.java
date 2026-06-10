class Solution {
    int[] minSegmentTree;
    int[] maxSegmentTree;
    int N;
    public long maxTotalValue(int[] nums, int k) {
        
        int n = nums.length;
        minSegmentTree = new int[n*4];
        maxSegmentTree = new int[n*4];
        Arrays.fill(minSegmentTree , Integer.MAX_VALUE);
        N=n;
        buildMaxTree(nums , 0 , n-1 , 0);
        buildMinTree(nums , 0 , n-1 , 0);

     //   System.out.println(Arrays.toString(maxSegmentTree));
       //  System.out.println(Arrays.toString(minSegmentTree));
PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

for(int i = 0; i < n; i++) {
    int max = queryMaxTree(i, n - 1, 0, 0, n - 1);
    int min = queryMinTree(i, n - 1, 0, 0, n - 1);

    int[] subArray = {max - min, i, n - 1};
    maxHeap.add(subArray);
}

   // System.out.println(maxHeap.peek()[0]);
long ans = 0;

while(k-- > 0){
    int[] arr = maxHeap.remove();
    ans += arr[0];
     if(arr[1] >= arr[2]) {
        continue;
    }

     int max = queryMaxTree(arr[1],arr[2]-1 , 0, 0, n - 1);
    int min = queryMinTree(arr[1],arr[2]-1, 0, 0, n - 1);

    int[] subArray = {max - min, arr[1], arr[2]-1};
    maxHeap.add(subArray);


}

        return ans;

    }

    void buildMaxTree(int[] nums , int l , int r , int index){
        if(l == r) {
            maxSegmentTree[index] = nums[l]; 
            return;
        }

        int mid = l + (r-l)/2;

        buildMaxTree(nums , l , mid , index*2+1);
        buildMaxTree(nums , mid+1 , r , index*2+2);

        maxSegmentTree[index] = Math.max(maxSegmentTree[index*2+1] , maxSegmentTree[index*2+2]);
        

    }

     void buildMinTree(int[] nums , int l , int r , int index){
        if(l == r) {
            minSegmentTree[index] = nums[l]; 
            return;
        }

        int mid = l + (r-l)/2;

        buildMinTree(nums , l , mid , index*2+1);
        buildMinTree(nums , mid+1 , r , index*2+2);

        minSegmentTree[index] = Math.min(minSegmentTree[index*2+1] , minSegmentTree[index*2+2]);
        

    }


    int queryMinTree(int start , int end , int index , int l , int r){
        if(l > end || r < start) return Integer.MAX_VALUE;

        if(l >= start && r <= end){
            return minSegmentTree[index];
        }

        int mid = l + (r-l)/2;
        return Math.min(queryMinTree(start , end , index*2+1 , l , mid),
        queryMinTree(start , end , index*2+2,mid+1 , r));
    }

    
    int queryMaxTree(int start , int end , int index , int l , int r){
        if(l > end || r < start) return Integer.MIN_VALUE;

        if(l >= start && r <= end){
            return maxSegmentTree[index];
        }

        int mid = l + (r-l)/2;
        return Math.max(queryMaxTree(start , end , index*2+1 , l , mid),
        queryMaxTree(start , end , index*2+2,mid+1 , r));
    }
}