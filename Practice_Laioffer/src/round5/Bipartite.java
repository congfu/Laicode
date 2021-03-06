//Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two groups such that no nodes have direct edges to other nodes in the same group.
//
//Examples
//
//1  --   2
//
//    /   
//
//3  --   4
//
//is bipartite (1, 3 in group 1 and 2, 4 in group 2).
//
//1  --   2
//
//    /   |
//
//3  --   4
//
//is not bipartite.
//
//Assumptions
//
//The graph is represented by a list of nodes, and the list of nodes is not null.
package round5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bipartite {
	boolean isBipartite(List<GraphNode> graph) {
		HashMap <GraphNode,Integer> visited = new HashMap<>();
		for (GraphNode node : graph) {
			if (!BST(node,visited)) {
				return false;
			}
		}
		return true;
	}

	private boolean BST(GraphNode node,HashMap<GraphNode,Integer> visited) {
		// TODO Auto-generated method stub
		if (visited.containsKey(node)) {
			return true;
		}
		Queue<GraphNode> q = new LinkedList<>();
		q.offer(node);
		visited.put(node,0);
		while (!q.isEmpty()) {
			GraphNode cur = q.poll();
			int Groupcur = visited.get(cur);
			int GroupNei = Groupcur == 0? 1:0;
			for (GraphNode nei:cur.neighbors) {
				if (!visited.containsKey(nei)) {
					visited.put(nei, GroupNei);
					q.offer(nei);
				}else if (visited.get(nei)!=GroupNei) {
					return false;
				}
			}
		}
		return false;
	}
}