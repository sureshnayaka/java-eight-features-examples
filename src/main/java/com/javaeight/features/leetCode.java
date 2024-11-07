package com.javaeight.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class leetCode {

	public static void main(String[] args) {
		int intArray[] = { 2, 2, 4, 4 };
		int intArray1[] = { 2, 2, 2, 4, 4 };
		int intArray2[] = { 1, 2, 4, 3, 2 };
		String word1 = "a good   example ", word2 = "prqs";
		leetCode.sumOfNumbers(intArray, 1);
		leetCode.findMedianSortedArrays(intArray, intArray1);
		leetCode.mergeAlternately(word1, word2);
		leetCode.reverseWords(word1);
		leetCode.increasingTriplet(intArray2);
		System.out.println(leetCode.increasingTriplet(intArray2));
	}

	public static int[] sumOfNumbers(int[] nums, int target) {
		int returnValue[] = new int[2];
		m: for (int i = 0; i < nums.length; i++) {
			int firstIndx;
			for (int j = i + 1; j < nums.length; j++) {

				firstIndx = nums[i];
				int nextValue = nums[j]; // Accessing the next element

				System.out.println("Current value: " + firstIndx);
				System.out.println("Next value: " + nextValue);

				if (firstIndx + nextValue == target) {
					returnValue[0] = i;
					returnValue[1] = j;
					System.out.println(Arrays.toString(returnValue));
					break m;
				} else {
					System.out.println(i);
				}

			}

		}

		return returnValue;

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		ArrayList<Integer> obj = new ArrayList<Integer>();
		Double median = 0.0;
		int firstArryaLength = nums1.length;
		int secondArryaLenght = nums2.length;
		int mergedArrya[] = new int[firstArryaLength + secondArryaLenght];
		for (int i = 0; i <= firstArryaLength - 1; i++) {
			mergedArrya[i] = nums1[i];
		}

		for (int j = 0; j <= secondArryaLenght - 1; j++) {
			int currentIndx = firstArryaLength - 1;
			mergedArrya[currentIndx + (j + 1)] = nums2[j];
		}

		for (int x = 0; x <= mergedArrya.length - 1; x++) {

			obj.add(mergedArrya[x]);

		}
		List<Integer> sortedArray = obj.stream().sorted().collect(Collectors.toList());
		if (sortedArray.size() % 2 == 0) {

			int medianValue = sortedArray.size() / 2;
			median = (double) (sortedArray.get(medianValue) + sortedArray.get(medianValue - 1)) / 2;
			return median;
		} else {

			int index = (sortedArray.size() / 2);
			return (double) sortedArray.get(index);
		}

	}

	public static String mergeAlternately(String word1, String word2) {

		int firstStringLenght = word1.length();
		int secondStringLeght = word2.length();
		int indxValue = firstStringLenght > secondStringLeght ? secondStringLeght : firstStringLenght;
		String mergeDAlternatelyString = "";

		for (int i = 0; i <= indxValue - 1; i++) {
			mergeDAlternatelyString += word1.charAt(i) + "" + word2.charAt(i);
		}

		if (firstStringLenght > secondStringLeght) {
			for (int i = indxValue; i < firstStringLenght; i++) {
				mergeDAlternatelyString += word1.charAt(i);
			}
		} else if (firstStringLenght < secondStringLeght) {
			for (int i = indxValue; i < secondStringLeght; i++) {
				mergeDAlternatelyString += word2.charAt(i);
			}

		}
		System.out.println(mergeDAlternatelyString);

		return mergeDAlternatelyString;

	}

	public static String reverseWords(String str) {
		if (str.length() <= 0) {
			throw new NullPointerException(" no string value");
		}

		// Split the string into words
		String[] words = str.trim().split("\\s+");
		// StringBuilder to build the reversed string
		StringBuilder reversed = new StringBuilder();

		// Reverse the order of words
		for (int i = words.length - 1; i >= 0; i--) {
			reversed.append(words[i].toString());

			if (i != 0) {
				reversed.append(" "); // Add space between words
			}
		}

		System.out.println(reversed.toString());
		return reversed.toString();

	}

	public static boolean increasingTriplet(int[] nums) {
		int firstNumber = Integer.MAX_VALUE;
		int secondNumber = Integer.MAX_VALUE;
        
		for (int num : nums) {
			if (num <= firstNumber) {
				firstNumber = num;
			} else if (num <= secondNumber) {
				secondNumber = num;
			} else {
				return true;

			}
		}
		return false;

	}
}
