package com.moulik.collections.dheeru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Map Interface:
 * 1. When fast-lookup by key matters, eg data cache
 * 2. Also called associative array
 * 3. No duplicate key, duplicate values are fine
 * 4. 1 key maps to atmost 1 value
 * 5. null keys and null values are implementation dependent
 * 6. AbstractMap
 * 
 * public interface Map<K, V> {
 * 
 * 	//Basic Operations:
 * 	V put(K key, V value);
 * 	V get(Object key);
 * 	V remove(Object key);
 * 	boolean containsKey(Object key);
 * 	boolean containsValue(Object value);
 * 	int size();
 * 	boolean isEmpty();
 * 
 * put(key, value) inserts mapping with key-value. If there was already a mapping with same key, then value in that key
 * will be overwritten. The old value is returned by the method. In case of new mapping, null is returned.
 * However, if the map implementation allows null value and there is a matching key with null value, then also that null 
 * value will be returned. In this case, we cannot tell whether the returned null value was because of entirely new
 * mapping or it was due to overwriting an existing mapping which had null value. To distinguish these two cases, we
 * can invoke the containsKey()
 * 
 * 	//Bulk Operations:
 * 	void putAll(Map<? extends K, ? extends V> map);
 * 	void clear();
 * 
 * 	//CollectionView Operations:
 * 	Set<K> keySet();
 * 	Collection<V> values();
 * 	Set<Map.Entry<K,V>> entrySet();
 * 
 * 	public interface Entry {
 * 		K getKey();
 * 		V getValue();
 * 		V setValue(V value);
 * 	}
 * 
 * 	Returned set in keySet() is backed by the original map. Same goes for values() collection.
 * 
 * }
 * 
 * Note: Exercise great care if keys are mutable objects. Better to use immutable objects like String for keys because
 * using mutable objects can cause uncertain behavior for certain operations.
 * First time, when an add an object as the key of a map, it calculates the hashcode, finds the bucket and inserts the
 * element. If we change the state of the object and then try to get the value for that particular mutable object key,
 * again hashcode is calculated but this time the hashcode value will be different than the previous hashcode and the
 * value for the key would be null.
 * In case we use a class where we do not override the hashcode(), equals(), then we are fine to use them as keys. 
 * This is because in that case, Object methods are invoked which return memory addresses and memory addresses remain
 * constant and hence do not change state.
 * 	
 * HashMap:
 * 1. fast lookup, addition and deletion ~ get, put, remove ~ O(1)
 * 2. Insertion order is not preserved
 * 3. Permits null values and 1 null key
 * 4. Methods are not synchronized unlike java.util.Hashtable.
 */
public class MapHashMapDemo17 {
	
	private static void hashMapDemo() {
		System.out.println("\n\nInside hashMapDemo ...");
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("John", 25);
		map1.put("Raj", 29);
		map1.put("Anita", null);
		
		System.out.println(map1);
		
		map1.put("Anita", 23);
		System.out.println(map1);
		
		System.out.println("Contains John? " + map1.containsKey("John"));
		System.out.println("John's age: " + map1.get("John"));
		
		System.out.println("Iterating using keySet ...");
		Set<String> names = map1.keySet();
		for (String name : names) {
			System.out.println("Name: " + name + ", Age: " + map1.get(name));
		}
		
		System.out.println("Iterating using entrySet ...");
		Set<Map.Entry<String, Integer>> mappings = map1.entrySet();
		for (Map.Entry<String, Integer> mapping : mappings) {
			System.out.println("Name: " + mapping.getKey() + ", Age: " + mapping.getValue());
		}
		
		names.remove("Anita");
		System.out.println(map1);
		
		//A new map of Name-Profile
		Map<String, Map<String, Object>> userProfile = new HashMap<>();
		
		Map<String, Object> profile = new HashMap<>();
		profile.put("age", 25);
		profile.put("dept", "CS");
		profile.put("city", "New York");
		
		userProfile.put("John", profile);
		
		profile = new HashMap<>();
		profile.put("age", 29);
		profile.put("dept", "CS");
		profile.put("city", "New York");
		
		userProfile.put("Raj", profile);
		
		System.out.println("userProfile: " + userProfile);
		
		Map<String, Object> profile1 = userProfile.get("John");
		int age = (Integer) profile1.get("age");
		System.out.println("Age: " + age);
		// Exercise: Try using second constructor, putAll, clear, values, and other methods
	}
		
	private static void immutableKeysDemo() {
		System.out.println("\n\nInside immutableKeysDemo ...");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		Map<List<Integer>, Integer> map = new HashMap<>();
		map.put(list, 1);
		
		list.add(2);
		System.out.println(map.get(list));
		
		Student s = new Student(1, null);
		Map<Student, Integer> map2 = new HashMap<>();
		map2.put(s, 1);
		
		s.setName("John");
		System.out.println(map2.get(s));
	}
		
	public static void main(String[] args) {
		// hashMapDemo();	
		immutableKeysDemo();
	}

}
class Student {	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
