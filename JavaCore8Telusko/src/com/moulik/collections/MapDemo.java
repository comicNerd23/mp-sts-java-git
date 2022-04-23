package com.moulik.collections;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 	Map (4-8-3-3-3-2-2 = 25): A DS that maps keys to values. It cannot contain duplicate keys; 
 * 	Each key can map to atmost one value.
 * 
 * 				int					size()
 * 				boolean 			isEmpty()
 * 				boolean 			containsKey(Object k)
 * 				boolean 			containsValue(Object v)
 * 
 * 				V			 		get(Object k)
 * 				V 					put(K key, V Value)
 * 				V		 			remove(Object k)
 * 
 * 	default		V					putIfAbsect(K k, V v)
 * 	default		V					getOrDefault(Object k, V defVal)
 *	default		boolean				remove(Object k, Object v)
 *	default		V					replace(K k, V v)
 * 	default		boolean				replace(K k, V oldV, V newV)
 * 
 *				Set<K> 				keySet()
 * 				Collection<V>		values()
 * 				Set<Map.Entry<K,V>	entrySet()
 * 
 *				void				clear()
 *				void				putAll(Map<? extends K, ? extends V> map)
 *	default		void				replaceAll(BiFunction<? extends K, ? extends V> biFunction)
 *
 *	default		V					compute(K k, BiFunction<? extends K, ? extends V> biFunction)
 *	default		V					computeIfAbsent(K k, BiFunction<? extends K, ? extends V> biFunction)
 *	default		V					computeIfPresent(k k, BiFunction<? extends K, ? super V, ? extends V> biFunction)
 *
 *	default		void		 		forEach(BiConsumer<? super K, ? super V> action)
 *	default		V			 		merge(K k, V v, BiFunction<? extends K, ? super V, ? extends V> biFunction)
 *
 *				boolean				equals(Object o)
 *				int					hashCode()
 *
 *
 *	Map.Entry	(2-3 = 5)
 *
 *				boolean				equals(Object o)
 *				int					hashCode()
 *
 *				K					getKey()
 *				V					getValue()
 *				V					setValue()
 *
 *
 *	Map Classes:
 *		AbstractMap
 *		EnumMap
 *		HashMap
 *		TreeMap
 *		WeakHashMap
 *		LinkedHashMap
 *		IdentityHashMap
 *
 *	Map does not have a stream() method like Collection.stream() but we use below to work on it using streams.
 *	
 *	Stream<Map.Entry<a, b>> entriesStream = entries.stream(); 
 *	Stream<a> keysStream = keySet.stream();
 *	Stream<b> valuesStream = values.stream();
 *
 */
public class MapDemo {

	public static void main(String[] args) {

		//Java 9: Map.of creates an unmodifiable map
		Map<String,String> rollNumbersMap =	
				Map.of("Moulik","1810701","Puneet","1810397","Bhuwan","1810707","Shivam","1810399","Meenu","1810708");
		
		//Prints the map entries
		rollNumbersMap.entrySet().stream()
			.forEach( x -> System.out.println(x));
		
		System.out.println("--------------------------");
		
		//Prints the map entries in a sorted order (ascending)
		rollNumbersMap.entrySet().stream()
			.sorted( (a,b) -> a.getKey().compareTo(b.getKey()) )
			.forEach( x -> System.out.println(x));
		
		System.out.println("--------------------------");
		
		//Prints the map of student-rollNumber based on values greater than 1810700
		rollNumbersMap.entrySet().stream()
			.filter( (a) -> Integer.parseInt(a.getValue()) > 1810700)
			.forEach( x -> System.out.println(x));
		
		System.out.println("--------------------------");
		
		// Get a list of names (keys) whose rollNumbers (values) less than 1810700
		List<String> names = rollNumbersMap.entrySet().stream()
			.filter((a) -> Integer.parseInt(a.getValue()) < 1810700)
			.map(Map.Entry :: getKey )	//same as .map(x -> x.getKey())
			.collect(Collectors.toList());
		System.out.println(names);

		System.out.println("--------------------------");
		
		// Get a list of rollNumbers for students whose name start with M
		List<String> rollNumbers = rollNumbersMap.entrySet().stream()
			.filter((a) -> a.getKey().startsWith("M") )
			.map(Map.Entry :: getValue )	//same as .map(x -> x.getValue())
			.collect(Collectors.toList());
		System.out.println(rollNumbers);

		System.out.println("--------------------------");
	}

}
