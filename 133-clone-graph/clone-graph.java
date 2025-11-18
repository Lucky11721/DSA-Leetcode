/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node newNode = new Node(node.val);
        map.put(node , newNode);

        Queue<Node> que = new LinkedList<>();
        que.add(node);
        while(que.isEmpty() == false){

            Node old = que.remove();

            for(Node neigh : old.neighbors){
                if(map.get(neigh) == null){
                    Node clone = new Node(neigh.val);
                    map.put(neigh , clone);
                    que.add(neigh);
                    map.get(old).neighbors.add(clone);
                }
                else{
                    map.get(old).neighbors.add(map.get(neigh));
                }
            }
        }

        return newNode;
    }
}