class Solution12 {
    // int count = 0;
    Stack<Integer> stack = new Stack<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        if(stack.size() == k) return 0;
        kthSmallest(root.left,k);
        if(root != null && stack.size()!=k) stack.push(root.val);
        kthSmallest(root.right,k);
        return stack.peek();
    }
}

 public class TreeNode {
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
