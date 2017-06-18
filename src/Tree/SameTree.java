package Tree;

/**
 * Created by linna on 2017/6/18.
 */
/*
    100. Same Tree
    Given two binary trees, write a function to check if they are equal or not.

    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if (p==null && q==null)
            return true;
        if (p==null || q==null)
            return false;
        if (p.val!=q.val)
            return false;

//    // 方法一：判断左子树或右子树是否为空，进行递归，效率不如直接递归
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


//    // 方法二：无需判断左子树或右子树是否为空，直接进行递归即可
      return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);


    }
    public static void main(String[] args) {
        boolean boolValue;
        TreeNode left= new TreeNode(2);
        TreeNode left2= new TreeNode(4);
        left.left=left2;
        TreeNode right= new TreeNode(3);
        TreeNode root=new TreeNode(1) ;
        root.left=left;
        root.right=right;
        TreeNode root2=root;
        TreeNode root3=null;
        TreeNode root4=root3;
        SameTree solution=new SameTree();
        boolValue=solution.isSameTree(root,root2);
        System.out.println( boolValue);
    }
}

