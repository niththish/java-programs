package leetcode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}


public class BinaryTreeTraversal {

    /*-----------------------Inorder Tracersal----------------------------------*/
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }

        if(root.left != null){
            inorderTraversal(root.left);
        }

        list.add(root.val);

        if(root.right != null){
            inorderTraversal(root.right);
        }

        return list;
    }
    /*-----------------------End of Inorder Tracersal----------------------------------*/


    /*-----------------------Preorder Tracersal----------------------------------*/
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }

        result.add(root.val);

        if(root.left != null){
            preorderTraversal(root.left);
        }

        if(root.right != null){
            preorderTraversal(root.right);
        }

        return result;
    }
    /*-----------------------End of preorder Tracersal----------------------------------*/
}
