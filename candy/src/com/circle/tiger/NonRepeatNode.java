package com.circle.tiger;

import com.circle.sogou.Entry;

import java.util.*;

class Node {
    public int val;
    public Node next;
}

public class NonRepeatNode {
    public static void removeRepeatNode(Node nodelist) {
        Map<Integer, Integer> mapNodeCount = new HashMap<>();
        Set<Integer> setNodeVal = new HashSet<>();
        while (nodelist != null) {
            setNodeVal.add(nodelist.val);
            nodelist = nodelist.next;
        }
        int count = 0;

        for (Integer intObj : setNodeVal) {
            while (nodelist != null) {
                if (nodelist.equals(intObj)) {
                    count++;
                }
                nodelist = nodelist.next;
            }

            if (count == 1) {
                mapNodeCount.put(intObj, count);
                count = 0;
            }
        }

        Node node = new Node();
        for (Map.Entry<Integer, Integer> entry : mapNodeCount.entrySet()) {
            Integer value = entry.getValue();
            Integer key = entry.getKey();

            if(value == 1){
                node.val = key;
                node.next = null;
            }
        }
    }

}