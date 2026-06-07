/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer , TreeNode> map = new HashMap<>();

        HashSet<Integer> notParent = new HashSet<>();

        for(int[] nodes : descriptions){
            int parent = nodes[0];
            int child = nodes[1];
            int dir = nodes[2];

           if(!map.containsKey(parent)){
        map.put(parent, new TreeNode(parent));
    }

    if(!map.containsKey(child)){
        map.put(child, new TreeNode(child));
    }

    TreeNode parentNode = map.get(parent);
    TreeNode childNode = map.get(child);

    if(dir == 1){
        parentNode.left = childNode;
    }else{
        parentNode.right = childNode;
    }

    notParent.add(child);

        }

         for (Map.Entry<Integer,TreeNode> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
          System.out.println(notParent); 

        
        
        int rootVal = -1;
        for(int[] nodes : descriptions){
            if(notParent.contains(nodes[0]) == false){
                rootVal = nodes[0];
                break;
            }
        }

        System.out.println(rootVal);
    

       return map.get(rootVal);
        
    }
}