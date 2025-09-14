class Solution {
    HashSet<String> exact_set = new HashSet<>();
    HashMap<String , String> case_error = new HashMap<>();
    HashMap<String , String> vowel_error = new HashMap<>();
    List<String> ans  = new ArrayList<>();

    public String[] spellchecker(String[] wordlist, String[] queries) {
        for(String str : wordlist){
            exact_set.add(str);
        }
         for(String str : wordlist){
            String lower = str.toLowerCase();
            if(case_error.containsKey(lower) == false){
                case_error.put(lower , str);
            }
        }
         for(String str : wordlist){
            String lower = str.toLowerCase();
            char[] ch = lower.toCharArray();
            for(int i = 0 ; i < ch.length ; i++){
                if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u'){
                    ch[i] = '*';
                }
            }
            String vowel = String.valueOf(ch);
            if(vowel_error.containsKey(vowel) == false){
                vowel_error.put(vowel , str);
            }
        }
     System.out.println("Contents of exact_set:");
        for (String word : exact_set) {
            System.out.println(word);
        }

        // Print case_error map
        System.out.println("\nContents of case_error:");
        for (String key : case_error.keySet()) {
            System.out.println(key + " -> " + case_error.get(key));
        }

        // Print vowel_error map
        System.out.println("\nContents of vowel_error:");
        for (String key : vowel_error.keySet()) {
            System.out.println(key + " -> " + vowel_error.get(key));
        }
        for(int i = 0 ;  i < queries.length ; i++){
            String lower = queries[i].toLowerCase();
            char[] ch = lower.toCharArray();
            for(int j = 0 ; j < ch.length ; j++){
                if(ch[j] == 'a' || ch[j] == 'e' || ch[j] == 'i' || ch[j] == 'o' || ch[j] == 'u'){
                    ch[j] = '*';
                }
            }
            String vowel = String.valueOf(ch);
             if(exact_match(queries[i])){
                ans.add(queries[i]);
             }
             else if(case_solve(lower)){
                ans.add(case_error.get(lower));
             }
             else if(vowel_solve(vowel)){
                ans.add(vowel_error.get(vowel));
             }
             else{
                ans.add("");
             }
        }
        
             int size = ans.size();
             String[] final_ans = new String[size];
             
             for(int  i = 0 ; i < size ; i++){
                final_ans[i] = ans.get(i);
             }

             return final_ans;
    }

    public boolean exact_match(String str){
        if(exact_set.contains(str)){
            return true;
        }

        return false;
    }

    public boolean case_solve(String str){
        if(case_error.containsKey(str)){
            return true;
        }
        return false;
    }

    public boolean vowel_solve(String str){
        if(vowel_error.containsKey(str)){
            return true;
        }
        return false;
    }
}