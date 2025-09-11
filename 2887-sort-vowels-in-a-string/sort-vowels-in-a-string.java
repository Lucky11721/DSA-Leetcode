class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        List<Character> list = new ArrayList<>();
        for(char ch : arr){
            if(ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I'
            || ch == 'i' || ch == 'O' || ch == 'o' || ch == 'U' || ch == 'u'){
                list.add(ch);
            }
        }
        Collections.sort(list);
        System.out.println(list);
        int index = 0;
        for(int  i = 0 ; i <  n ;i++){
            if(arr[i] == 'A' || arr[i] == 'a' || arr[i] == 'E' || arr[i] == 'e' || arr[i] == 'I'
            || arr[i] == 'i' || arr[i] == 'O' || arr[i] == 'o' || arr[i] == 'U' || arr[i] == 'u'){
               arr[i] = list.get(index);
               index++;
            }
        }
        System.out.println(Arrays.toString(arr));

        return new String(arr);
    }
}