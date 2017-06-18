package Tree;

/**
 * Created by linna on 2017/6/18.
 */

import java.util.LinkedList;
import java.util.Queue;

/*
    513. Find Bottom Left Tree Value
 */
//public class Solution {
//    利用队列
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
//    }

//    利用递归，效率最高，使用两个函数实现递归
//    int ans=0, h=0;
//    public int findBottomLeftValue(TreeNode root) {
//        findBottomLeftValue(root, 1);
//        return ans;
//    }
//    public void findBottomLeftValue(TreeNode root, int depth) {
//        if (h<depth) {ans=root.val;h=depth;}
//        if (root.left!=null) findBottomLeftValue(root.left, depth+1);
//        if (root.right!=null) findBottomLeftValue(root.right, depth+1);
//    }
//    public static void main(String[] args) {
//        int value;
//        TreeNode left= new TreeNode(1);
//        TreeNode right= new TreeNode(3);
//        TreeNode root=new TreeNode(2) ;
//        root.left=left;
//        root.right=right;
//        Solution solution=new Solution();
//        value=solution.findBottomLeftValue(root);
//        System.out.println( value);
//    }
//}


/*
    513. Find Bottom Left Tree Value
 */
//public class Solution {
//
//    public String tree2str(TreeNode t) {
//        String result="",temp="";
//        if (t==null)
//            return result;
//        result=result+t.val;
//
//        if (t.left!=null) {
//            temp = tree2str(t.left);
//            result = result + "(" + temp + ")";
//            temp="";
//        }
//        if (t.left==null&&t.right!=null)
//            result=result+"()";
//        if (t.right!=null)
//            temp=tree2str(t.right);
//        if (temp!="")
//            result=result+"("+temp+")";
//        return result;
//    }
//
//    public static void main(String[] args) {
//        int intValue;
//        String strValue;
//        TreeNode left= new TreeNode(2);
//        TreeNode left2= new TreeNode(4);
//        left.left=left2;
//        TreeNode right= new TreeNode(3);
//        TreeNode root=new TreeNode(1) ;
//        root.left=left;
//        root.right=right;
//        Solution solution=new Solution();
//        strValue=solution.tree2str(root);
//        System.out.println( strValue);
//    }
//}
/*
    100. Same Tree
 */
//public class Solution {
//    public boolean isSameTree(TreeNode p, TreeNode q)
//    {
//        if (p==null && q==null)
//            return true;
//        if (p==null || q==null)
//            return false;
//        if (p.val!=q.val)
//            return false;
//
//      方法一：判断左子树或右子树是否为空，进行递归，效率不如直接递归
//
//        else
//        {
//            if ((p.left!=null && q.left==null )|| (p.left==null && q.left!=null))
//                return false;
//            if ((p.right!=null && q.right==null )|| (p.right==null && q.right!=null))
//                return false;
//            else
//            {
//                if (isSameTree(p.left,q.left))
//                    return isSameTree(p.right,q.right);
//                else
//                    return false;
//            }
//        }

//
//      方法二：无需判断左子树或右子树是否为空，直接进行递归即可
//      return isSameTree(p.left,q.right)&&isSameTree(p.right,q.right);
//    }
//    public static void main(String[] args) {
//        int intValue;
//        String strValue;
//        boolean boolValue;
//        TreeNode left= new TreeNode(2);
//        TreeNode left2= new TreeNode(4);
//        left.left=left2;
//        TreeNode right= new TreeNode(3);
//        TreeNode root=new TreeNode(1) ;
//        root.left=left;
//        root.right=right;
//        TreeNode root2=root;
//        TreeNode root3=null;
//        TreeNode root4=root3;
//        Solution solution=new Solution();
//        boolValue=solution.isSameTree(left,root);
//        System.out.println( boolValue);
//    }
//}

    /*
        104. Maximum Depth of Binary Tree
     */

public class Solution {

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
        Solution solution=new Solution();
        intValue=solution.maxDepth(left2);
        System.out.println( intValue);
    }
}