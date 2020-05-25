
class Solution16{
    public TreeNode bstFromPreorder(int[] preorder) {
        int preorder_len = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1;i < preorder_len;i++){
            checkNode(root,preorder[i]);
        }
        return root;
    }
    public int checkNode(TreeNode root,int insertValue){
        if(root == null ) return 0;
        if(root.val >= insertValue ) {
            int index =checkNode(root.left,insertValue);
            if(index == -1) {
                return -1;
            }
            else root.left = new TreeNode(insertValue);
        }
        else{
            int index = checkNode(root.right,insertValue);
            if(index == -1){
                return -1;
            }
            else root.right = new TreeNode(insertValue);
        }
        return -1;
    }
    public static void main(String args[]){
        Solution16 sol = new Solution16();
        TreeNode root = sol.bstFromPreorder(new int[]{8,5,1,7,10,12});
    }
}


