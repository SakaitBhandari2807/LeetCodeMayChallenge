import java.util.ArrayList;

class Solution15{
    public int[][] intervalIntersection(int[][] A, int[][] B) {
      int c_ptr=0,a_ptr = 0,b_ptr = 0;
      ArrayList<Interval> intersectingIntervals = new ArrayList<Interval>();

      while(a_ptr<A.length && b_ptr<B.length){
          if(areIntersecting(A[a_ptr][0],A[a_ptr][1],B[b_ptr][0],B[b_ptr][1])){
              Interval interval = new Interval();
              interval.L = Math.max(A[a_ptr][0],B[b_ptr][0]);
              interval.R = Math.min(A[a_ptr][1],B[b_ptr][1]);

              if(A[a_ptr][1]<B[b_ptr][1]) a_ptr++;
              else if(A[a_ptr][1] == B[b_ptr][1]){a_ptr++;b_ptr++;}
              else b_ptr++;

              intersectingIntervals.add(interval);
          }
          else{
              if(A[a_ptr][1]<B[b_ptr][1]) a_ptr++;
              else if(A[a_ptr][1] == B[b_ptr][1]){a_ptr++;b_ptr++;}
              else b_ptr++;
          }

      }
      int C[][] = new int[intersectingIntervals.size()][2];
        for (Interval i:intersectingIntervals
             ) {
            C[c_ptr][0] = i.L;
            C[c_ptr++][1] = i.R;
        }
        return C;
    }
    public boolean areIntersecting(int a1,int b1,int a2,int b2){
        if((a2<b1 && a2>a1) ||
                (a1>a2 && a1<b2) ||
                (a1 == b2) ||
                (a2 == b1) ||
                (a1 == a2 && ((b1 <=b2) || (b1>b2) ))) return true;
        return false;
    }
    public static void main(String args[]){
        Solution15 sol = new Solution15();
        int c[][] = sol.intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}}
        ,new int[][]{{1,5},{8,12},{15,24},{25,26}});
        for(int i=0;i<c.length;i++){
            for (int j=0;j<c[0].length;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }
}

class Interval{
    int L;
    int R;
}
