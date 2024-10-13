package com.example.project;

public class QueueStackTester {
    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq)
    {
        // Write the recursive static method split that splits a queue of n elements into two
        // queues. The elements with odd orders (i.e. 1st, 3rd, 5th ...) should be put in the
        // first queue and elements with even orders (i.e. 2nd, 4th, 6th ...) should be put in
        // the second queue. The original queue should remain unchanged at the end of the
        // method.
        // Example. Given the queue (A, B, C, D, E), split results in oq (A, C, E), and eq(B, D).
    	if(q.length() == 0)
    		return;
    	int length = q.length();
    	T tmp;
    	for(int i = 1; i < length + 1; i++) {
    		tmp = q.serve();
    		if(i % 2 == 0)
    			eq.enqueue(tmp);
    		else
    			oq.enqueue(tmp);
    		q.enqueue(tmp);
    	}
    }
    
    public static <T> void remove(LinkedPQ<T> pq, int p)
    {
        // Write a static method remove that removes every element in the priority queue
        // having priority less than p.
        // Example. Given pq: [A, 10], [D, 8], [B, 5], [E, 3], [C, 2] remove(pq, 5) results in
        // pq: [A, 10], [D, 8], [B, 5].
    	if(pq.length() == 0)
    		return;
    	int length = pq.length();
    	PQElement<T> pqe;
    	LinkedPQ<T> tmpQ = new LinkedPQ<T>();
    	for(int i = 0; i < length; i++) {
    		pqe = pq.serve();
    		if(pqe.p >= p)
    			tmpQ.enqueue(pqe.data, pqe.p);
    	}
    	length = tmpQ.length();
    	for(int i = 0; i < length; i++) {
    		pqe = tmpQ.serve();
    		pq.enqueue(pqe.data, pqe.p);
    	}
    }
    
    public static <T> boolean search(Stack<T> st, T e)
    {
        throw new UnsupportedOperationException("Not supported yet.");
        // Write the recursive static method search that searches for an element e in a stack st
        // and returns true if it’s found or false otherwise. st should not change at the end of
        // the method. You are not allowed to use any auxiliary data structures.
        // Example. Given the stack st (top-to-bottom): 5, 7, 5, 3, 2. search(st, 3) returns
        // true while search(st, 1) returns false.
    }
    
    public static boolean isOrdered(Queue<Integer> q) {
    	boolean flag = true;
    	int e1 = q.serve();
    	q.enqueue(e1);
    	for (int i = 1; i < q.length(); i++) {
    		int e2 = q.serve();
    		q.enqueue(e2);
    		if(e1 > e2)
    			flag = false;
    		e1 = e2;
    	}
    	return flag;
    }
    
    public static int stackSum(Stack<Integer> st) {
    	if(st.empty())
    		return 0;
    	int x = st.pop();
    	int y = stackSum(st);
    	st.push(x);
    	return x + y;
    }
    
    public static <T> void printQueue(Queue<T> q) {
    	T tmp;
    	int length = q.length();
    	for(int i = 0; i < length; i++) {
    		tmp = q.serve();
    		if(i != length - 1)
    			System.out.print(tmp + " -> ");
    		else
    			System.out.println(tmp);
    		q.enqueue(tmp);
    	}
    }
    
    public static <T> void printPQ(LinkedPQ<T> pq) {
    	PQElement<T> tmp;
    	LinkedPQ<T> tmpQ = new LinkedPQ<T>();
    	int length = pq.length();
    	for(int i = 0; i < length; i++) {
    		tmp = pq.serve();
    		if(i != length - 1)
    			System.out.print("[" + tmp.data + ", " + tmp.p + "] -> ");
    		else
    			System.out.println("[" + tmp.data + ", " + tmp.p + "]");
    		tmpQ.enqueue(tmp.data, tmp.p);
    	}
    	
    	for(int i = 0; i < length; i++) {
    		tmp = tmpQ.serve();
    		pq.enqueue(tmp.data, tmp.p);
    	}
    }
    
    public static void main(String args[]) {
    	LinkedPQ<Character> pq = new LinkedPQ<Character>();
    	pq.enqueue('A', 10);
    	pq.enqueue('B', 5);
    	pq.enqueue('C', 2);
    	pq.enqueue('D', 8);
    	pq.enqueue('E', 3);
    	System.out.print("Before: ");
    	printPQ(pq);
    	remove(pq, 5);
    	System.out.print("After: ");
    	printPQ(pq);
    }
}