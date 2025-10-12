package lektion0405Hashing.mapDictionary;

import lektion0405Hashing.customHashCode.Bil;

import java.util.HashSet;

public class DictionaryDemo {

	public static void main(String[] args) {
		// Dictionary map = new DictionaryHashMap<Integer,String>();
		Dictionary<Integer, String> dictionary = new DictionaryLinked<Integer, String>();
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());

		dictionary.put(8, "hans");
		dictionary.put(3, "viggo");
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());

		System.out.println(dictionary.get(8));

		dictionary.put(7, "bent");
		dictionary.put(2, "lene");
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());
		System.out.println(dictionary.remove(3));

		System.out.println(dictionary.size());

		System.out.println(dictionary.put(8, "Ida"));
		System.out.println(dictionary.get(8));

		// Nu med biler
		System.out.println("Nu med biler:");
		Dictionary<Bil, Integer> bilDictionary = new DictionaryLinked<>();
		tilfoejBiler(bilDictionary);
		System.out.println(bilDictionary.size());
		bilDictionary.put(
				new Bil(
						"12345678",
						"Mercedes",
						"C220",
						"Sort"
				),
				1
		);
		System.out.println(bilDictionary.size());
	}

	private static void tilfoejBiler(Dictionary<Bil, Integer> bilDictionary){
		bilDictionary.put(
				new Bil(
						"12345678",
						"Mercedes",
						"C220",
						"Sort"
				),
				1
		);
		bilDictionary.put(
				new Bil(
						"23456781",
						"Porsche",
						"Taycan",
						"Rød"
				),
				10
		);
		bilDictionary.put(
				new Bil(
						"34567812",
						"Land Rover",
						"Sport",
						"Sort"
				),
				2
		);
		bilDictionary.put(
				new Bil(
						"45678123",
						"Skoda",
						"Superb",
						"Grå"
				),
				5
		);
	}

}