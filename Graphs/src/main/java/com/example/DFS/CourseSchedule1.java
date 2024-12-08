package com.example.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//207
//Using topological
public class CourseSchedule1 {
 
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      List<Integer> [] adj = new List[numCourses];
      int[] indegree = new int[numCourses];
      ArrayList<Integer> ans = new ArrayList<>();
      
      for(int[] pair : prerequisites) {
    	  int course = pair[0];
    	  int prerequisite = pair[1];
    	  
    	  if(adj[prerequisite] == null) {
    		  adj[prerequisite] = new ArrayList<>();
    	  }
    	  adj[prerequisite].add(course);
    	  indegree[course]++;
      }
      
      Queue<Integer> q = new LinkedList<>();
      for(int i=0; i<indegree.length ;i++) {
    	  if(indegree[i] == 0) {
    		  q.offer(i);
    	  }
      }
	  
      while(!q.isEmpty()) {
    	  int current = q.poll();
    	  ans.add(current);
    	  
    	  if(adj[current] != null) {
    		  for(int next : adj[current]) {
    			  indegree[next]--;
    			  if(indegree[next] ==0) {
    				  q.offer(next);
    			  }
    		  }
    	  }
      }
      
	  return ans.size() == numCourses;
    }
	
}
