package TreesAndGraphs;

public class CheckBalanced {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static int getHeight(TreeNode root){
        if(root == null){
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
