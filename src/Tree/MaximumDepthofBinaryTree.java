package Tree;

/**
 * Created by linna on 2017/6/18.
 */
    /*
        104. Maximum Depth of Binary Tree

        Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */
public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
//        方法一：自己写的，运行时间最长
//        int left=1+maxDepth(root.left);
//        int right=1+maxDepth(root.right);
//        if (left > right)
//            return left;
//        else
//           return right;

//         方法二：直接使用max函数，时间有提高
//        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));

//        方法三：使用三元问号式，效率最高
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return (left > right) ? left+1:right+1 ;

    }

    public static void main(String[] args) {
        int intValue;
        String strValue;
        boolean boolValue;
        TreeNode left= new TreeNode(2);
        TreeNode left2= new TreeNode(4);
        left.left=left2;
        TreeNode right= new TreeNode(3);
        TreeNode root=new TreeNode(1) ;
        root.left=left;
        root.right=right;
        TreeNode emptyTree=null;
        MaximumDepthofBinaryTree solution=new MaximumDepthofBinaryTree();
        intValue=solution.maxDepth(left);
        System.out.println( intValue);
    }
}
