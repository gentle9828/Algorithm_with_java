package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1991_tree {
    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }

    static class Tree {
        Node root;

        public void add(char value, char leftValue, char rightValue) {
            if (root == null) {
                root = new Node(value);
                if (leftValue != '.') {
                    root.left = new Node(leftValue);
                }
                if (rightValue != '.') {
                    root.right = new Node(rightValue);
                }
            } else {
                Node node = search(root, value);
                if (node != null) {
                    if (leftValue != '.') {
                        node.left = new Node(leftValue);
                    }
                    if (rightValue != '.') {
                        node.right = new Node(rightValue);
                    }
                }
            }
        }

        private Node search(Node input, char value) {
            Node temp;
            if (input == null) {
                return null;
            }
            if (input.value == value) {
                return input;
            }
            temp = search(input.left, value);

            if (temp != null) {
                return temp;
            }
            return search(input.right, value);
        }

        public void preOrder(Node root) {
            System.out.print(root.value);
            if (root.left != null) {
                preOrder(root.left);
            }
            if (root.right != null) {
                preOrder(root.right);
            }
        }

        public void inOrder(Node root) {
            if (root.left != null) {
                inOrder(root.left);
            }

            System.out.print(root.value);

            if (root.right != null) {
                inOrder(root.right);
            }
        }

        public void postOrder(Node root) {
            if (root.left != null) {
                postOrder(root.left);
            }
            if (root.right != null) {
                postOrder(root.right);
            }
            System.out.print(root.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.add(parent, left, right);
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}
