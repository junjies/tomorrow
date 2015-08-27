package com.fabulous.tomorrow;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * There is an array of 10000000 different int numbers. Find out its largest 100 elements. The implementation should be optimized for executing speed.
 */
public class GetLargestNumber {

	public static void main(String[] args) {
		int size = 1000000;

		StringBuffer srcIndex = new StringBuffer();
		List<Integer> srcList = new ArrayList<Integer>(size);
		Integer[] srcArrayTmp = {};
		for (int i = 0; i < size; i++) {
			int ins = (int) (Math.random() * size);
			srcList.add(ins);
			srcIndex.append(ins).append(", ");
		}
		Integer[] srcArray = srcList.toArray(srcArrayTmp);
		// printArray(srcArray);
		printArray(getLargest100(srcArray));
	}

	public static Integer[] getLargest100(Integer[] srcArray) {
		if (srcArray == null || srcArray.length == 0) {
			return null;
		}

		Queue<Integer> maxValueQueue = getLargest(srcArray, 100);
		Integer[] result = new Integer[maxValueQueue.size()];
		int i = 0;
		while (!maxValueQueue.isEmpty()) {
			result[i++] = maxValueQueue.poll();
		}

		return result;
	}

	public static Queue<Integer> getLargest(Integer[] srcArray, int size) {
		if (srcArray == null || srcArray.length == 0) {
			return null;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(size);
		for (Integer index : srcArray) {
			if (queue.size() < size) {
				queue.add(index);
				continue;
			}

			int minOfQueue = queue.peek();
			if (index > minOfQueue) {
				queue.poll();
				queue.add(index);
			}
		}

		return queue;
	}

	public static void printArray(Integer[] array) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			result.append(array[i]).append("\t");
		}
		System.out.println(result.toString());
	}

}
