package com.mimi.datastruct.map;

class Entry<K, V> {
	K key;
	V value;
	Entry<K, V> next; // 表示指针 我只写链表
	int cap; // 表示hash冲突的个数

	public Entry(K key, V value, Entry<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}

}

public class MyHashMap<K, V> {
	// 定义一个默认的空间 存多少个数据

	private static final int DEFAULT_SIZE = 1 << 4; // 其实是2网左移4位 就是16 10000
	private Entry<K, V>[] data; // 存数据的hash表
	private int capacity; // 空间 会扩容的
	private int size = 0; // 大小

	public MyHashMap() {
		this(DEFAULT_SIZE);
	}

	public MyHashMap(int capacity) {
		if (capacity <= 0)
			capacity = DEFAULT_SIZE;
		this.capacity = capacity;
		data = new Entry[capacity];
	}

	public void put(K key, V value) {
		// HashMap key可以为null吗？ value 呢？
		if (key == null)
			return;
		int hash = hash(key); // 取hash
		// if(size >= 0.75*capacity)
		// resize 会把所有的数据重新计算一次 会清空
		
		Entry<K, V> newE = new Entry<K, V>(key, value, null); // 表示新进来一个数据
		// 判断有没有hash冲突
		Entry<K, V> hashM = data[hash];
		while (hashM != null) { // 表示有hash冲突
			if (hashM.key.equals(key)) { // 表示是一样的key 覆盖 1->2 1->3 那就变成3了
				hashM.value = value;
				return;
			}
			hashM = hashM.next; // 链表后移
		}
		//少了一个红黑树 就是这个hashM空间大于等于8
		//TreeMap
		newE.next = data[hash]; // 表示加入链表 这样就加在了链表的头
		data[hash] = newE;
		size++;
	}

	public V get(K key) {
		int hash = hash(key);
		Entry<K, V> entry = data[hash];
		// 链表遍历取数据
		while (entry != null) {
			if (entry.key.equals(key)) {	//key 的hashCode 和value比较的时候究竟怎么用找value的时候用equals，并不是hashCode一样.
				return entry.value;
			}
			entry = entry.next;
		}
		return null;
	}

	private int hash(K key) { // JDK自己测试出来的 我也不知道怎么就这么好用
		int h = 0;
		if (key == null)
			h = 0;
		else {
			h = key.hashCode() ^ (h >>> 16); // 无符号右移16位
		}
		return h % capacity;
	}

	public static void main(String[] args) {
		MyHashMap<String, String> map = new MyHashMap<>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		System.out.println(map.get("1"));
		System.out.println(map.get("4"));
		//ThreadPoolExecutor  线程池
		//Executor executor 
		//设计模式 单例模式
		//数据结构与算法+Java基础+设计模式
		//hashCode相等的 值就一定相等吗？ 不一定 所以在得出value的是要用equls
	}

}
