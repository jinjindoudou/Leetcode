package Tree;


/**
 * Created by linna on 2017/6/22.
 *
 * Difficulty:Easy
 * Tag:Tree
 * 学习了从底向上的递归
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.

 For this problem,a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
//        第一次编写，错误，不能考虑到[1,2,2,3,3,null,null,4,4]的情况。
//        if ( root == null)
//            return true;
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//        if ( left != null && ( left.left!=null || left.right != null) &&  right == null)
//            return false;
//        if ( right != null && ( right.left != null || right.right != null) &&  left == null)
//            return false;
//        return isBalanced(left) && isBalanced(right);
//      第二次编写，正确，但是，增加了一个获得子树的深度的函数，时间复杂度较高
        if ( root == null)
            return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftNumber = depth(left);
        int rightNumber = depth(right);
        if (Math.abs(leftNumber-rightNumber)>=2)
            return false;
        return isBalanced(left)&&isBalanced(right);
    }
    public int depth(TreeNode root) {
        int number = 0;
        if (root==null)
            return number;
        number += 1;
        number += Math.max(depth(root.left),depth(root.right));
        return number;
    }
//    第三种方法：其他人的方法，速度最快的方法，使用了helper函数，从思想上帮助计算结点的高度和左右子节点的高度差值
//    public boolean isBalanced(TreeNode root) {
//        return helper(root) != -1;
//    }
//    public int helper(TreeNode root){
//        if (root == null){
//            return 0;
//        }
//        int left = helper(root.left);
//        int right = helper(root.right);
//
//        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
//            return -1;
//        }
//        return Math.max(left, right) + 1;
//    }
    public static void main(String[] args) {
        int intValue;
        String strValue;
        boolean boolValue;
        TreeNode left = new TreeNode(2);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(6);
        TreeNode left3 = new TreeNode(5);
        left.left = left2;
        left.right = right2;
        left2.left = left3;
        TreeNode right = new TreeNode(3);
        TreeNode root =new TreeNode(1) ;
        root.left = left;
        root.right = right;
        TreeNode emptyTree = null;
        BalancedBinaryTree solution = new BalancedBinaryTree();
        boolValue=solution.isBalanced(root);
        System.out.println( boolValue);

    }
}
