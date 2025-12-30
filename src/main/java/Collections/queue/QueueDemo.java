package Collections.queue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        // queue: first element in, first element out
        // deque: insertion & deletion can happen at both ends

        /**
         * LinkedList as Queue: FIFO
         * allows null
         * moderate
         * */
        Queue<String> queue = new LinkedList<>();
        // create or add
        queue.offer("test333");
        queue.add("test1");
        queue.offer("test22");

        System.out.println("queue before updating: " + queue);

        // sorting LinkedList queue
        // 1. by converting to priority queue
        Comparator<String> lengthComparator = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        Queue<String> pQ = new PriorityQueue<>(lengthComparator);
        System.out.println("sorting by converting linkedList q to prioQ: ");
        pQ.addAll(queue);
        System.out.println("after sorting with priority que: ");
        while (!pQ.isEmpty()) {
            System.out.println(pQ.poll() + " ");
        }
        // update = remove + add
        queue.remove("test2");
        queue.add("test2 -updated");
        System.out.println("queue after updating: " + queue);

        // read or peek : what's the head pointing at
        System.out.println("first element is: " + queue.peek());

        // delete or poll
        System.out.println("removing the first element of the AL dq: " + queue.poll());
        System.out.println("after removing the first element: " + queue);

        // contains
        System.out.println("does queue contains test2 ? " + queue.contains("test2"));

        // Iterate
        System.out.println("iterating over queue: ");
        // iterating with the forEach would result in inconsistent performance
//        for (String s : queue) {
//            System.out.println("removing: " + s);
//            queue.remove(s);
//        }
        Iterator<String> it = queue.iterator();
        while (it.hasNext()) {
            System.out.println("removing :" + it.next());
            it.remove();
        }
        System.out.println("after removing all: " + queue);
        /**
         * PriorityQueue: elements are kept in sorted order
         * no nulls since null cant be sorted
         * fast for priority among ques since front & rear are maintained as pointers, this helps in navigation
         *
         *  */
        Queue<Integer> prioQ = new PriorityQueue<>();
        // add & offer
        prioQ.add(10);
        prioQ.add(7);
        prioQ.add(9);
        prioQ.add(8);
        // peek()
        if (prioQ.offer(5)) {
            System.out.println("element added to queue: " + prioQ.peek());
        }
        // contains
        System.out.println("does q contains 5? " + prioQ.contains(5));
        // iterate
        Iterator<Integer> intIt = prioQ.iterator();
        System.out.println("iterating over priority queue: ");
        while (intIt.hasNext()) {
            System.out.println(intIt.next());
        }
        // sort: prioQ maintains the sorted order
        // remove(), poll()
        System.out.println("removing the elements from prioQ: ");
        while (!prioQ.isEmpty()) {
            System.out.println("removing: " + prioQ.poll());
        }
        //
        /**
         * ArrayDeque: Double ended queue with array as base DS
         * no Nulls
         * fastest
         * */
        Deque<String> arrDQ = new ArrayDeque<>();
        // add or offer
        arrDQ.add("first");
        arrDQ.add("second");
        arrDQ.add("third");
        arrDQ.offer("fourth");
        // offerFirst() & offerLast()
        arrDQ.offerFirst("zero");
        arrDQ.offerLast("n");
        System.out.println("arrDQ is : " + arrDQ);
        // remove or poll
        arrDQ.remove("third");
        System.out.println("After removing third: " + arrDQ);
        // poll
        System.out.println("after poll: < removes first element from Q: " + arrDQ.poll() + " \n after Q becomes: " + arrDQ);
        System.out.println("lets remove first from Q: " + arrDQ.pollFirst() + "\n Q becomes: " + arrDQ);
        System.out.println("lets remove last from Q: " + arrDQ.pollLast() + " \n arrayDQ becomes " + arrDQ);
//        System.out.println(arrDQ);
        // contains
        System.out.println("does arrayDQ contains third? " + arrDQ.contains("third"));
        // sort
        System.out.println("sorting Q: ");
        ArrayList<String> al = new ArrayList<>(arrDQ);
        Collections.sort(al);
        System.out.println("Sorted elements from arrDQ: " + al);

        // Iterate
        Iterator<String> itStr = arrDQ.iterator();
        System.out.println("arrDQ contains: ");
        while (itStr.hasNext()) {
            System.out.println(itStr.next());
            itStr.remove();
        }
        System.out.println("null: " + arrDQ.poll());
        arrDQ.push("str1");
        System.out.println("after pushing: " + arrDQ);
        arrDQ.pop();
        System.out.println("removing all " + arrDQ);

        Queue<Integer> q = new ArrayBlockingQueue<>(10);
    }
}
