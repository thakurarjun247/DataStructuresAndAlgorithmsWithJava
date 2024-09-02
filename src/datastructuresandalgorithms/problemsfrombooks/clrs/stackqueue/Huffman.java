package datastructuresandalgorithms.problemsfrombooks.clrs.stackqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        Huffman h = new Huffman();
   /*     String[] words = {"zero", "one", "three"};
        Integer[] freq = {50, 10, 990};
*/
        String[] words = {"zero"/*, "one", "two", "three", "four","five"*/};
        Integer[] freq = {0/*, 1, 2, 3, 4, 5*/};
        HuffmanNode node = h.generateTree(words, freq);
        h.generateHuffmanCodes(node, "");

    }
}

public class Huffman {
    void generateHuffmanCodes(HuffmanNode root, String code) {
        if (root.left == null && root.right == null)
            System.out.println(root.word + " -> " + code);
        else {
            generateHuffmanCodes(root.left, code + "0");
            generateHuffmanCodes(root.right, code + "1");
        }
    }

    HuffmanNode generateTree(String[] words, Integer[] freq) {
        int n = words.length;
        HuffmanNode[] nodes = new HuffmanNode[n];

        //for huffman we need a min priority q which is java the default
        //we still need a comparator since Huffman code is a custom type
        //and java needs to know how to compare two custom objects of type Huffman
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>(new DecreasingOrderComparator());
        for (int i = 0; i < n; i++) {
            //nodes[i]=new HuffmanNode(words[i], freq[i]);
            minHeap.add(new HuffmanNode(words[i], freq[i]));
        }
        //we need at least two elements to add them
        while (minHeap.size() >= 2) {
            HuffmanNode first = minHeap.poll();
            HuffmanNode second = minHeap.poll();
            HuffmanNode parent = new HuffmanNode(null, first.frequency + second.frequency, first, second);
            minHeap.add(parent);
        }
        return minHeap.poll();
    }

    class DecreasingOrderComparator implements Comparator<HuffmanNode> {
        @Override
        public int compare(HuffmanNode o1, HuffmanNode o2) {
            return o1.frequency - o2.frequency;
        }
    }


}

class HuffmanNode {
    String word;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode() {
    }

    public HuffmanNode(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public HuffmanNode(String word, int frequency, HuffmanNode left, HuffmanNode right) {
        this.word = word;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}