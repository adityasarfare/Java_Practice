package com.example.AdvanceGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/// watch leet code 332
public class ReconstructFlightPath1 {
 
  public List<String> findItinerary(List<List<String>> tickets) {
        
	  Map<String, List<String>> adj = new HashMap<>();
	  
	  for(List<String> ticket : tickets) {
		  adj.putIfAbsent(ticket.get(0), new ArrayList<>());
	  }
	  
	  tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));
	  
	  for(List<String> ticket : tickets) {
		  adj.get(ticket.get(0)).add(ticket.get(1));
	  }
	  
	  List<String> res = new ArrayList<>();
	  res.add("JFK");
	  if(dfs("JFK", adj, res, tickets.size()+1)) {
		  return res;
	  }
	  
	  return new ArrayList<>();
    }

private boolean dfs(String src, Map<String, List<String>> adj, List<String> res, int targetlength) {
	
	if(res.size() == targetlength) {
		return true;
	}
	
	if(!adj.containsKey(src)) {
		return false;
	}
	
	List<String> temp = new ArrayList<>(adj.get(src));
	for(int i=0; i< temp.size(); i++) {
		String v = temp.get(i);
		res.add(v);
		adj.get(src).remove(i);
		if(dfs(v, adj, res, targetlength)) {
			return true;
		}
         adj.get(src).add(i, v);
         res.remove(res.size()-1);
	}
	return false;
}
}
