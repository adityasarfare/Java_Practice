package com.example;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
	
		int[] count = new int[26];
		for(char task : tasks) {
			count[task - 'A']++;
		}
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for(int cnt : count) {
			if(cnt > 0) {
				maxHeap.add(cnt);
			}
		}
	
		Queue<int[]> q = new LinkedList<>();
		int time =0;
		
		while(!maxHeap.isEmpty() || !q.isEmpty()) {
			time ++;
			
			if(maxHeap.isEmpty()) {
				time = q.peek()[1];
			}else {
				int cnt = maxHeap.poll() -1;
				if(cnt > 0) {
					q.add(new int[] {cnt, time +n});
				}
			}
			
			if(!q.isEmpty() && time == q.peek()[1]) {
				maxHeap.add(q.poll()[0]);
			}
		}
		return time;
	}
}
