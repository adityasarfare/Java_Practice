package com.example.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//207
//Using topological
//numCourses = 4;
//prerequisites = [[1, 0], [2, 1], [3, 2]];
public class CourseSchedule1 {
 
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      List<Integer> [] adj = new List[numCourses]; // Each course has a list of courses that depend on it. (means one course could be dependency for one or many 
        //   courses, so each index number is the course and on that index list<> of courses are added. for example on 0 index course 1 is saved as. 0 is prereq for 1) so which all coursesw depemd on course 0
      int[] indegree = new int[numCourses];  // this array is use to  keeps track of the number of prerequisites for each course, meaning this course has how many prereq to complete;
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
    	  int current = q.poll(); // removes a node which does not have any preReq
    	  ans.add(current);
    	  
    	  if(adj[current] != null) {  //Skips processing if the current node has no outgoing edges (no neighbors).
    		  for(int next : adj[current]) {  //Iterates through all neighbors (next) of the current node.
    			  indegree[next]--; // This removes the prereq as completed for that course. means one preq of that course is completed
    			  if(indegree[next] ==0) { // if all the prereq(No of prereq) is compeletd that is zero left
    				  q.offer(next); //add that to the queue
    			  }
    		  }
    	  }
      }
      
	  return ans.size() == numCourses;
    }
	
}
