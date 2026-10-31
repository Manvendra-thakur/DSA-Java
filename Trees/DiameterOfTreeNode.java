class Solution {
    private int maxDiameter = 0;
    public int diameter(TreeNode root) {
        maxDiameter = 0;
        maxDepth(root);
        return maxDiameter;
        //Your Code Goes Here
    }
    private int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }

        int firstMax = 0;
        int Secondmax = 0;

        for(TreeNode child : node.children){
            int depth = maxDepth(child);
            if(depth>firstMax){
                Secondmax = firstMax;
                firstMax = depth;
            } else if(depth > Secondmax){
                Secondmax = depth;
            }
        }
        maxDiameter = Math.max(maxDiameter, firstMax + Secondmax);

        return firstMax + 1;
    }
}