package com.example.ArraysHashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence8 {

	public int longestConsecutive(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<>();

		for (int no : nums) {
			set.add(no);
		}

		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);

		int res = 1;
		int maxRes = 1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == list.get(i - 1) + 1) {
				res++;
			} else {
				maxRes = Math.max(maxRes, res);
				res = 1;
			}
			maxRes = Math.max(maxRes, res);

		}

		return res;
	}
}
