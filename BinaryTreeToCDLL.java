//https://practice.geeksforgeeks.org/problems/binary-tree-to-cdll/1

class Tree{
    Node bTreeToClist(Node root){
        Node ends[] = bTCL(root);
        ends[0].left = ends[1];
        ends[1].right = ends[0];
        return ends[0];
    }
    Node[] bTCL(Node root){
        Node ends[] = new Node[2];
        Node ltreeEnds[],rtreeEnds[];
        if(root.right != null){
            rtreeEnds = bTCL(root.right);
            rtreeEnds[0].left = root;
            root.right = rtreeEnds[0];
            ends[1] = rtreeEnds[1];
        }
        else{
            ends[1] = root;
        }
        if(root.left != null){
            ltreeEnds = bTCL(root.left);
            ltreeEnds[1].right = root;
            root.left = ltreeEnds[1];
            ends[0] = ltreeEnds[0];
        }
        else{
            ends[0] = root;
        }
        return ends;
    }
}
