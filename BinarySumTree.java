import java.util.*;
 
class BinarySumTree {
 
    public static class Node {
        int data;
        Node left, right;
    };
 
    public static Node rootNode(int data)
    {
        Node root = new Node();
        root.data = data;
        root.left = null;
        root.right = null;
        return root;
    }
 
   public static Node insertNode(Node root, int key)
    {
        if (root == null)
            return rootNode(key);
        if (key < root.data)
            root.left = insertNode(root.left, key);
        else
            root.right = insertNode(root.right, key);
        return root;
    }
 
    public static boolean sumPair(Node root, int sum, HashSet<Integer> set)
    {
        if (root == null)
            return false;
 
        if (sumPair(root.left, sum, set))
            return true;
 
        if (set.contains(sum - root.data)) {
            System.out.println("Pair is ("+ (sum - root.data) + ", " + root.data + ")");
            return true;
        }
        else
            set.add(root.data);
 
        return sumPair(root.right, sum, set);
    }
 
    static void findPair(Node root, int sum)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        if (!sumPair(root, sum, set))
            System.out.print("Nodes are not found");
    }
 
    public static void main(String[] args)
    {
        Node root = null;
        root = insertNode(root, 10);
        root = insertNode(root, 20);
        root = insertNode(root, 30);
        root = insertNode(root, 40);
        root = insertNode(root, 50);
        root = insertNode(root, 60);
        root = insertNode(root, 70);
 
        int sum = 130;
        findPair(root, sum);
    }
}