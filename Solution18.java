import java.util.Arrays;
import java.util.HashMap;


class Solution18 {
    //Wrong Solution
//    public int findMaxLength(int[] nums) {
//        int countOfZeros = 0,countOfOnes = 0,maxSubsize = 0,len_nums = nums.length;
//        int zeros_cum_sum[] = new int[len_nums];
//        int ones_cum_sum[] = new int[len_nums];
//
//        for(int i = 0;i < len_nums;i++){
//            if(i == 0){
//                if(nums[i]==0) zeros_cum_sum[i]++;
//                else ones_cum_sum[i]++;
//                continue;
//            }
//            if(nums[i] == 0) {
//                zeros_cum_sum[i] = zeros_cum_sum[i-1]+1;
//                ones_cum_sum[i] += ones_cum_sum[i-1];
//            }
//            //countOfZeros++;
//            else {
//                ones_cum_sum[i] = ones_cum_sum[i-1]+1;
//                zeros_cum_sum[i] += zeros_cum_sum[i-1];
//            }
//            //countOfOnes++;
//        }
//
//        int valueToBeReturned = 0,index=len_nums;
//        if(zeros_cum_sum[len_nums-1] > ones_cum_sum[len_nums-1]){
//            for(int i=len_nums-2;i>=0;i--){
//                if(ones_cum_sum[i] != ones_cum_sum[len_nums-1]) index = i+1;
//                if(ones_cum_sum[len_nums-1] == zeros_cum_sum[len_nums-1]-zeros_cum_sum[i]){
//                    if(ones_cum_sum[i] == zeros_cum_sum[i]) valueToBeReturned = i+1;
//                    else valueToBeReturned = index-i+1;
//                    break;
//                }
//            }
//        }
//        else {
//            for(int i=len_nums-2;i>=0;i--){
//                if(zeros_cum_sum[i] != zeros_cum_sum[len_nums-1]) index = i+1;
//                if(zeros_cum_sum[len_nums-1] == ones_cum_sum[len_nums-1]-ones_cum_sum[i]){
//                    if(ones_cum_sum[i] == zeros_cum_sum[i]) valueToBeReturned = i+1;
//                    else valueToBeReturned = index-i+1;
//                    break;
//                }
//            }
//        }
//        System.out.println(valueToBeReturned);
//        return valueToBeReturned;
//    }
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int count = 0,max_length_so_far=0;
        int l = nums.length;

        for(int i=0;i<l;i++){
            if(nums[i] == 0) count--;
            else count++;
            if(count == 0){
                if(max_length_so_far< i) max_length_so_far = i + 1;
                continue;
            }
            if(!hmap.containsKey(count)) hmap.put(count,i);
            else {
                int index = hmap.get(count);
                if(max_length_so_far< i-index) max_length_so_far = i -index;
            }
        }
        return max_length_so_far;
    }
    public static void main(String args[]){
        Solution18 sol = new Solution18();
        System.out.println(sol.findMaxLength(new int[]{0,1}));
        System.out.println(sol.findMaxLength(new int[]{0,1,0}));
        System.out.println(sol.findMaxLength(new int[]{0,1,0,1}));
        System.out.println(sol.findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
        System.out.println(sol.findMaxLength(new int[]{0,1,1,0,1,1,1,0}));
        System.out.println(sol.findMaxLength(new int[]{0,0,0,1,1,1,0}));
    }
}
