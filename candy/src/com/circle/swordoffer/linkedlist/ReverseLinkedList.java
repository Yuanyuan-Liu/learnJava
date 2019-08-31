package com.circle.swordoffer.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        /*ListNode p = listNode;
        int i = 1;
        while (i<=5){
            ListNode listNode1 = new ListNode(i);
            p.next = listNode1;
            p = listNode1;
            i++;
        }*/

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        System.out.println(Arrays.toString(reverseLinkedList.printListFromTailToHead(listNode.next).toArray()));
        System.out.println("--------------------------");
        System.out.println(Arrays.toString(reverseLinkedList.printList(listNode.next).toArray()));
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if(listNode==null){
            return new ArrayList<>();
        }

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode p = listNode;

        while(p!=null){
            stack.push(p.val);
            p = p.next;
        }

        while(!stack.empty()){
            arrayList.add(stack.pop());
        }

        return arrayList;
    }

    /**
     * 采用递归的方法，来实现链表的反转
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printList(ListNode listNode){

        if (listNode == null ) {
            return new ArrayList<>();
        }

        //使用递归实现，先加入链表后面的结点，再加入当前结点
        ArrayList<Integer> arrayList = new ArrayList<>();

        if(listNode != null) {
            arrayList.addAll(printList(listNode.next));//先递归
            arrayList.add(listNode.val);//再加入当前
        }

        return arrayList;
    }

}
