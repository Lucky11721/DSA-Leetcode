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
        dfs(node , newNode , map);
        return newNode;
    }

    public void dfs(Node old ,  Node newNode , HashMap<Node , Node> map){

        for(Node neigh : old.neighbors){

            if(map.get(neigh) == null){
                Node clone = new Node(neigh.val);
                map.put(neigh , clone);
                newNode.neighbors.add(clone);
                dfs(neigh , clone , map);
            }
            else{
                newNode.neighbors.add(map.get(neigh));
            }
        }
    }
}