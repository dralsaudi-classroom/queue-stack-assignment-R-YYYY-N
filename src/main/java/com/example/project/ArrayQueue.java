package com.example.project;

public class ArrayQueue<T> implements Queue<T> {
    private int maxsize;
    private int size;
    private int head, tail;
    private T[] nodes;

    /** Creates a new instance of ArrayQueue */
    public ArrayQueue(int n) {
        maxsize = n;
        size = 0;
        head = tail = 0;
        nodes = (T[]) new Object[n];
    }
    public boolean full () {
        return size == maxsize;
    }
    
    public int length () {
        return size;
    }
    public void enqueue(T e) {
        nodes[tail] = e;
        tail = (tail + 1) % maxsize;
        size++;
    }
    public T serve () {
        T e = nodes[head];
        head = (head + 1) % maxsize;
        size--;
        return e;
    }
    
    public void print() {
    	int tmp = head;
    	for(int i = 0; i < size; i++) {
    		System.out.println(nodes[tmp]);
    		tmp = (tmp + 1) % maxsize;
    	}
    }
}