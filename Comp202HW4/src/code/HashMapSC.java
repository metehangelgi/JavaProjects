/*
 * Student: 
 * Written By Metehan Gelgi 64178
 * 
 */

package code;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.*;

import given.AbstractHashMap;
import given.HashEntry;


/*
 * The file should contain the implementation of a hashmap with:
 * - Separate Chaining for collision handling
 * - Multiply-Add-Divide (MAD) for compression: (a*k+b) mod p
 * - Java's own linked lists for the secondary containers
 * - Resizing (to double its size) and rehashing when the load factor gets above a threshold
 *   Note that for this type of hashmap, load factor can be higher than 1
 * 
 * Some helper functions are provided to you. We suggest that you go over them.
 * 
 * You are not allowed to use any existing java data structures other than for the buckets (which have been 
 * created for you) and the keyset method
 */

public class HashMapSC<Key, Value> extends AbstractHashMap<Key, Value> {

	// The underlying array to hold hash entry Lists
	private LinkedList<HashEntry<Key, Value>>[] buckets;

	// Note that the Linkedlists are still not initialized!
	@SuppressWarnings("unchecked")
	protected void resizeBuckets(int newSize) {
		// Update the capacity
		N = nextPrime(newSize);
		buckets = (LinkedList<HashEntry<Key, Value>>[]) Array.newInstance(LinkedList.class, N);
	}

	/*
	 * ADD MORE FIELDS IF NEEDED
	 * 
	 */

	// The threshold of the load factor for resizing
	protected float criticalLoadFactor;

	/*
	 * ADD A NESTED CLASS IF NEEDED
	 * 
	 */

	public int hashValue(Key key, int iter) {
		return hashValue(key);
	}

	public int hashValue(Key key) {
		// TODO: Implement the hashvalue computation with the MAD method. Will be almost
		// the same as the primaryHash method of HashMapDH
		return Math.abs(Math.floorMod(Math.floorMod(a * Math.abs(key.hashCode()) + b, P), N));
	}

	// Default constructor
	public HashMapSC() {
		this(101);
	}

	public HashMapSC(int initSize) {
		// High criticalAlpha for representing average items in a secondary container
		this(initSize, 10f);
	}

	public HashMapSC(int initSize, float criticalAlpha) {
		N = initSize;
		criticalLoadFactor = criticalAlpha;
		resizeBuckets(N);

		// Set up the MAD compression and secondary hash parameters
		updateHashParams();

		/*
		 * ADD MORE CODE IF NEEDED
		 * 
		 */
	}

	/*
	 * ADD MORE METHODS IF NEEDED
	 * 
	 */

	@Override
	public Value get(Key k) {
		// TODO Auto-generated method stub
		if (k == null)
			return null;
		if (buckets[hashValue(k)] == null)
			return null;
		for (HashEntry<Key, Value> entries : buckets[hashValue(k)]) {
			if (entries.getKey().equals(k))
				return entries.getValue();
		}
		return null;
	}

	@Override
	public Value put(Key k, Value v) {
		// TODO Auto-generated method stub
		// Do not forget to resize if needed!
		// Note that the linked lists are not initialized!
		if (k == null)
			return null;
		HashEntry<Key, Value> e = new HashEntry<Key, Value>(k, v);
		checkAndResize();
		LinkedList<HashEntry<Key, Value>> t = buckets[hashValue(k)];
		
		if (t == null) {
			t = new LinkedList<HashEntry<Key, Value>>();
		}

		for (HashEntry<Key, Value> hashEntry : t) {
			if (hashEntry.getKey().equals(k)) {
				Value oldV = hashEntry.getValue();
				hashEntry.setValue(v);
				return oldV;
			}
		}

		t.add(e);
		buckets[hashValue(k)] = t;
		n++;
		return null;
	}

	@Override
	public Value remove(Key k) {
		// TODO Auto-generated method stub
		if (k == null)
			return null;

		LinkedList<HashEntry<Key, Value>> e = buckets[hashValue(k)]; // remove 0 yerine remove k olacak düzelttikten
																		// sonra
																		// bakarsın.
		if (e == null) {
			return null;
		}
		for (HashEntry<Key, Value> hashEntry : e) {
			if (hashEntry.getKey().equals(k)) {
				Value oldV = hashEntry.getValue();
				e.remove(hashEntry); // object yerine index bulmak gerekir mi ?
				n--;
				return oldV;
			}
		}
		return null;
	}
	
	//
	//
	//
	//
	//FAQ yerine ArrayList yazılabilir dendi, TestHashMap.java içinden casting i arrayListe çevirdim.  
	//in FAQ, Answered as arrayList can be used. I changed casting to the arrayList in TestHashMap.java as said in FAQ.
	//
	//
	@Override
	public Iterable<Key> keySet() {
		// TODO Auto-generated method stub
		Set<Key> keyList = new HashSet<Key>();
		for (LinkedList<HashEntry<Key, Value>> hashList : buckets) {
			if (hashList != null) {
				for (HashEntry<Key, Value> hash : hashList) {
					keyList.add(hash.getKey());
				}
			}
		}
		return keyList;
	}
	
	

	/**
	 * checkAndResize checks whether the current load factor is greater than the
	 * specified critical load factor. If it is, the table size should be increased
	 * to 2*N and recreate the hash table for the keys (rehashing). Do not forget to
	 * re-calculate the hash parameters and do not forget to re-populate the new
	 * array!
	 */
	protected void checkAndResize() {
		if (loadFactor() > criticalLoadFactor) {
			// TODO: Fill this yourself
			N = 2 * N;
			updateHashParams();
			LinkedList<HashEntry<Key, Value>>[] temp = buckets;
			resizeBuckets(N);
			for (LinkedList<HashEntry<Key, Value>> EntryList : temp) {
				if (EntryList != null) {
					for (HashEntry<Key, Value> Entry : EntryList) {
						LinkedList<HashEntry<Key, Value>> t = buckets[hashValue(Entry.getKey())];
						if (t == null) {
							t = new LinkedList<HashEntry<Key, Value>>();
							t.add(Entry);
							buckets[hashValue(Entry.getKey())] = t;
						} else {
							t.add(Entry);
							buckets[hashValue(Entry.getKey())] = t;
						}
					}
				}
			}

		}
	}
}
