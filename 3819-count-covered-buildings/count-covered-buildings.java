class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, List<Integer>> horizontal = new HashMap<>();
        HashMap<Integer, List<Integer>> vertical = new HashMap<>();

        for (int[] arr : buildings) {
            int x = arr[0];
            int y = arr[1];

            if (!horizontal.containsKey(x)) {
                horizontal.put(x, new ArrayList<>());
            }
            horizontal.get(x).add(y);

            if (!vertical.containsKey(y)) {
                vertical.put(y, new ArrayList<>());
            }
            vertical.get(y).add(x);

        }

          for (List<Integer> list : horizontal.values()) {
            Collections.sort(list);
        }
        for (List<Integer> list : vertical.values()) {
            Collections.sort(list);
        }
        int ans = 0;

        for(int[] arr : buildings){
            int a  = arr[0];
            int b = arr[1];
            if(horizontal.containsKey(a) && vertical.containsKey(b)){
                List<Integer> list1 = horizontal.get(a);
                 List<Integer> list2 = vertical.get(b);
                
                if(list1.size() >= 3 && list2.size() >= 3 ){
                   int minY = list1.get(0);
                   int maxY = list1.get(list1.size() -1);

                   int minX = list2.get(0);
                   int maxX = list2.get(list2.size() -1);
                   if(a > minX && a < maxX && b > minY && b < maxY){
                    ans++;
                   }
                }
            }
        }
        return ans;
    }
}