class Solution {
    class Pair{
        char ch;
        int count;
        Pair(char ch , int count){
            this.ch = ch;
            this.count = count;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        char chara = 'a';
        char charb = 'b';
        char charc = 'c';

        PriorityQueue<Pair> maxheap = new PriorityQueue<>((x,y) -> Integer.compare(y.count , x.count));
       if(a > 0) maxheap.add(new Pair(chara , a));
        if(b > 0)maxheap.add(new Pair(charb , b));
       if(c > 0) maxheap.add(new Pair(charc , c));

        StringBuilder sb = new StringBuilder();

        while(!maxheap.isEmpty()){
        Pair p1 = maxheap.poll();
        int n = sb.length();
        if(sb.length() >= 2 && sb.charAt(n-1) == p1.ch && sb.charAt(n-2) == p1.ch){
            if(maxheap.isEmpty()) break;
            Pair p2 = maxheap.poll();
            sb.append(p2.ch);
            p2.count  = p2.count -1;
            if(p2.count > 0) maxheap.add(p2);
            if(p1.count > 0) maxheap.add(p1);
        }
        else{
            sb.append(p1.ch);
            p1.count = p1.count-1;
            if(p1.count > 0) maxheap.add(p1);
        }
        }
        return sb.toString();
    }
}