package LinkedList;

/**
 * Created by linna on 2017/9/2.
 */
public class AddTwoNumbers {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

         /**********
//       方法一：使用ListNode先计算出数字，再计算结果，出错
//       无法解决数字过大，int / double 无法计算的情况
//       失败例子：9 + 9999999991
         ListNode result = new ListNode(0);
         ListNode point = new ListNode(0);
         result = point;
         int addnum1 = 0,addnum2 = 0,sum = 0;
         int times = 1;
         while(l1!=null)
         {
             addnum1 = l1.val*times + addnum1;
             times = times * 10;
             l1 = l1.next;
         }
         times = 1;
         while(l2!=null)
         {
             addnum2 = l2.val*times + addnum2;
             times = times * 10;
             l2 = l2.next;
         }
         System.out.println("addnum1: "+addnum1);
         System.out.println("addnum2: "+addnum2);
         sum = addnum1 + addnum2;
         if (sum == 0)
             return result;
         while(sum != 0){
             ListNode temp = new ListNode(sum % 10);
             sum = (sum - (sum % 10))/10;
             point.next = temp;
             point = point.next;
         }
         return result.next;
*********/


         /***********
//       方法二：直接用ListNode数据结构进行运算
//         ！！！注意！！！：对于ListNode的“=”操作：a = b 是相当于 a 指向了 b变量的地址
//         其中，简写的部分是参考了别人的答案

         ListNode result = new ListNode(0);
         ListNode point = new ListNode(0);
         result = point;
         int lastnumber = 0;
         while( l1!=null && l2!=null ){
//             ListNode temp = new ListNode(( lastnumber + l1.val + l2.val)%10);
//             point.next = new ListNode(0);
//             point.next.val = temp.val;

//           上面三行可以由下面这一行代替，下面类似
             point.next = new ListNode(( lastnumber + l1.val + l2.val)%10);

             lastnumber = ( lastnumber + l1.val + l2.val)/10;
             point = point.next;
             l1 =  l1.next ;
             l2 =  l2.next ;
         }
         while (l1!=null){
//             ListNode temp = new ListNode(( lastnumber + l1.val)%10);
//             point.next = new ListNode(0);
//             point.next.val = temp.val;

             point.next = new ListNode(( lastnumber + l1.val)%10);
             lastnumber = ( lastnumber + l1.val)/10;
             point = point.next;
             l1 = l1.next;
         }
         while (l2!=null){
//             ListNode temp = new ListNode(( lastnumber + l2.val)%10);
//             point.next = new ListNode(0);
//             point.next.val = temp.val;

             point.next = new ListNode(( lastnumber + l2.val)%10);
             lastnumber = ( lastnumber + l2.val)/10;
             point = point.next;
             l2 = l2.next;
         }
         if (lastnumber != 0)
             point.next = new ListNode(lastnumber);
         return result.next;
********/

         /*********
          * 方法三：别人的方法，，效率最高的方法
          */
         ListNode newList = new ListNode(0);
         ListNode placeHolder = newList;
         ListNode l1Node = l1;
         ListNode l2Node = l2;
         int carry = 0;
         while(l1Node != null || l2Node != null) {
             int sum = carry;
             if(l1Node != null) {
                 sum += l1Node.val;
                 l1Node = l1Node.next;
             }
             if (l2Node != null) {
                 sum += l2Node.val;
                 l2Node = l2Node.next;
             }
             if (sum > 9) {
                 newList.next = new ListNode(sum -10);
                 carry = 1;
             } else {
                 carry = 0;
                 newList.next = new ListNode(sum);
             }
             newList = newList.next;

         }

         if (carry == 1) {
             newList.next = new ListNode(1);
         }

         return placeHolder.next;

     }
    public static void main(String[] args) {
        ListNode num11 = new ListNode(2);
        ListNode num12 = new ListNode(4);
        ListNode num13 = new ListNode(9);
        num11.next = num12;
        num12.next = num13;
        ListNode num21 = new ListNode(1);
        ListNode num22 = new ListNode(9);
        ListNode num23 = new ListNode(9);
        ListNode num24 = new ListNode(9);
        ListNode num25 = new ListNode(9);
        ListNode num26 = new ListNode(9);
        ListNode num27 = new ListNode(9);
        ListNode num28 = new ListNode(9);
        ListNode num29 = new ListNode(9);
        ListNode num210 = new ListNode(9);
        num21.next = num22;
        num22.next = num23;
        num23.next = num24;
        num24.next = num25;
        num25.next = num26;
        num26.next = num27;
        num27.next = num28;
        num28.next = num29;
        num29.next = num210;
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(num13,num21);
        while(result!=null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
