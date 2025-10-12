class Solution {
    public int xorOperation(int n, int start) {
        int[] arr = new int[n];

        arr[0] = start;
        for(int i = 1; i < n ; i++){
            arr[i] = start+2;
            start += 2;
        }
        System.out.println(Arrays.toString(arr));

        int xor = 0;

        for(int ele : arr){
            xor = xor^ ele;
        }

        return xor;
    }
}