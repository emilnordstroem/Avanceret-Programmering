package lektion0405Hashing.hashCollision;

/**
 * This class implements a hash set using separate chaining.
 */
public class HashSetLinearProbing {
	private Object[] buckets;
	private int currentSize;
	private static final String DELETED = "DELETED";

	/**
	 * Constructs a hash table.
	 *
	 * @param bucketsLength
	 *            the length of the buckets array
	 */
	public HashSetLinearProbing(int bucketsLength) {
		buckets = new Object[bucketsLength];
		currentSize = 0;
	}

	/**
	 * Tests for set membership.
	 *
	 * @param x
	 *            an object
	 * @return true if x is an element of this set
	 */
	public boolean contains(Object x) {

		// TODO
		return false;
	}

	/**
	 * Adds an element to this set.
	 *
	 * @param x
	 *            an object
	 * @return true if x is a new object, false if x was already in the set
	 */
	public boolean add(Object x) {
		int hashIndex = hashValue(x);

		int firstDetectedDelete = -1;
		while (buckets[hashIndex] != null) {
			if (!buckets[hashIndex].equals(DELETED)
					&& buckets[hashIndex].equals(x)) {
				return false;
			} else if (buckets[hashIndex].equals(DELETED)
					&& firstDetectedDelete == -1) {
				firstDetectedDelete = hashIndex;
			}
			hashIndex++;
			hashIndex %= buckets.length;
		}
		int position = (firstDetectedDelete != -1) ? firstDetectedDelete : hashIndex;
		buckets[position] = x;
		currentSize++;
		return true;
	}

	/**
	 * Removes an object from this set.
	 *
	 * @param x
	 *            an object
	 * @return true if x was removed from this set, false if x was not an
	 *         element of this set
	 */
	public boolean remove(Object x) {
		int hashIndex = hashValue(x);
		int startIndex = hashIndex;
		while (buckets[hashIndex] != null) {
			if (buckets[hashIndex].equals(x)) {
				buckets[hashIndex] = DELETED;
				currentSize--;
				return true;
			}
			hashIndex++;
			hashIndex %= buckets.length;
			if (hashIndex == startIndex) {
				break;
			}
		}
		return false;
	}

	/**
	 * Gets the number of elements in this set.
	 *
	 * @return the number of elements
	 */
	public int size() {
		return currentSize;
	}

	private int hashValue(Object x) {
		int h = x.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % buckets.length;
		return h;
	}

	// method only for test purpose
	public void writeOut() {
		for (int i = 0; i < buckets.length; i++) {
			System.out.println(i + "\t" + buckets[i]);
		}
	}

}
