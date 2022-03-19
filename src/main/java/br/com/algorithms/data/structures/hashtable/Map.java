package br.com.algorithms.data.structures.hashtable;

import java.util.ArrayList;
import java.util.Objects;

public class Map<K, V> {
	
	private ArrayList<HashNode<K, V>> bucket;
	private int bucketCapacity;
	private int size;
	
	public Map() {
		bucket = new ArrayList<>();
		bucketCapacity = 10;
		size = 0;
		
		for (int i = 0; i < bucketCapacity; i++) {
			bucket.add(null);
		}
	}
	
	public int size() {return size;}
	
	public boolean isEmpty() {return size() == 0;}
	
	private int hashCode(K key) {
		return Objects.hashCode(key);
	}
	
	private int getBucketIndex(K key) {
		int hashcode = hashCode(key);
		int index = hashcode % bucketCapacity;
		index = index < 0 ? index * -1 : index;
		return index;
	}
	
	public void add(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		int hashcode = hashCode(key);
		
		HashNode<K, V> head = bucket.get(bucketIndex);
		
		while (head != null) {
			if (head.key == key && head.hashcode == hashcode) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		size++;
		head = bucket.get(bucketIndex);
		HashNode<K, V> newNode = new HashNode<>(key, value, hashcode, head);
		bucket.set(bucketIndex, newNode);
		
		if (((1.0 * size) / bucketCapacity) >= 0.7) {
			ArrayList<HashNode<K, V>> temp = bucket;
			bucket = new ArrayList<>();
			bucketCapacity = 2 * bucketCapacity;
			size = 0;
			for (int i = 0; i < bucketCapacity; i++) {
				bucket.add(null);
			}
			for (HashNode<K, V> headNode : temp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
	}
	
	public V get(K key) {
		int bucketIndex = getBucketIndex(key);
		int hashcode = hashCode(key);
		
		HashNode<K, V> head = bucket.get(bucketIndex);
		
		while (head != null) {
			if (head.key == key && head.hashcode == hashcode) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	
	public V remove(K key) {
		int bucketIndex = getBucketIndex(key);
		int hashcode = hashCode(key);
		
		HashNode<K, V> head = bucket.get(bucketIndex);
		HashNode<K, V> prev = null;
		while (head != null) {
			if (head.key == key && head.hashcode == hashcode) {
				break;
			}
			prev = head;
			head = head.next;
		}
		
		if (head == null) {
			return null;
		}
		
		if (prev != null) {
			prev.next = head.next;
		}
		
		bucket.set(bucketIndex, head.next);
		
		return head.value;
	}
}
