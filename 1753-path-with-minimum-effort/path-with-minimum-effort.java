class Solution {
    class Triplet{
        int row;
        int col;
        int effort;

        Triplet(int row  ,int col , int effort){
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

       
    }
    public int minimumEffortPath(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int ans[][] =  new int[m][n];

        for(int i = 0 ; i < m ; i++){
            Arrays.fill(ans[i] , Integer.MAX_VALUE);
        }

        PriorityQueue<Triplet> minHeap = new PriorityQueue<>((a, b) -> {
            if(a.effort == b.effort){
                return Integer.compare(a.row , b.row);
            }
            else{
                return Integer.compare(a.effort , b.effort);
            }
        });
        minHeap.add(new Triplet(0 , 0 , 0));
        ans[0][0] = 0;
        int[] dx = {-1 , 0 ,1 , 0};
        int[] dy = {0 , -1 , 0 ,1};
        while(minHeap.isEmpty() == false){
            Triplet top = minHeap.remove();

            int row = top.row;
            int col = top.col;
            int effort = top.effort;
            if(row == m-1 && col == n-1 && effort > ans[m-1][n-1]){
                break;
            }
    
            for(int i = 0 ; i < 4 ; i++){
                int newRow = row + dx[i];
                int newCol = col + dy[i];

                if(newRow >= 0 &&  newCol >= 0 && newRow < m && newCol < n){
                    int curr_effort = Math.abs(arr[row][col] - arr[newRow][newCol]);
                    int max_effort = Math.max(effort , curr_effort);
                    if(max_effort < ans[newRow][newCol]){
                        ans[newRow][newCol] = max_effort;
                        minHeap.add( new Triplet(newRow , newCol , max_effort));
                    }
                }
            }
            
        }

        for(int i = 0  ; i < m ; i++){
            System.out.println(Arrays.toString(ans[i]));
        }

        return ans[m-1][n-1];

    }
}