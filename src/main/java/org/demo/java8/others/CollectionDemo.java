package org.demo.java8.others;

import java.util.Arrays;
import java.util.Comparator;

public class CollectionDemo {

	public static void demo() {

		// 键提取器函数，将某类型T映射为一个可比较的类型（例如String） ，该函数会被应用于进行比较的对象，随后会对返回的键进行比较。

		// 列入拥有一个 Person对象的数组， 按照姓名对其进行排序的代码
		Person person1 = new Person(1, "zhangsan");
		Person person2 = new Person(2, "lisi");
		Person[] persons = { person1, person2 };

		Arrays.sort(persons, Comparator.comparing(Person::getName));
		// Arrays.sort(persons, Comparator.comparing(x -> x.getName()));
		Arrays.stream(persons).forEach(System.out::println);

		// 先比较 getLastName ， 在比较 getFirstName
		Arrays.sort(persons, Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));

		// 指定比较器
		Arrays.sort(persons, Comparator.comparing(Person::getName, (s, t) -> Integer.compare(s.length(), t.length())));

		Arrays.sort(persons,
				Comparator.comparing(Person::getMiddleName, Comparator.nullsFirst(Comparator.naturalOrder())));

	}

	public static void main(String[] args) {
		demo();
	}

	static class Person {
		Integer id;
		String name;

		String lastName;
		String firstName;
		String middleName;

		public Person(Integer id, String name) {
			this.id = id;
			this.name = name;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String toString() {
			return name;
		}

	}

}
