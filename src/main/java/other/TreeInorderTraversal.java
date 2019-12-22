package other;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeInorderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public static void main(String[] args) {
        
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        recInorderTraversal(root, traversal);
        
        return traversal;
  }
    
    public void recInorderTraversal(TreeNode root, List<Integer> traversal) {
        if (root == null)
            return;
        recInorderTraversal(root.left, traversal);
        traversal.add(root.val);
        recInorderTraversal(root.right, traversal);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        
        Deque<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            if (stack.isEmpty())
                break;
            
            root = stack.pop();
            traversal.add(root.val);
            
            root = root.right;
        }
        
        return traversal;
  }
}
