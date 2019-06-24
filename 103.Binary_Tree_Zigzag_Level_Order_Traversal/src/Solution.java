/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
       
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        
        int size = deque.size();
        int level = 1;
        
        while(size > 0){
            // odd level
            if(level%2 == 1){
                List<Integer> list = new ArrayList<>();
                for(int i = 0; i < size; i++){
                    TreeNode node = deque.pollLast();
                    list.add(node.val);
                    if(node.left != null) deque.offerFirst(node.left);
                    
                    if(node.right != null) deque.offerFirst(node.right);
                
                    
                }
                result.add(list);
                
            }
            // even level
            if(level%2 == 0){
                List<Integer> list = new ArrayList<>();
                for(int i = 0; i < size; i++){
                    TreeNode node = deque.pollFirst();
                    list.add(node.val);
                    if(node.right != null) deque.offerLast(node.right);
                    if(node.left != null) deque.offerLast(node.left);
                    
                }
                result.add(list);
            }
            size = deque.size();
            level++;
           
        }
        return result;
    }
}