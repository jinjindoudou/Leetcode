package Tree;

/**
 * Created by linna on 2017/6/18.
 */
/*
   606. Construct String from Binary Tree

   You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())",
but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example,
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class ConstructStringfromBinaryTree {

    public String tree2str(TreeNode t) {
        String result="",temp="";
        if (t==null)
            return result;
        result=result+t.val;

        if (t.left!=null) {
            temp = tree2str(t.left);
            result = result + "(" + temp + ")";
            temp="";
        }
        if (t.left==null&&t.right!=null)
            result=result+"()";
        if (t.right!=null)
            temp=tree2str(t.right);
        if (temp!="")
            result=result+"("+temp+")";
        return result;
    }

    public static void main(String[] args) {
        String strValue;
        TreeNode left= new TreeNode(2);
        TreeNode left2= new TreeNode(4);
        left.left=left2;
        TreeNode right= new TreeNode(3);
        TreeNode root=new TreeNode(1) ;
        root.left=left;
        root.right=right;
        ConstructStringfromBinaryTree solution=new ConstructStringfromBinaryTree();
        strValue=solution.tree2str(root);
        System.out.println( strValue);
    }
}