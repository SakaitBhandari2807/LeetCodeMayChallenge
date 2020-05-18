import java.util.*;

class Solution9 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> anagramIndices = new ArrayList<>();
        int len_s = s.length(),len_p = p.length();

        if(len_p>len_s) return anagramIndices;

        int p_hash[] = new int[26];
        int s_hash[] = new int[26];
        for(int i=0;i<len_p;i++) p_hash[p.charAt(i)-97]++;

        int start = 0,end = 0;
        while(end<len_p){
            s_hash[s.charAt(end)-97]++;
            end++;
        }
        if(hashMatch(s_hash,p_hash)){
            anagramIndices.add(start);
        }
        while(start<(len_s-len_p)){
            s_hash[s.charAt(start)-97]--;
            start++;
            s_hash[s.charAt(end)-97]++;
            end++;
            if(hashMatch(s_hash,p_hash)) anagramIndices.add(start);
        }



        return anagramIndices;
    }
    public boolean hashMatch(int []a,int []b){
        return Arrays.equals(a,b);
    }

    public static void main(String args[]){
        Solution9 sol = new Solution9();
        System.out.println(sol.findAnagrams("cbaebabacd","abc"));
        System.out.println(sol.findAnagrams("abab","ab"));
        System.out.println(sol.findAnagrams("abc","abcd"));
        System.out.println(sol.findAnagrams("abcd","abcd"));

    }
}
