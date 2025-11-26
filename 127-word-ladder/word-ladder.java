class Solution {
    class Pair{
        String word;
        int steps;
        Pair(String word , int steps){
            this.word = word;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();

        Set<String> set = new HashSet<>();
        for(int i =  0 ; i < wordList.size() ; i++){
            set.add(wordList.get(i));
        }

        Queue<Pair> que = new LinkedList<>();

        que.add(new Pair(beginWord , 1));

        while(que.isEmpty() == false){
            Pair  p = que.remove();
            String word = p.word;
            int steps = p.steps;

            if(word.equals(endWord)) return steps;

            for(int i = 0 ; i < word.length() ; i++){
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    char[] toBeReplaced = word.toCharArray();
                    toBeReplaced[i] = ch;

                    String replaced = new String(toBeReplaced);
                    if(set.contains(replaced)){
                        que.add(new Pair(replaced , steps + 1));
                        set.remove(replaced);
                    }
                }
            }
        }

        return 0;
    }
}