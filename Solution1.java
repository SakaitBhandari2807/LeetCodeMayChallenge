import java.util.HashMap;
//Problem Url: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/


class Solution1 {
    public int majorityElement(int[] nums) {
//       Just calculating the count of each number and checking if it appears more than n/2 times
//       Using hashmap to keep the count

        HashMap hmap = new HashMap<Integer,Integer>();
        int lower_limit = nums.length/2;
        int majority_element=nums[0];
        for(int i=0;i<nums.length;i++){
            if(hmap.containsKey(nums[i])){
                int value = (int)hmap.get(nums[i]);
                if((value+1) > lower_limit){
                    majority_element = nums[i];
                    break;
                }
                else hmap.put(nums[i],value+1);
            }
            else{
                hmap.put(nums[i],1);
            }
        }
        return majority_element;
    }
}
