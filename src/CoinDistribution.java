//time complexity- O(n)
//space complexity- O(n)
public class CoinDistribution {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    private static int count;
    static int distributeCoins(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }
    private static int dfs(TreeNode node) {
        if(node == null) return 0;

        int extra = node.val - 1;
        int left = dfs(node.left);
        int right = dfs(node.right);

        count += Math.abs(left + right + extra);

        return (left + right + extra);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(1);
        root.left.left.right = new TreeNode(1);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(1);
        root.left.left.right.left = new TreeNode(0);
        root.left.left.right.right = new TreeNode(0);


        /*  Binary Tree-
                        0
                      /   \
                    2      0
                  /      /  \
                 0      3    1
                  \        /  \
                  1       3    1
                 / \
                0   0

         */

        System.out.println("Minimum steps to distribute coins: " + distributeCoins(root));

    }
}
