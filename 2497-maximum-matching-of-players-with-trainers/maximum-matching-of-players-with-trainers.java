class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int m = players.length;
        int n = trainers.length;

        Arrays.sort(players);
        Arrays.sort(trainers);
        int l = 0;
        int r = 0;
        while(l < m && r < n){
            if(trainers[r] >= players[l]){
                l++;
            }
            r++;
        }

        return l;
    }
}