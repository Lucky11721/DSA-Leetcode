class Solution {
    public void reverseString(char[] arr) {
        int n = arr.length;

        int i = 0;
        int j = n - 1;

        while (i < j) {

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }
}