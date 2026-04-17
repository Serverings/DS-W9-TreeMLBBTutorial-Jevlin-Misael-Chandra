package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeMLBBTutorial {

    static class ItemNode {
        String name;
        String note;
        List<ItemNode> children;

        ItemNode(String name, String note) {
            this.name = name;
            this.note = note;
            this.children = new ArrayList<>();
        }

        void addChild(ItemNode child) {
            children.add(child);
        }
    }

    static void printTree(ItemNode node, int level) {
        if (node == null) return;

        String indent = " ".repeat(level);
        System.out.println(indent + "- " + node.name + " -> " + node.note);

        for (ItemNode child : node.children) {
            printTree(child, level + 1);
        }
    }

    static void printAllBuildPaths(ItemNode node, List<String> path) {
        if (node == null) return;

        path.add(node.name);

        if (node.children.isEmpty()) {
            System.out.println(String.join(" -> ", path));
        } else {
            for (ItemNode child : node.children) {
                printAllBuildPaths(child, path);
            }
        }

        path.remove(path.size() - 1);
    }

    static int countNodes(ItemNode node) {
        if (node == null) return 0;

        int total = 1;
        for (ItemNode child : node.children) {
            total += countNodes(child);
        }
        return total;
    }

    static int countLeaves(ItemNode node) {
        if (node == null) return 0;
        if (node.children.isEmpty()) return 1;

        int total = 0;
        for (ItemNode child : node.children) {
            total += countLeaves(child);
        }
        return total;
    }

    static int height(ItemNode node) {
        if (node == null) return 0;
        if (node.children.isEmpty()) return 1;

        int maxChildHeight = 0;
        for (ItemNode child : node.children) {
            maxChildHeight = Math.max(maxChildHeight, height(child));
        }
        return 1 + maxChildHeight;
    }

    static boolean findPath(ItemNode node, String target, List<String> path) {
        if (node == null) return false;

        path.add(node.name);

        if (node.name.equalsIgnoreCase(target)) {
            return true;
        }

        for (ItemNode child : node.children) {
            if (findPath(child, target, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    static int countItemOccurrences(ItemNode node, String target) {
        if (node == null) return 0;

        int count = 0;

        if (node.name.equalsIgnoreCase(target)) {
            count++;
        }

        for (ItemNode child : node.children) {
            count += countItemOccurrences(child, target);
        }

        return count;
    }

    static void printPathsEndingWith(ItemNode node, List<String> path, String target) {
        if (node == null) return;

        path.add(node.name);

        if (node.children.isEmpty() && node.name.equalsIgnoreCase(target)) {
            System.out.println(String.join(" -> ", path));
        } else {
            for (ItemNode child : node.children) {
                printPathsEndingWith(child, path, target);
            }
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        ItemNode root = new ItemNode("Start Build", "Choose defensive path");

        // LEVEL 1
        ItemNode thunder = new ItemNode("Thunder Belt", "True damage + slow");
        ItemNode dominance = new ItemNode("Dominance Ice", "Anti heal & ASPD");
        ItemNode oracle = new ItemNode("Oracle", "Shield & regen");
        ItemNode athena = new ItemNode("Athena Shield", "Anti burst magic");
        ItemNode radiant = new ItemNode("Radiant Armor", "Anti magic DPS");
        ItemNode queens = new ItemNode("Queen's Wings", "Damage reduction");

        root.addChild(thunder);
        root.addChild(dominance);
        root.addChild(oracle);
        root.addChild(athena);
        root.addChild(radiant);
        root.addChild(queens);

        // TASK 1 (branch baru)
        ItemNode immortality = new ItemNode("Immortality", "Resurrection item");
        root.addChild(immortality);

        // ======================
        // THUNDER BELT
        // ======================
        ItemNode aresBelt = new ItemNode("Ares Belt", "HP component");
        ItemNode leather = new ItemNode("Leather Jerkin", "Armor");
        ItemNode cloak = new ItemNode("Magic Resist Cloak", "Magic resist");

        thunder.addChild(aresBelt);
        thunder.addChild(leather);
        thunder.addChild(cloak);

        ItemNode vitality = new ItemNode("Vitality Crystal", "Base HP");
        aresBelt.addChild(vitality);

        // TASK 5 (level tambahan)
        vitality.addChild(new ItemNode("Mini Crystal", "Basic resource"));

        // ======================
        // DOMINANCE ICE
        // ======================
        ItemNode blackIce = new ItemNode("Black Ice Shield", "Core item");
        dominance.addChild(blackIce);
        dominance.addChild(new ItemNode("Leather Jerkin", "Armor"));
        dominance.addChild(new ItemNode("Magic Resist Cloak", "Magic resist"));

        // ======================
        // ORACLE
        // ======================
        ItemNode vitality2 = new ItemNode("Vitality Crystal", "HP");
        oracle.addChild(new ItemNode("Hero's Ring", "Magic stat"));
        oracle.addChild(new ItemNode("Hero's Ring", "Magic stat"));
        oracle.addChild(vitality2);

        vitality2.addChild(new ItemNode("Mini Crystal", "Basic resource"));

        // ======================
        // ATHENA SHIELD
        // ======================
        ItemNode silence = new ItemNode("Silence Robe", "Magic resist + HP");
        ItemNode vitality3 = new ItemNode("Vitality Crystal", "HP");

        athena.addChild(silence);
        athena.addChild(vitality3);

        silence.addChild(new ItemNode("Vitality Crystal", "HP"));
        silence.addChild(new ItemNode("Magic Resist Cloak", "Magic resist"));

        // ======================
        // RADIANT ARMOR
        // ======================
        ItemNode silence2 = new ItemNode("Silence Robe", "Magic resist");
        radiant.addChild(silence2);
        radiant.addChild(new ItemNode("Magic Resist Cloak", "Magic resist"));
        radiant.addChild(new ItemNode("Healing Necklace", "Regen"));

        silence2.addChild(new ItemNode("Vitality Crystal", "HP"));
        silence2.addChild(new ItemNode("Magic Resist Cloak", "Magic resist"));

        // ======================
        // QUEEN'S WINGS
        // ======================
        ItemNode ares2 = new ItemNode("Ares Belt", "HP");
        queens.addChild(ares2);
        queens.addChild(new ItemNode("Hero's Ring", "Magic stat"));
        queens.addChild(new ItemNode("Expert Gloves", "Attack stat"));

        ItemNode vitality6 = new ItemNode("Vitality Crystal", "HP");
        ares2.addChild(vitality6);
        vitality6.addChild(new ItemNode("Mini Crystal", "Basic resource"));

        // ======================
        // IMMORTALITY
        // ======================
        immortality.addChild(new ItemNode("Ares Belt", "HP"));
        immortality.addChild(new ItemNode("Vitality Crystal", "HP"));
        immortality.addChild(new ItemNode("Leather Jerkin", "Armor"));

        // ======================
        // OUTPUT
        // ======================
        System.out.println("=== TREE STRUCTURE ===");
        printTree(root, 0);

        System.out.println("\n=== ALL BUILD PATHS ===");
        printAllBuildPaths(root, new ArrayList<>());

        System.out.println("\nTotal Nodes: " + countNodes(root));
        System.out.println("Total Leaves: " + countLeaves(root));
        System.out.println("Height: " + height(root));

        // TASK 2 OUTPUT
        System.out.println("\nMagic Resist Cloak muncul: " +
                countItemOccurrences(root, "Magic Resist Cloak"));

        // TASK 3 OUTPUT
        System.out.println("\n=== PATH ENDING WITH IMMORTALITY ===");
        printPathsEndingWith(root, new ArrayList<>(), "Immortality");

        // TASK 4 (INPUT USER)
        Scanner sc = new Scanner(System.in);

        System.out.print("\nMasukkan item yang ingin dicari: ");
        String input = sc.nextLine();

        List<String> path = new ArrayList<>();

        if (findPath(root, input, path)) {
            System.out.println("Path ditemukan:");
            System.out.println(String.join(" -> ", path));
        } else {
            System.out.println("Item tidak ditemukan.");
        }

        sc.close();
    }
}