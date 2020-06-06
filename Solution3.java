//Problem Url : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/

class Solution3 {
    public boolean isPerfectSquare(int num) {
//        Without using sqrt() of Math class.
//        Just do a loop from 2 to n/2 and break whenever number is found
        if(num ==1 ) return true;
        for(int i=2;i<=num/2;i++){
            if(i*i == num){
                return true;
            }
        }
        return false;

    }
    public static void main(String args[]){
        Solution3 s = new Solution3();
        System.out.println(s.isPerfectSquare(4));
    }
}
