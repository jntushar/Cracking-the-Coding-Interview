package TreesAndGraphs;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class MinimalTree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        TreeNode root = createMinimalBST(arr);
        System.out.println(root.data);
    }

    public static TreeNode createMinimalBST(int[] arr){
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    public static TreeNode createMinimalBST(int[] arr, int start, int end){
        if(end < start){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createMinimalBST(arr, start, mid-1);
        node.right = createMinimalBST(arr, mid+1, end);
        return node;
    }
}
