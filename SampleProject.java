package com.javabycode.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SampleProject {
	public static void main(String[] args) {
		System.out.println(getHashTags("Visu alizing Science"));
		System.out.println(palindromeDescendant(123123));
	}

	/*
	 * An online news organization wants to transform the top three longest words
	 * from a newspaper headline into hashtags.
	 */
	public static List<String> getHashTags(String str) {
		List<String> tempList = new ArrayList<>();
		if (str == null || "".equals(str = str.trim()))
			return tempList;
		for (String s : str.toLowerCase().split("\\W"))
			tempList.add(s);
		tempList.sort((a, b) -> a.length() < b.length() ? 1 : a.length() == b.length() ? 0 : -1);
		if (tempList.size() > 3)
			return tempList.subList(0, 3).stream().map(a -> "\"#" + a + "\"").collect(Collectors.toList());
		return tempList.stream().map(a -> "\"#" + a + "\"").collect(Collectors.toList());
	}

	/*
	 * A number or its descendant can be palindrome. A number's direct child is
	 * created by summing each pair of adjacent digits to create the digits of the
	 * next number.
	 */
	public static boolean palindromeDescendant(Integer data) {
		String temp = data + "";
		if (data == null || temp.length() == 1)
			return false;
		if (new StringBuffer(temp).reverse().toString().equals(temp))
			return true;
		if (temp.length() % 2 != 0)
			return false;
		String temp2 = "";
		for (int i = 0; i < temp.length(); i += 2) {
			temp2 += (Integer.valueOf(temp.charAt(i) + "") + Integer.valueOf(temp.charAt(i + 1) + ""));
		}
		return palindromeDescendant(Integer.valueOf(temp2));
	}
}
