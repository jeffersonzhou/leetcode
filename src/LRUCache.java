/*
Design and implement a data structure for Least Recently Used(LRU) cache. It should support the 
following operations: get and set.
get(key)-Get the value(will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key,value)-Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */

//1. Use double linked list as cache to increase add and delete operation
//2. Use hashmap to store key and its node position

import java.io.*;

public class LRUCache {
    public List cache;
    private int capacity;
    private int size;
    public HashMap<K,ListNode<K,V>> cacheMap;
    
    public LRUCache(){
	LRUCache(100);
    }

    public LRUCache(int size){
	this.size=size;
	cache=new List(size);
	cacheMap=new HashMap<K,ListNode<K,V>>();
	this.capacity=0;
    }

    //Get(key): get the value of the key if the key exists in the cache, otherwise return -1
    public V get(K key){
	ListNode<K,V> node=cacheMap.get(key);
	if(node==null){
	    return (V)-1;
	}else{
	    return node.getValue(key);
	}
    }
    //Set(key,value): set or insert the value if the key is not already present.
    public void set(K key, V value){
	ListNode<K,V> node=cacheMap.get(key);
	if(node!=null)
	    return;
	if(capacity<size){
	    node=cache.getSentinal().next;
	    node.setKey(key);
	    node.setValue(value);
	    cacheMap.put(key,node);
	    cache.getSentinal().next=node.prev;
	    cache.getSentinal().prev=node.next;
	    capacity++;
	}else if(capacity==size){
	    node=cache.getSentinal().next;
	    cacheMap.remove(node.getKey());
	    node.setKey(key);
	    node.setValue(value);
	    cacheMap.put(key,node);
	    cache.getSentinal().next=node.prev;
	    cache.getSentinal().prev=node.next;
	}
    }
}

class List{

    private int size;
    private int defaultSize=100;
    private ListNode<K,V> sentinal;

    public List(int size){
	if(size<defaultSize){
	    this.size=defaultSize;
	}else{
	    this.size=size;
	}
	ListNode<K,V> head=new ListNode<K,V>();
	//ListNode<K,V> tail=new ListNode<K,V>();
	sentinal=new ListNode<K,V>();
	//sentinal.next=tail;
	sentinal.prev=head;
	for(int i=2;i<=size;i++){
	    ListNode<K,V> temp=new ListNode<K,V>();
	    head.next=temp;
	    temp.prev=head;
	    head=head.next;
	}
	sentinal.next=head;
	sentinal.pre.prev=sentinal.next;
	sentinal.next.next=sentinal.prev;
	//head=sentinal.prev;
    }

    public int getSize(){
	return size;
    }

    public ListNode<K,V> add(K key, V value){

    }
    
    public V delete(K key){
	
    }
    
    public ListNode<K,V> getSentinal(){
	return sentinal;
    }
}

class ListNode<K,V> {
    private K key;
    private V value;
    ListNode<V> prev;
    ListNode<V> next;
    
    public void setKey(K key){
	this.key=key;
    }
    public void setValue(V v){
	this.value=v;
    }
    
    public K getKey(){
	return key;
    }
    public V getValue(){
	return value;
    }
    
}
