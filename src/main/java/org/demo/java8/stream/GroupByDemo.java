package org.demo.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByDemo {

	public static void groupingBy() {
		Stream<Locale> locates = Stream.of(Locale.getAvailableLocales());
		// 获取国家中所有的语言，函数Locale::getCountry 是进行分组的分类函数
		Map<String, List<Locale>> countryToLocales = locates.collect(Collectors.groupingBy(Locale::getCountry));

		// downstream
		// 得到Set
		Map<String, Set<Locale>> countryToLocaleSet = locates
				.collect(Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));

		// counting 返回收集元素的总个数
		Map<String, Long> countryToLocaleCounts = locates
				.collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));

		City city1 = new City("a", 100);
		City city2 = new City("a", 200);
		City city3 = new City("b", 200);
		City city4 = new City("b", 300);
		List<City> cities = new ArrayList<>();
		cities.add(city1);
		cities.add(city2);
		cities.add(city3);
		cities.add(city4);

		// summing 求和 ,计算每个州下属的所有城市的人口总数
		Map<String, Integer> stateToCityPopulation = cities.stream()
				.collect(Collectors.groupingBy(City::getState, Collectors.summingInt(City::getPopulation)));

		// maxBy minBy 最大值和最小值 ，每个州中人口最多的城市
		Map<String, Optional<City>> stateToLargesCity = cities.stream().collect(
				Collectors.groupingBy(City::getState, Collectors.maxBy(Comparator.comparing(City::getPopulation))));

		// mapping 将一个函数应用到 downstream 结果上，并且需要另外一个收集器来处理结果
		// 将城市按照其所属的州进行分组，在每个州中，生成每个城市的名称并按照其最大长度进行聚合
		Map<String, Optional<String>> stateToLongestCityName = cities.stream()
				.collect(Collectors.groupingBy(City::getState,
						Collectors.mapping(City::getName, Collectors.maxBy(Comparator.comparing(String::length)))));

		// 获取指定国家所有语言集合
		Map<String, Set<String>> countryToLanguages = locates.collect(Collectors.groupingBy(l -> l.getDisplayCountry(),
				Collectors.mapping(l -> l.getDisplayLanguage(), Collectors.toSet())));

		// 获取包含每个州中得所有城市名称得字符串，其中各个城市名字之间用逗号分隔
		Map<String, String> stateToCityNames = cities.stream().collect(
				Collectors.groupingBy(City::getState, Collectors.mapping(City::getName, Collectors.joining(", "))));

	}

	/**
	 * 当分类函数是 predicate 函数时，流元素会被分为两组列表，一组是返回true的元素， 另一组返回false元素，在这种情况下
	 * partitioningBy比groupingBy更有效率
	 * 
	 * 将所有语言环境分隔为两组，一组使用英语，另一组使用其他语言
	 */
	public static void partitioningBy() {
		Stream<Locale> locates = Stream.of(Locale.getAvailableLocales());
		Map<Boolean, List<Locale>> englishAndOtherLocales = locates
				.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
		List<Locale> englishLocales = englishAndOtherLocales.get(true);
	}

	static class City {
		String state;
		String name;
		int population;

		public City(String state, int population) {
			this.state = state;
			this.population = population;
		}

		public City(String state, String name, int population) {
			this.state = state;
			this.name = name;
			this.population = population;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public int getPopulation() {
			return population;
		}

		public void setPopulation(int population) {
			this.population = population;
		}

	}

}
