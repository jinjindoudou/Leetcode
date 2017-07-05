package Array;

/**
 * Created by linna on 2017/6/21.
 * 605. Can Place Flowers
 * Difficulty:Easy
 * Tag:Array
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

 Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

 Example 1:
 Input: flowerbed = [1,0,0,0,1], n = 1
 Output: True
 Example 2:
 Input: flowerbed = [1,0,0,0,1], n = 2
 Output: False
 Note:
 The input array won't violate no-adjacent-flowers rule.
 The input array size is in the range of [1, 20000].
 n is a non-negative integer which won't exceed the input array size.

 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //第一次提交，没有考虑到数组首尾为0的情况。
//        int sumflower = 0;
//        int temp = 0;
//        for (int i = 0;i < flowerbed.length; i++){
//            if (flowerbed[i]==0)
//                temp+=1;
//            if (flowerbed[i]==1){
//                if ( temp > 2) {
//                    sumflower = temp%2==0 ? sumflower+temp/2-1 : sumflower+temp/2;
//                    if (sumflower >= n)
//                        return true;
//                }
//                temp = 0;
//            }
//        }
//        if (sumflower >= n)
//            return true;
//        return false;
        //第二次提交，没有考虑到数组只有为0的情况。
//        int sumflower = 0;
//        int fore = 0;
//        int temp = 0;
//        //第三次提交，添加的内容
//        for (int i = 0;i<flowerbed.length;i++)
//        {
//            temp = temp + flowerbed[i];
//        }
//        if (temp==0)
//        {
//            sumflower = flowerbed.length % 2 == 0 ? flowerbed.length / 2 : flowerbed.length / 2 + 1;
//            if (sumflower >= n)
//                return true;
//            else
//                return false;
//        }
//        //第三次提交，添加的内容
//        for (int i = 0;i < flowerbed.length;i++){
//            if (flowerbed[i] == 0 && i==0)
//                fore = -1;
//            if (flowerbed[i] == 1 && i==0)
//                fore = 0;
//            if (flowerbed[i]==1){
//                if (fore==-1)
//                    temp = i-fore;
//                else
//                    temp = i-fore-1;
//                if (temp > 2) sumflower = temp%2==0 ? sumflower+temp/2-1 : sumflower+temp/2;
//                fore = i;
//            }
//            if ( i==flowerbed.length-1) {
//                temp = i+1 - fore;
//                if (temp > 2) sumflower = temp % 2 == 0 ? sumflower + temp / 2 - 1 : sumflower + temp / 2;
//            }
//        }
//        if (sumflower >= n)
//            return true;
//        return false;


        //别人的方法 ：速度快，方法简单。
        // 计算 插花的位置，直接用count/2就可以，不用判断是否为奇偶数。
        // 综合的考虑到了在1.中间的位置、2.首尾的位置，还有 3.首尾相连的位置的三种情况。
//        int count = 1;
//        for (int i = 0; i < flowerbed.length; i++) {
//            if (flowerbed[i] == 0) {
//                count ++;
//            } else {
//                n -= (count - 1) / 2;
//                count = 0;
//            }
//        }
//        n -= count / 2;
//        if (n > 0) return false;
//        else return true;

        //别人的方法 ：速度快，方法简单。
        // 计算 插花的位置，直接用count/2就可以，不用判断是否为奇偶数。
        // 综合的考虑到了在1.中间的位置、2.首尾的位置，还有 3.首尾相连的位置的三种情况。
        int start = -1;
        for(int i = 0; i < flowerbed.length; ++i) {
            if(flowerbed[i] == 1) {
                n -= (i-start-1)/2;
                start = i+1;
            }
        }
        n -= (flowerbed.length - start)/2;
        return n <= 0;
    }
    public static void main(String[] args) {
        boolean boolValue;
        CanPlaceFlowers solution=new CanPlaceFlowers();
//      情况一：new int[]{1,0,0,0,1},2
//       情况二：new int[]{0,0,1,0,0},2
//        情况三：new int[]{0,0,0},2
        boolValue=solution.canPlaceFlowers(new int[]{1,0,0,0,1},2);
        System.out.println( boolValue);
    }
}
