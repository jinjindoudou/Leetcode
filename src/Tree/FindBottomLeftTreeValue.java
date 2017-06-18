package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by linna on 2017/6/18.
 */
/*
    513. Find Bottom Left Tree Value
 */
public class FindBottomLeftTreeValue {

    // 方法一：利用队列
//    public int findBottomLeftValue(TreeNode root) {
//        int left=0,right=0;
//        Queue<TreeNode> queue=new LinkedList<TreeNode>();
//        queue.add(root);
//        while (!queue.isEmpty())
//        {
//            root=queue.poll();
//            if (root.right!=null)
//                queue.add(root.right);
//            if (root.left!=null)
//                queue.add(root.left);
//        }
//        return root.val;
//    }
    // 方法二：利用递归，效率最高，使用两个函数实现递归
    int ans=0, h=0;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ans;
    }
    public void findBottomLeftValue(TreeNode root, int depth) {
        if (h<depth) {ans=root.val;h=depth;}
        if (root.left!=null) findBottomLeftValue(root.left, depth+1);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1);
    }
    public static void main(String[] args) {
        int value;
        TreeNode left= new TreeNode(1);
        TreeNode right= new TreeNode(3);
        TreeNode root=new TreeNode(2) ;
        root.left=left;
        root.right=right;
        FindBottomLeftTreeValue solution=new FindBottomLeftTreeValue();
        value=solution.findBottomLeftValue(root);
        System.out.println( value);
    }
}

