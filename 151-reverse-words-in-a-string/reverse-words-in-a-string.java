class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim the input string to remove leading and trailing spaces
        s = s.trim();
        
        // Step 2: Split the string into words using regex "\\s+"
        String[] words = s.split("\\s+");  // This creates a fixed-size array
        
        // Step 3: Reverse the array of words in place
        int left = 0, right = words.length - 1;
        while (left < right) {
            // Swap words at left and right indices
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        // Step 4: Join the reversed array into a single string
        return String.join(" ", words);
    }
}
