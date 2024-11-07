package com.javaeight.features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.lang.Nullable;

import com.javaeight.features.model.EkartEmployees;
import com.javaeight.features.model.Employee;
import com.javaeight.features.usersDAO.UsersData;

public class JavaEightConsumer {

	public static void main(String[] args) {
		

		List<Integer> integerValue = Arrays.asList(1, 12, 13, 4, 5, 6, 7, 8, 9, 10);
		integerValue = integerValue.stream().sorted(Comparator.reverseOrder()).toList();
		integerValue.stream().forEachOrdered(t -> {
			t *= 5;
//			System.out.println( t);
		});

		List<String> stringValue = Arrays.asList("cat", "dog", "apple", "bat");
		stringValue = stringValue.stream().sorted().toList();
		stringValue.stream().forEach(t -> {
			// System.out.println(t);
		});
		Stream<String> obj = stringValue.stream().filter(t -> {
			return t == "cat";
		});
		obj.forEach(t -> System.out.println(t));

		Predicate<Integer> predicate = t -> t % 2 == 0;
//		System.out.println(predicate.test(10));
//		JavaEightConsumer.textMethod("null");
		JavaEightConsumer.getEmployees();
		JavaEightConsumer.getEkartEmployees();
		JavaEightConsumer.checkOptional("Surya");
		JavaEightConsumer.sortArray();
		int[] intArray = { 3,2,4 }; // Using array initialization shorthand for better readability
	}

	static void textMethod(@Nullable String input) {
		Optional<String> string = Optional.ofNullable(input);
		if (string.isEmpty()) {
			System.out.println("empty string");
		} else if (string.isPresent()) {
			System.out.println("non-empty string: " + string.get());
		}
	}

	static void getEmployees() {
		List<Employee> employees = UsersData.getEmployes();
		employees = employees.stream().filter(obj -> obj.getSalary() <= 2100000)
				.sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		System.out.println(employees);
		List<Integer> integerValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		integerValues.stream().forEach((t -> {
			t *= 5;
			System.out.println(t);
		}));
	}

	/**
	 * Map and Flat Map
	 */

	static void getEkartEmployees() {
		List<EkartEmployees> ekartEmployees = UsersData.getAllEkartEmployees();
		List<String> email = ekartEmployees.stream().map(ekartEmployee -> ekartEmployee.getEmail())
				.collect(Collectors.toList());
		// process stream of values
		// does only mapping
		// mapper function prodcues single values for each input values
		// one to one mapping
		// stream to stream
		System.out.println(email);
		List<List<String>> phoneNumbers = ekartEmployees.stream().map(phonenumber -> phonenumber.getPhoneNumbers())
				.collect(Collectors.toList());
		System.out.println(phoneNumbers);
		List<String> allPhonenumbers = ekartEmployees.stream()
				.flatMap(allPhonenumber -> allPhonenumber.getPhoneNumbers().stream()).collect(Collectors.toList());
		System.out.println(allPhonenumbers);
		// process stream of stream
		// performs mapping and flattening
		// produces multiple values for each input values
		// one to many

	}

	/**
	 * Optional class
	 */
	static void checkOptional(@Nullable String name) {
		List<EkartEmployees> ekartEmployees = UsersData.getAllEkartEmployees();
		Optional<String> emailOptional = Optional.ofNullable(ekartEmployees.get(0).getEmail());
		System.out.println(emailOptional);
		System.out.println(emailOptional.isEmpty());
		System.out.println(emailOptional.isPresent());
		System.out.println(emailOptional.orElseGet(() -> "no value"));
		System.out.println(emailOptional.orElseThrow(() -> new NullPointerException("Entert Email.")));
		System.out.println(emailOptional.get());
		Optional<EkartEmployees> employees = Optional.ofNullable(ekartEmployees.stream()
				.filter(ele -> ele.getName().equals(name)).findAny().orElse(new EkartEmployees(null, null, null)));
		if (employees.isPresent()) {
			// System.out.println(
			// employees.get().getPhoneNumbers().stream().map(ele->ele.name)).collect(Collectors.toList()));
			System.out.println(employees);
		}

	}

	static void sortArray() {

		List<Integer> listOfItems = Arrays.asList(1, 5, 4, 7, 8, 9, 1, 2, 0, 9);
		Optional<Integer> listVlue = listOfItems.stream().distinct().sorted((first, last) -> (last - first)).skip(1)
				.findFirst();
		// listOfItems.forEach(value -> System.out.println("\t"+value));
		// listOfItems.stream().distinct().sorted().map(a ->
		// a*5).toList().forEach(a->System.out.println(a));
		// System.out.println(listVlue.get());
		Predicate<Integer> predicateValue = (n) -> n % 2 == 1;

		Function<Integer, ?> functipn = (mulitply) -> mulitply * 2;

		listOfItems.stream().filter(predicateValue).distinct().sorted().map(functipn).limit(2)
				.forEach(print -> System.out.println(print));
		// List of lists of names
		List<List<String>> listOfLists = Arrays.asList(Arrays.asList("Reflection", "Collection", "Stream"),
				Arrays.asList("Structure", "State", "Flow"),
				Arrays.asList("Sorting", "Mapping", "Reduction", "Stream"));

		// Create a set to hold intermediate results
		Set<String> intermediateResults = new HashSet<>();
		Consumer<String> consumer = (String n) -> intermediateResults.add(n);
		// Stream pipeline demonstrating various intermediate operations
		List<String> result = listOfLists.stream().flatMap(List::stream) // Flatten the list of lists into a single
																			// stream
				.filter(s -> s.startsWith("S")) // Filter elements starting with "S"
				.map(String::toUpperCase) // Transform each element to uppercase
				.distinct() // Remove duplicate elements
				.sorted() // Sort elements
				.peek(consumer) // Perform an action (add to set) on each element
				.collect(Collectors.toList()); // Collect the final result into a list

		// Print the intermediate results
		System.out.println("Intermediate Results:");
		intermediateResults.forEach(System.out::println);

		// Print the final result
		System.out.println("Final Result:");
		result.forEach(System.out::println);
		List<String> names = Arrays.asList("Reflection", "Collection", "Stream", "Structure", "Sorting", "State");
		String concatenatedNames = names.stream().reduce("", (partialString, element) -> partialString + " " + element);
		System.out.println("\nreduce (concatenated names):");
		System.out.println(concatenatedNames.trim());
		CustomFunction custom = (a, b) -> a + b;

		System.out.println(custom.operation(10, 20));
	}

	public interface CustomFunction {
		int operation(int a, int b); // Single abstract method

		static void classDemo() {
			System.out.println("demo");
		}

	}

	}
