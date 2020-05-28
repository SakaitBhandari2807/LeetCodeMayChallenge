import java.util.*;

class Solution19 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int len = dislikes.length;
        ArrayList<Integer> adj[]= new ArrayList[N];
        Queue<Integer> nodesToBeProcessed = new LinkedList<>();

        for(int i=0;i<N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<len;i++){
            adj[dislikes[i][0]-1].add(dislikes[i][1]-1);
            adj[dislikes[i][1]-1].add(dislikes[i][0]-1);
        }

        int color[] = new int[N];
        Arrays.fill(color,-1);

        for (int i = 0; i < N ; i++) {
            if(color[i]!=-1) continue;
            nodesToBeProcessed.add(i);
            color[i] = 1;
            int current_color = 0;

            while(!nodesToBeProcessed.isEmpty()){
                int node = nodesToBeProcessed.poll();
                current_color = color[node];

                Iterator iterator = adj[node].iterator();
                while(iterator.hasNext()){
                    Integer vertex = (Integer)iterator.next();
                    if(color[vertex] == -1){
                        color[vertex] = 1-current_color;
                        nodesToBeProcessed.add(vertex);
                    }
                    else if(color[vertex]!=-1 && color[vertex] == current_color) return false;
                }
            }
        }

        return true;
    }
    public static void main(String args[]){
        Solution19 sol = new Solution19();
        System.out.println(sol.possibleBipartition(4,new int[][]{{1,2},{1,3},{2,4}}));
        System.out.println(sol.possibleBipartition(3,new int[][]{{1,2},{1,3},{2,3}}));
        System.out.println(sol.possibleBipartition(5,new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}));
        System.out.println(sol.possibleBipartition(5,new int[][]{{1,2},{3,4},{4,5},{3,5}}));

    }
}
