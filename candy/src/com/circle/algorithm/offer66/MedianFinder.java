package com.circle.algorithm.offer66;

import java.util.PriorityQueue;
/*可使用两个有限队列实现，一个是最大堆，一个是最小堆,小顶堆的元素个数要么比大顶堆的多一个，要么一样多
1、两堆中元素个数为偶数时，将该元素入大顶堆，将大顶堆的出队元素入小顶堆
2、两堆中元素个数为奇数时，将该元素入小顶堆，将小顶堆的出对元素入大顶堆
返回：
1、元素个数为偶数，返回大顶堆和小顶堆堆顶元素的平均数
2、元素个数为奇数，返回小顶堆的堆顶元素
*/
public class MedianFinder {

    private int count;
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.count = 0;
        this.maxHeap = new PriorityQueue<>((t1,t2)->t2-t1);
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(count % 2 == 0){
            maxHeap.offer(num);
            int tmp = maxHeap.poll();
            minHeap.offer(tmp);
        }else{
            minHeap.offer(num);
            int tmp = minHeap.poll();
            maxHeap.offer(tmp);
        }
        count++;
    }

    public double findMedian() {
        if(minHeap.size() == 0){
            return 0;
        }
        if(maxHeap.size() == 0){
            return minHeap.peek();
        }
        if(count % 2 == 0){
            return (double)((maxHeap.peek() + minHeap.peek())/2.0);
        }else{
            return (double)minHeap.peek();
        }
    }
}
