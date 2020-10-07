package info.yong98.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumber2WordConvertor {

	static public List<String> getWords(String digits) {
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('2', "2abc");
		map.put('3', "3def");
		map.put('4', "4ghi");
		map.put('5', "5jkl");
		map.put('6', "6mno");
		map.put('7', "7pqrs");
		map.put('8', "8tuv");
		map.put('9', "9wxyz");

		List<String> words = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return null;
		}

		words.add("");
		for (int i = 0; i < digits.length(); i++) {
			List<String> temp = new ArrayList<String>();
			char ch = digits.charAt(i);
			if (Character.isDigit(ch)) {
				String option = map.get(ch);

				// for '0' and '1'
				if (null == option)
					option = String.valueOf(ch);

				for (int j = 0; j < words.size(); j++) {
					for (int p = 0; p < option.length(); p++) {
						temp.add(new StringBuilder(words.get(j)).append(option.charAt(p)).toString().toUpperCase());
					}
				}
				words.clear();
				words.addAll(temp);
			}
		}

		return words;
	}
}
