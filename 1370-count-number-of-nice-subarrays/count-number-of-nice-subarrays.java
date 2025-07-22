class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        int n = arr.length;
        int oddnum = 0;
        int i = 0;
        int j = 0;
        int a = 0;
        int b = 0;
        for(int x = 0; x < n ; x++){
            arr[x] = arr[x] %2;
            if(arr[x] == 1 ) oddnum++;
        }
        if(oddnum < k) return 0;
        int k2 = 0;
        while( i < n && arr[i] == 0) i++;
        while( j < n &&  k2 < k){
            if(arr[j] == 1) k2++;
            j++;
        }
        j--;

        b = j+1;
        while( b <  n && arr[b] == 0) b++;
        b--;
        int count = 0;
        while( b < n){
          count += (i - a +1) * (b - j +1);
          a= i+1;
          i++;
         while( i < n && arr[i] == 0) i++;
         j = b+1;
         b = j+1;
         while( b <  n && arr[b] == 0) b++;
         b--;

        }

        return count;
    }
}
