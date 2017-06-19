package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linna on 2017/6/18.
 * 624. Maximum Distance in Arrays
 *
 * Given m arrays, and each array is sorted in ascending order.
 * Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance.
 * We define the distance between two integers a and b to be their absolute difference |a-b|.
 * Your task is to find the maximum distance.

 Example 1:
 Input:
 [[1,2,3],
 [4,5],
 [1,2,3]]
 Output: 4
 Explanation:
 One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 Note:
 Each given array will have at least 1 number. There will be at least two non-empty arrays.
 The total number of the integers in all the m arrays will be in the range of [2, 10000].
 The integers in the m arrays will be in the range of [-10000, 10000].
 */
public class MaximumDistanceinArrays {
    public int maxDistance(List<List<Integer>> arrays) {

        //方法一：暴力解法，两重循环，超时
//        int length = arrays.size();
//        int result=0;
//        for(int i=0;i < length;i++)
//        {
//            for (int j=i+1;j < length;j++)
//            {
//                int temp = result;
//                result = Math.max(Math.abs(arrays.get(i).get(0)-arrays.get(j).get(arrays.get(j).size()-1)),
//                         Math.abs(arrays.get(j).get(0)-arrays.get(i).get(arrays.get(i).size()-1)));
//                result=Math.max(temp,result);
//            }
//        }
//        return result;

        // 方法二：参考的其他人的方法
        //  使用两个变量存储每个array的首尾两个值,使用空间换取时间
        if (arrays == null|| arrays.isEmpty()) //需要考虑arrays是否为空，或者为null.
            return 0;
        int result=Integer.MIN_VALUE;   //最初的返回值的初始值为Integer.MIN_VALUE
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int min = arrays.get(0).get(0);
        for (int i=1;i<arrays.size();i++)
        {
            result = Math.max(result,Math.abs(max-arrays.get(i).get(0)));
            result = Math.max(result,Math.abs(arrays.get(i).get(arrays.get(i).size()-1)-min));
            max = Math.max(max,arrays.get(i).get(arrays.get(i).size()-1));
            min = Math.min(min,arrays.get(i).get(0));
        }
        return result;
    }

    public static void main(String[] args) {
        int intValue;
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        List<Integer> arr2= new ArrayList<>();
        arr2.add(4);
        arr2.add(5);
        List<Integer> arr3 = new ArrayList<>();
        arr3.add(1);
        arr3.add(2);
        arr3.add(3);
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(arr1);
        arrays.add(arr2);
        arrays.add(arr3);
        MaximumDistanceinArrays solution=new MaximumDistanceinArrays();
        intValue=solution.maxDistance(arrays);
        System.out.println( intValue);
    }
}
