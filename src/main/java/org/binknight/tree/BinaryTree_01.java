package org.binknight.tree;

public class BinaryTree_01 {
    /**
     *  binary tree traversal
     *  1. preorder traversal
     *  2. inorder traversal
     *  3. postorder traversal
     */

    void preorder(Tree tree,int id){
        Node root = tree.nodes[id];
        if(null == root) return;
        System.out.println(root.value); // 1打印当前节点
        preorder(tree, root.getLeftNode(tree).id);// 2打印左子节点节点
        preorder(tree, root.getRightNode(tree).id);// 3打印右子节点节点
    }

    void inorder(Tree tree,int id){
        Node root = tree.nodes[id];
        if(null == root) return;
        preorder(tree, root.getLeftNode(tree).id);// 1打印左子节点节点
        System.out.println(root.value); //2 先打印当前节点
        preorder(tree, root.getRightNode(tree).id);// 3打印右子节点节点
    }

    void postorder(Tree tree,int id){
        Node root = tree.nodes[id];
        if(null == root) return;
        preorder(tree, root.getLeftNode(tree).id);// 1打印左子节点节点
        preorder(tree, root.getRightNode(tree).id);// 2打印右子节点节点
        System.out.println(root.value); // 3打印当前节点
    }
    private class Node<E>{

        private int id;

        private E value;
        public Node(E value) {
            this.value = value;
        }

        public Node getLeftNode(Tree tree) {
            return tree.nodes[id*2];
        }

        public Node getRightNode(Tree tree) {
            return tree.nodes[id*2+1];
        }
    }

    private class Tree{
        private Node[] nodes;

        public Tree(Node[] nodes) {
            this.nodes = nodes;
        }

        public Node getNode(int id) {
            return nodes[id-1];
        }
    }
}
