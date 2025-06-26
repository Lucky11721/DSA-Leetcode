class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> Integer.compare(dist(a), dist(b)));
        int ans[][] = new int[k][2];
        int n = points.length;
        for(int i = 0 ; i < k ; i++){
          for(int j = 0; j < 2 ; j++){
            ans[i][j] = points[i][j];
          }
        }
        return ans;
    }
    public int dist(int[] arr){
        return arr[0]*arr[0] + arr[1]*arr[1];
    }
}