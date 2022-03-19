package br.com.algorithms.data.structures.hashtable;

public class HashNode<K, V> {
	
	K key;
	V value;
	final int hashcode;
	HashNode<K, V> next;
	
	public HashNode(K key, V value, int hashcode, HashNode<K, V> next) {
		this.key = key;
		this.value = value;
		this.hashcode = hashcode;
		this.next = next;
	}
}
