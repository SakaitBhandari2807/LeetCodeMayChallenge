import java.util.ArrayList;
import java.util.Iterator;

class Solution21 {
    public int visited[];
    ArrayList<Integer> adj[];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        visited = new int[numCourses];

        for (int i = 0; i < numCourses ; i++) {
            adj[i] =  new ArrayList<>();
        }

        for(int i=0;i<prerequisites.length;i++){
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for(int i=0;i<visited.length;i++){
            if(visited[i] == 0){
                if(!applyDfs(i)) return false;
            }
        }

        return true;
    }

    private boolean applyDfs(int i) {
        if(visited[i] == 2) return false;

        visited[i] = 2;
        Iterator iterator = adj[i].iterator();
        while(iterator.hasNext()){
            Integer vertex = (Integer) iterator.next();
            if(!applyDfs(vertex)) return false;

        }
        visited[i] = 1;
        return true;
    }
    public static void main(String args[]){
        Solution21 sol = new Solution21();

        System.out.println(sol.canFinish(2,new int[][]{{1,0}}));
        System.out.println(sol.canFinish(2,new int[][]{{1,0},{0,1}}));
    }
}
