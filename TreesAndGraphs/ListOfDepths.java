package TreesAndGraphs;


import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        
        System.out.println(createLevelLinkedList(root));
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    public static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
        if(root == null){
            return;
        }
        LinkedList<TreeNode> list;
        if(lists.size() == level){
            list = new LinkedList<>();
            lists.add(list);
        }else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level+1);
        createLevelLinkedList(root.right, lists, level+1);
    }
}
