import java.util.LinkedList;
import java.util.Queue;
//Problem Url: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/

class Solution7 {
    public boolean isCousins(TreeNode root, int x, int y) {
//        Solution is basically a BFS algorithm where we track the depth
//        and parent of the two nodes that are to be found in this tree

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int depth = 0;
        int x_depth = 0,y_depth=0;
        boolean x_found=false,y_found=false;
        int x_parent = 0,y_parent=0;

        q.add(root);

        while(!q.isEmpty()){

            int nodeCount = q.size();

            while(nodeCount>0){

                TreeNode current = q.poll();
                //System.out.println(current.val);
                if(current.val == x ){
                    x_depth = depth;
                    x_found = true;
                    x_parent = -1;
                }
                if(current.val == y){
                    y_depth = depth;
                    y_found = true;
                    y_parent = -1;
                }
                if((current.left != null && current.left.val == x) || (current.right !=null && current.right.val == x)){
                    x_depth = depth+1;
                    x_found = true;
                    x_parent = current.val;
                    //System.out.println("dep"+x_depth);
                }

                if((current.left != null && current.left.val == y) || (current.right!=null && current.right.val == y)){
                    y_depth = depth+1;
                    y_found = true;
                    y_parent = current.val;
                    //System.out.println("y_dep"+y_depth);
                }

                if(x_found && y_found){
                    if(x_depth == y_depth) {
                        //System.out.println("xp"+x_parent+"yp "+y_parent);
                        if(x_parent == y_parent){
                            return false;
                        }
                        else return true;
                    }
                    else return false;
                }

                if(current.left != null)
                    q.add(current.left);

                if(current.right != null)
                    q.add(current.right);

                nodeCount--;
            }
            depth++;

        }
        return true;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        TreeNode root = new TreeNode(1,null,null);
       //root.left = new TreeNode(2,new TreeNode(4,null,null),null);
        root.right =  new TreeNode(2,new TreeNode(3,null,null),null);
        System.out.println(sol.isCousins(root,1,3));
    }
}



//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
