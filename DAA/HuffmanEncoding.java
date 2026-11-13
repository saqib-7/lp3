import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanEncoding {

    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    static void printCodes(Node root, String code) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + (code.isEmpty() ? "0" : code));
            return;
        }
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (int i = 0; i < n; i++) {
            System.out.print("Character " + (i + 1) + ": ");
            char ch = sc.next().charAt(0);
            System.out.print("Frequency of " + ch + ": ");
            int f = sc.nextInt();
            pq.add(new Node(ch, f, null, null));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Node('-', left.freq + right.freq, left, right));
        }

        System.out.println("\nHuffman Codes:");
        printCodes(pq.peek(), "");
        sc.close();
    }
}
