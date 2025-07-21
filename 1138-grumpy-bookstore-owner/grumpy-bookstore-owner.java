class Solution {
    public int maxSatisfied(int[] arr, int[] grumpy, int minutes) {
        int n = arr.length;

        int maxunsat = 0;
        
        int i = 0;
        int j = minutes - 1;
        int curr_unsat = 0;
        for (int x = 0; x <= j; x++) {
            if (grumpy[x] == 1) {
                curr_unsat += arr[x];
            }
        }
        int a = 0;
        int b = 0;
        while (j < n) {
            if (curr_unsat > maxunsat) {
                maxunsat = curr_unsat;
                a = i;
                b = j;
            }

            i++;
            j++;

            if (j < n && grumpy[j] == 1)
                curr_unsat += arr[j];
            if (grumpy[i - 1] == 1)
                curr_unsat -= arr[i - 1];
        }

        for (int x = a; x <= b; x++) {
            grumpy[x] = 0;
        }

        int ans = 0;

        for (int x = 0; x < n; x++) {
            if (grumpy[x] == 0) {
                ans += arr[x];
            }
        }
        return ans;
    }
}