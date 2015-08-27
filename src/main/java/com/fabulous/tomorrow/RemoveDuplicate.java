package com.fabulous.tomorrow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function to remove duplicated objects from an array. Preserve the
 * order. For example, if the input array is [1, 5, 4, 2, 7, 2, 6, 5], the
 * result should be [1, 5, 4, 2, 7, 6]. The implementation should be optimized
 * for executing speed.
 *
 */
public class RemoveDuplicate {

	public static void main(String[] args) {
		int size = 10000000;
		int range = 2000000;
		List<Integer> srcList = new ArrayList<Integer>(size);
		for (int i = 0; i < size; i++) {
			srcList.add((int) (Math.random() * range));
		}
		Integer[] srcArray = {};
		srcArray = srcList.toArray(srcArray);
		removeDuplicateInt(srcArray);
	}

	public static Integer[] removeDuplicateInt(Integer[] srcArray) {
		if (srcArray == null || srcArray.length == 0) {
			return null;
		}

		Integer[] result = {};
		return removeDuplication(srcArray).toArray(result);
	}

	public static <T> List<T> removeDuplication(T[] srcArray) {
		if (srcArray == null || srcArray.length == 0) {
			return null;
		}

		Map<T, Object> filterMap = new HashMap<T, Object>(srcArray.length * 2, 0.6f);
		List<T> filteredList = new ArrayList<T>(srcArray.length);

		for (T t : srcArray) {
			if (!filterMap.containsKey(t)) {
				filterMap.put(t, null);
				filteredList.add(t);
			}
		}
		filterMap.clear();
		return filteredList;
	}

}
