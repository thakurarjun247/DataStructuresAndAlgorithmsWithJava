package algorithms.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NewHuffManImplementation2024 {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 5);
        map.put("lmn", 1);
        map.put("xyz", 2);
        map.put("pqr", 2);
       MyHuffmanNode root= new HuffmanEncodingDecoding().buildTree(map);



    }
}

class HuffmanEncodingDecoding {
    public MyHuffmanNode buildTree(Map<String, Integer> wordFrequencies) {
        if(wordFrequencies==null || wordFrequencies.size()==0)
            return null;
        //index 0 is word
        //index 1 is freq
        //put the words on the priority queue based on the frequency
        //the least frequency first.

        PriorityQueue<MyHuffmanNode> priorityQueue = new PriorityQueue<>((a, b) -> a.frequency() - b.frequency());
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet())
            priorityQueue.add(new MyHuffmanNode(entry.getKey(), entry.getValue(), null, null));
        while (priorityQueue.size()>=2){
            MyHuffmanNode left= priorityQueue.poll();
            MyHuffmanNode right= priorityQueue.poll();
            MyHuffmanNode parent= new MyHuffmanNode(null, left.frequency()+right.frequency(),left,right           );
            priorityQueue.add(parent);
        }
        return priorityQueue.poll();
    }
}

record MyHuffmanNode(
        String word,
        int frequency,
        MyHuffmanNode left,
        MyHuffmanNode right) {

}