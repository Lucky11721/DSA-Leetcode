class Solution {
    public int concatenatedBinary(int n) {

        int MOD = (int)1e9+7;

        int num = 0;
StringBuilder s = new StringBuilder();

s.append('1');

for (int i = 2; i <= n; i++) {

    int temp = i;
    StringBuilder sb = new StringBuilder();

    while (temp > 0) {
        int bit = temp & 1;
        sb.append(bit);
        temp >>= 1;
    }

    sb.reverse();
    s.append(sb);
}

int ans = 0;

for (char c : s.toString().toCharArray()) {
    ans = (ans * 2 + (c - '0')) %MOD;
}

    

        return ans% MOD;
    }
}