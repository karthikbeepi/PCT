package advancedproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FamilyTreeRelationship {

	public static void main(String[] args) {

        Node root = null;
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Node> map = new HashMap<>();
        // Attention here !!!
        int familyNum = Integer.parseInt(scanner.nextLine());

        // use a for loop to get the relation and construct the binary tree
        for (int i = 0; i < familyNum; i++) {
            String newLine = scanner.nextLine();
            String[] line = newLine.split(" ");
            String parentName = line[0].toLowerCase();
            String childName = line[1].toLowerCase();
            Node parent;
            // if the parent haven't create yet, then create the parent node and add into the map
            if (!map.containsKey(parentName)) {
                parent = new Node(parentName);
                map.put(parentName, parent);
                if (i == 0) root = parent;
            }
            // if the parent exist, just get it from the map
            else parent = map.get(parentName);

            // always create new child node !!!
            // it can handle the situation in test2.txt, relation rule number 2 and number 3
            Node child = new Node(childName);
            // add or override the child to the map
            map.put(childName, child);

            // if parent do not have left, set the new child as left child
            if (!parent.hasLeft()) parent.setLeft(child);
                // otherwise, set it to be right child
            else if (!parent.hasRight()) parent.setRight(child);
            // set the child's parent
            child.setParent(parent);
        }

        // Attention here !!!
        int ruleNum = Integer.parseInt(scanner.nextLine());
        char[] relationJudge = new char[ruleNum];

        // get pre-order traversal result
        ArrayList<String> preStringList = new ArrayList<>();
        preOrder(root, preStringList);

        // loop to check the relation rule
        for (int i = 0; i < ruleNum; i++) {
            String[] line = scanner.nextLine().split(" ");
            String name1 = line[0].toLowerCase();
            String relation = line[1];
            String name2 = line[2].toLowerCase();
            boolean res = false;
            if (relation.equals("child")) {
                // name1 is name2's child
                Node node1 = map.get(name2);
                // compare name1 with name2's left child
                if (node1.hasLeft()) {
                    if (node1.getLeft().getName().equals(name1)) res = true;
                }
                // compare name1 with name2's right child
                if (node1.hasRight()) {
                    if (node1.getRight().getName().equals(name1)) res = true;
                }
            } else if (relation.equals("parent")) {
                // name1 is name2's parent
                Node node1 = map.get(name2);
                // get name2's parent's name
                String pName = node1.getParent().getName();
                // compare equal or not
                if (name1.equals(pName)) res = true;
            } else if (relation.equals("sibling")) {
                // name1 is name2's sibling
                Node node1 = map.get(name1);
                Node node2 = map.get(name2);
                // compare their parent is the same person or not
                if (node1.getParent().getName().equals(node2.getParent().getName())) res = true;
            } else if (relation.equals("ancestor")) {
                // name1 is name2's ancestor
                Node r = map.get(name2);
                // loop to check all ancestor until find him, or reach the root
                while (r != null) {
                    if (r.getName().equals(name1)) {
                        res = true;
                        break;
                    }
                    r = r.getParent();
                }
            } else if (relation.equals("descendant")) {
                // name1 is name2's descendant
                // descendant means name1 should appear in pre-order traversal of the subtree
                // which root is name2
                Node r = map.get(name2);
                ArrayList<String> l = new ArrayList<>();
                preOrder(r, l);
                if (l.contains(name1)) res = true;
            }
            relationJudge[i] = res ? 'T' : 'F';
        }
        scanner.close();
        System.out.println(printTrueFalse(relationJudge));
        System.out.println(printPreOrderName(preStringList));
    }

    private static String printTrueFalse(char[] answer) {
        StringBuilder sb = new StringBuilder();
        for (char ch : answer) {
            sb.append(ch).append(" ");
        }
        return sb.toString().trim();
    }

    private static String printPreOrderName(ArrayList<String> preStringList) {
        StringBuilder sb = new StringBuilder();
        for (String name : preStringList) {
            // make the first character to be a captial letter
            char first = name.charAt(0);
            name = String.valueOf(first).toUpperCase() + name.substring(1, name.length());
            sb.append(name).append(" ");
        }
        return sb.toString().trim();
    }

    private static void preOrder(Node root, ArrayList<String> list) {
        list.add(root.getName());
        if (root.hasLeft()) {
            preOrder(root.getLeft(), list);
        }
        if (root.hasRight()) {
            preOrder(root.getRight(), list);
        }
    }

}

class Node {
    Node parent;
    Node left;
    Node right;
    String name;

    public Node(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public String getName() {
        return this.name;
    }

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}