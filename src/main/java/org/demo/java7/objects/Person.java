package org.demo.java7.objects;

import java.util.Objects;

public class Person implements Comparable<Person> {
	
	private String first;
	private String last;
	
	private int x;
	private int y;
	
	
	/**
	 * equals
	 */
	public boolean equals(Object other) {
		if (this == other) return true;
		if (other == null) return false;
		if (getClass() != other.getClass()) return false;
		Person otherPerson =  (Person)other;
		
		return Objects.equals(first, otherPerson.first) && Objects.equals(last, otherPerson.last);
	}
	
	public int hashCode() {
		return 31 * Objects.hashCode(first) + Objects.hashCode(last);
	}

	@Override
	public int compareTo(Person other) {
		int diff = Integer.compare(x, other.x);
		if (diff !=0) return diff;
		return Integer.compare(y, other.y);
	}
	

}
