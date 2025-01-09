package com.example.ArraysHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStrings6 {

	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();

		for (String s : strs) {
			sb.append(s.length()).append("#").append(s);
		}

		return sb.toString();
	}

	public List<String> decode(String str) {

		List<String> list = new ArrayList<>();

		int i = 0;

		while (i < str.length()) {
			int j = i;

			while (str.charAt(j) != '#') {
				j++;
			}

			int length = Integer.valueOf(str.substring(i, j));

			i = j + 1 + length;
			list.add(str.substring(j + 1, i));
		}

		return list;
	}

}
