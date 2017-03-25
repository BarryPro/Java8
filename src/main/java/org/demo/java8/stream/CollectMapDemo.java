package org.demo.java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectMapDemo {

	public static void map() {
		Person p1 = new Person("1", "zhangsf1", 10);
		Person p2 = new Person("2", "zhangsf2", 10);

		List<Person> pList = new ArrayList<>();
		pList.add(p1);
		pList.add(p2);

		Map<String, String> map1 = pList.stream().collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));

		Map<String, String> map2 = pList.stream().collect(Collectors.toMap(Person::getId, Person::getName));

		Map<String, Person> map3 = pList.stream().collect(Collectors.toMap(p -> p.getId(), Function.identity()));

	}

	/**
	 * 如果多个元素拥有相同的键，那么收集方法会抛出一个 IllegalStateException
	 * 
	 * 可以通过提供第三个函数参数，根据已有的值和新值来决定键的值，从而重写该行为
	 */
	public static void map2() {
		Stream<Locale> locates = Stream.of(Locale.getAvailableLocales());
		locates.forEach(System.out::println);

		Map<String, String> languageNames = locates.collect(Collectors.toMap(l -> l.getDisplayLanguage(),
				l -> l.getDisplayLanguage(l), (existingValue, newValue) -> existingValue));

		Map<String, Set<String>> countryLanguageSets = locates.collect(Collectors.toMap(l -> l.getDisplayLanguage(),
				l -> Collections.singleton(l.getDisplayLanguage()), (existingValue, newValue) -> {
					Set<String> r = new HashSet<>(existingValue);
					r.addAll(newValue);
					return r;
				}));

		// 返回 TreeMap
		Map<String, String> languageNames1 = locates.collect(Collectors.toMap(l -> l.getDisplayLanguage(),
				l -> l.getDisplayLanguage(l), (existingValue, newValue) -> {
					throw new IllegalStateException();
				}, TreeMap::new));
	}

	public static class Person {
		String id;
		String name;
		int age;

		public Person(String id, String name, int age) {

		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	}

}
