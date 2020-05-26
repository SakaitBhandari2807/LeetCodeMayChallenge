class Solution17 {
    public int maxUncrossedLines(int[] A, int[] B) {
        int size_a = A.length,size_b = B.length;

        int dp[][] = new int[size_a+1][size_b+1];

        for(int i = 1;i < size_a+1;i++){
            for (int j = 1; j < size_b+1 ; j++) {
                if(A[i-1] == B[j-1])
                    dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
//        for (int i = 0; i < size_a+1; i++) {
//            for (int j = 0; j < size_b+1 ; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        return dp[size_a][size_b];
    }

    public static void main(String args[]){
        Solution17 sol = new Solution17();

        System.out.println(sol.maxUncrossedLines(new int[]{1,4,2},new int[]{1,2,4}));
        System.out.println(sol.maxUncrossedLines(new int[]{2,5,1,2,5},new int[]{10,5,2,1,5,2}));
        System.out.println(sol.maxUncrossedLines(new int[]{1,3,7,1,7,5},new int[]{1,9,2,5,1}));
    }
}
