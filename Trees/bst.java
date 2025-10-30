class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
    }
}
class BinaryTree{
    Node root ;
    public void insert(int data){
        root = insertRec(root,data);
    }
    public Node insertRec(Node root, int data){
        if(root==null)
            root = new Node(data);
        else if(data<root.data)
            root.left = insertRec(root.left,data);
        else if(data>root.data){
            root.right=insertRec(root.right,data);
        }
        return root;
    }
    public void inorder(){
        inorderRec(root);
    }
    public void inorderRec(Node root){
        if(root!=null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    public void preorder(){
        preorderRec(root);
    }
    public void preorderRec(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    public void postorder(){
        postorderRec(root);
    }
    public void postorderRec(Node root){
        if(root!=null){
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data+" ");
        }
    }
    public int sumofNodes(){
       return sumofNodes(root);
    }
    private int sumofNodes(Node root){
        if(root == null)
            return 0;
        return 1+ sumofNodes(root.left) + sumofNodes(root.right);
    }
    public int sumofValues(){
        return sumofValues(root);
    }
    private int sumofValues(Node root){
        if(root == null){
            return 0;
        }
        return root.data+ sumofValues(root.left)+sumofValues(root.right);
    }
}

public class bst {
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.insert(33);
        tree.insert(25);
        tree.insert(27);
        tree.insert(35);
        tree.insert(24);
        tree.insert(53);
        tree.insert(15);
        tree.insert(45);
        System.out.println("InOrder :");
        tree.inorder();
        System.out.println();
        System.out.println("PreOrder :");
        tree.preorder();
        System.out.println();
        System.out.println("PostOrder :");
        tree.postorder();
        System.out.println();
        int nodes = tree.sumofNodes();
        System.out.println("Total no of nodes = "+nodes);
        int total = tree.sumofValues();
        System.out.println("Total values = "+total);
    }
}
