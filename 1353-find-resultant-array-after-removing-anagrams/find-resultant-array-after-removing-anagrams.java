class Solution {
    public List<String> removeAnagrams(String[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 1;
        while(j < n){
            if(check_anagram(arr , i , j)){
                arr[j] = " ";
            }
            else{
                i = j;
            }
            j++;

        }
        System.out.println(Arrays.toString(arr));
        List<String> list = new ArrayList<>();

        for(int x = 0; x  < n ; x++){
            if (!arr[x].equals(" ")) {
                list.add(arr[x]);
            }
        }

        return list;

    }

    public boolean check_anagram(String[] arr , int i , int j ){
        
        char[] a = arr[i].toCharArray();
        char[] b = arr[j].toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        int m = b.length;

        if(n != m) return false;
        int x = 0;
        int y = 0;

        while(x < a.length && y < b.length){
            if(a[x] != b[y]){
                return false;
            }
            x++;
            y++;
        }

        return true;


    }
}