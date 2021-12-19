package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class Successor {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        List<Integer> b = new ArrayList<>();
        b.add(4);
        l.addAll(a);
        l.addAll(b);
        for(Integer child: l){
            System.out.println(child);
        }

        System.out.println(l);

    }

    public static TreeNode getSuccessor(TreeNode root, TreeNode node){
        TreeNode successor = null;

        while(root!=null){
            if(node.data >= root.data){
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
