class Solution {
    public List<Integer> replaceNonCoprimes(int[] arr) {
        List<Integer> ans  = new ArrayList<>();

        int n = arr.length;
        ans.add(arr[0]);
        for(int  i = 1 ; i < n ; i++){
            int ele = arr[i];

            while(ans.isEmpty() == false && !coPrime(ele , ans.get(ans.size() -1)) ){
                     int a = ans.remove(ans.size()-1);
                     int b  = ele;
                      ele = (LCM(a,b));
            }

            ans.add(ele);

            
        }
   return ans;

    }

    public boolean coPrime(int a , int b){
        if(HCF(a,b) == 1) return true;
        return false;
    }

    public int HCF(int a , int b){
       while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int LCM(int a , int b){
        return a /HCF(a,b) * b;
    }
}