class Solution {
    public static int setBits[];
    public int[] countBits(int num) {
        setBits = new int[num+1];
        Arrays.fill(setBits,-1);

        for(int i=0;i<=num;i++){
            if(i<2) setBits[i] = i;
            else countForNum(i);
        }

//        for (int a:setBits
//             ) {
//            System.out.print(a+" ");
//        }
//        System.out.println();

        return setBits;
    }
    public void countForNum(int n){
        int count = 0,original_number = n;
        while(n>0){

            count += n%2;
            n = n/2;
            if(setBits[n] != -1) {
                setBits[original_number] = count+setBits[n];
                break;
            }
        }
    }
}
