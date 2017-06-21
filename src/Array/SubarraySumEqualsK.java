package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linna on 2017/6/21.
 * 560. Subarray Sum Equals K
 * Difficulty:Medium
 * Tags:Array,Map
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2
 Note:
 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        //方法一：自己写的，效果最差
//        int result=0;
//        int j,temp;
//        for (int i=0 ; i < nums.length;i++){
//            j = 0;
//            temp = 0;
//            while(i+j < nums.length){
//                temp = temp	+ nums[i+j];
//                if(temp == k)
//                    result+=1;
//                j+=1;
//            }
//        }
//        return result;
        //方法二：别人的方法，利用Map
        //利用，只要存在一个i,j，使得a[i]到a[j]的序列和为k,则，a[0]到a[j]的和与a[0]到a[i]的和的差为k.
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : sum) {
            if (map.containsKey(num)) {
                count += map.get(num);
            }
            map.put(num + k, map.containsKey(num + k) ? map.get(num + k) + 1 : 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int intValue;
        SubarraySumEqualsK solution=new SubarraySumEqualsK();
        intValue=solution.subarraySum(new int[]{1,2,3,4,5,6,3},9);
        System.out.println( intValue);
    }
}
