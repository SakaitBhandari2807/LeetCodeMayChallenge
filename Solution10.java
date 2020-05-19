import java.util.Arrays;

class Solution10 {
    public boolean checkInclusion(String s1, String s2) {
        int len_s2 = s2.length(),len_s1=s1.length();
        if(len_s2<len_s1) return false;

        int hash_s2[] = new int[26];
        int hash_s1[] = new int[26];

        for(int i=0;i<len_s1;i++) hash_s1[s1.charAt(i)-97]++;

        int start=0,end=0;
        while(end<len_s1){
            hash_s2[s2.charAt(end)-97]++;
            end++;
        }
        if(hashMatch(hash_s1,hash_s2)) return true;
        while(start<len_s2-len_s1){
                hash_s2[s2.charAt(start)-97]--;
                start++;
                hash_s2[s2.charAt(end)-97]++;
                end++;
                if(hashMatch(hash_s1,hash_s2)) return true;
        }
        return false;

    }
    public boolean hashMatch(int []a,int []b){
        return Arrays.equals(a,b);
    }
    public static void main(String args[]){
        Solution10 sol = new Solution10();
        System.out.println(sol.checkInclusion("ab","eidbaooo"));
        System.out.println(sol.checkInclusion("ab","eidboaoo"));
        System.out.println(sol.checkInclusion("ab","a"));
    }
}
