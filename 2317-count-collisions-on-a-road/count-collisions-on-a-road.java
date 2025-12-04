class Solution {
    public int countCollisions(String directions) {

        char[] arr = directions.toCharArray();
        int n = arr.length;
        int prev = arr[0];
        int ans = 0;
        boolean isCollided = false;

        int left = 0;
        int i = 0 ; 
        while(i < n && arr[i] == 'L'){
            left++;
            i++;
        }

        int right = 0;
        int j = n-1;
        while(j >= 0 && arr[j] == 'R'){
            right++;
            j--;
        }


        System.out.println(left + "  " + right);
        int total = 0;
        for(int x = 0 ; x < n ;x++){
            if(arr[x] != 'S'){
                total++;
            }
        }



        return total - (left+ right);
        
    }
}