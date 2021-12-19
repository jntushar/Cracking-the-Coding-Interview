package TreesAndGraphs;

public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }

    public static boolean isValidBST(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        if((min != null && root.data < min) || (max != null && root.data >= max)){
            return false;
        }
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }
}
