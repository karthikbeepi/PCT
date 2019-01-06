package advancedproblem;

import java.util.Scanner;

public class StructuralEquivalenceTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        BSTree[] trees = new BSTree[num];
        // build all trees
        for (int i = 0; i < num; i++) {
            String[] lines = scanner.nextLine().split("\\s+");
            trees[i] = new BSTree(lines.length - 1);
            for (String line : lines) {
                if (!"-1".equals(line)) {
                    TreeNode node = new TreeNode(Integer.parseInt(line));
                    trees[i].insert(node);
                } else {
                    trees[i].calDepth();
                }
            }
        }
        // check their structure
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < trees.length; i++) {
            String res = compare(trees[0], trees[i]);
            builder.append(res);
            if ("YES".equals(res)) {
                builder.append(" ").append("0");
            } else {
                builder.append(" ").append(Math.abs(trees[0].depth - trees[i].depth));
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    private static String compare(BSTree tree1, BSTree tree2) {
        if (tree1.size == tree2.size) {
            for (int i = 0; i < tree1.size; i++) {
                if (tree1.nodes[i] == null && tree2.nodes[i] != null) return "NO";
                if (tree1.nodes[i] != null && tree2.nodes[i] == null) return "NO";
            }
            return "YES";
        }
        return "NO";
    }
}

class BSTree {

    TreeNode root;
    int depth;
    int size;
    TreeNode[] nodes;

    public BSTree(int size) {
        this.size = size;
        nodes = new TreeNode[(int) Math.pow(2, size) - 1];
    }

    void insert(TreeNode node) {
        // no duplicate number in one line, according to
        // the problem description
        if (root == null) {
            root = node;
            nodes[0] = node;
        } else insertAux(root, node, 0);
    }

    private void insertAux(TreeNode parent, TreeNode node, int idx) {
        if (node.value < parent.value) {
            if (parent.leftChild == null) {
                parent.leftChild = node;
                node.parent = parent;
                nodes[2 * idx + 1] = node;
            } else {
                insertAux(parent.leftChild, node, 2 * idx + 1);
            }
        } else {
            if (parent.rightChild == null) {
                parent.rightChild = node;
                node.parent = parent;
                nodes[2 * idx + 2] = node;
            } else {
                insertAux(parent.rightChild, node, 2 * idx + 2);
            }
        }
    }

    void calDepth() {
        for (TreeNode node : nodes) {
            if (node != null) {
                int max = 0;
                TreeNode parent;
                while ((parent = node.parent) != null) {
                    max++;
                    node = parent;
                    if (node.isRoot()) break;
                }
                depth = (max > depth) ? max : depth;
            }
        }
    }
}

class TreeNode {

    int value;
    TreeNode parent;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }

    boolean isRoot() {
        return parent == null;
    }
}
