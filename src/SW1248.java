import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Tree{
    Node root;
    void AddNode(Node parent, Node child){
        if(parent.left == null){
            parent.left = child;
        }
        else{
            parent.right = child;
        }
        child.par = parent;
        child.depth = parent.depth +1;
    }
    Node Find(int key){
        Node temp = this.root;
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(this.root);
        while(!stack.isEmpty()){
            temp = stack.poll();
            if(temp.key == key){
                break;
            }
            else{
                if(temp.left != null){
                    stack.add(temp.left);
                }
                if(temp.right != null){
                    stack.add(temp.right);
                }
            }
        }
        return temp;
    }
}
class Node{
    int key;
    int depth;
    Node left;
    Node right;
    Node par;
    Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.par = null;
    }
}


public class SW1248 {
    public static int V, E, A, B;
    public static int []have;
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/SW1248.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            V = sc.nextInt();
            E = sc.nextInt();
            A = sc.nextInt();
            B = sc.nextInt();
            //트리를 새로 만들고 겹치는 노드생기면  합치는 것 까지 만들어야함
            have = new int[V+1];
            Tree bt = new Tree();
            bt.root = new Node(1);
            have[1] =1;
            for(int i = 0; i< E; i++){
                int a,b;
                a = sc.nextInt();
                b = sc.nextInt();
                Node a1;
                Node b1;
                if(have[a] == 0){
                    a1 = new Node(a);
                    have[a] = 1;
                }
                else{
                    a1 = bt.Find(a);
                }
                if(have[b] == 0){
                    b1 = new Node(b);
                    have[b] = 1;
                }
                else{
                    b1 = bt.Find(b);
                }
                bt.AddNode(a1, b1);
            }
            Node N_A = bt.Find(A);
            Node N_B = bt.Find(B);
            Node ans = FindParent(N_A, N_B);
            int s = node_Size(ans);
            System.out.println("#" +test_case+" "+ ans.key +" "+s);
        }
    }
    public static Node FindParent(Node x, Node y){
        Node p;
        while(true){
            if(x.depth > y.depth){
                x = x.par;
            }
            else if(x.depth < y.depth){
                y = y.par;
            }
            else{
                if(x.key == y.key){
                    p = x;
                    break;
                }
                x = x.par;
            }
        }
        return p;
    }

    public static int node_Size(Node a){
        int size = 0;
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(a);
        while (!stack.isEmpty()){
            Node temp = stack.poll();
            size++;
            if(temp.left != null){
                stack.add(temp.left);
            }
            if(temp.right != null){
                stack.add(temp.right);
            }
        }
        return size;
    }
}