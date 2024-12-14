package com.example.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII7 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
	
		List<Integer> [] adj = new List[numCourses];
		int[] indegree = new int[numCourses];
		int [] ans = new int[numCourses];
		
		for(int[] pre : prerequisites) {
			int course = pre[0];
			int prerequisite = pre[1];
			
			if(adj[prerequisite]== null) {
				adj[prerequisite] = new ArrayList<>();
			}
			adj[prerequisite].add(course);
			indegree[course]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i =0; i<indegree.length; i++) {
			if(indegree[i]==0) {
				q.offer(i);
			}
		}
		int index =0;
		while(!q.isEmpty()) {
			int current = q.poll();
			ans[index]=current;
			index++;
			
			if(adj[current]!=null) {
				for(int next : adj[current]) {
					indegree[next]--;
					if(indegree[next] == 0) {
						q.offer(next);	
				}
			}
				
			}
			
		}
		
		if(index == numCourses) {
			return ans;
		}
		return new int[] {};
	}
}
