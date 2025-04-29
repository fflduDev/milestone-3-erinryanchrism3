package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

public class DiGraphImpl implements DiGraph{

	private List<GraphNode> nodeList = new ArrayList<>();

	@Override
	public Boolean addNode(GraphNode node) {
		if (node == null || nodeList.contains(node)) {
            return false;
        }
        return nodeList.add(node);
	}

	@Override
	public Boolean removeNode(GraphNode node) {
		if (node == null || nodeList.contains(node)) {
			return false;
		}
		return nodeList.remove(node);
	}

	@Override
	public Boolean setNodeValue(GraphNode node, String newNodeValue) {
		if (node != null) {
	        node.setValue(newNodeValue);
	        return true;
	    }
	    return false;
	}

	@Override
	public String getNodeValue(GraphNode node) {
		if (node != null) {
	        return node.getValue();
	    }
	    return null;
	}

	@Override
	public Boolean addEdge(GraphNode fromNode, GraphNode toNode, Integer weight) {
		return fromNode.addNeighbor(toNode, weight);
	}
	
	@Override
	public Boolean addEdgeStr(String fromNode, String toNode, Integer weight) {
	    GraphNode fromNode1 = null;
	    GraphNode toNode1 = null;

	    for (GraphNode node : nodeList) {
	        if (node.getValue().equals(fromNode)) {
	            fromNode1 = node;
	        }
	        if (node.getValue().equals(toNode)) {
	            toNode1 = node;
	        }
	    }

	    if (fromNode1 != null && toNode1 != null) {
	        return addEdge(fromNode1, toNode1, weight);  
	    }

	    return false;  
	}

	@Override
	public Boolean removeEdge(GraphNode fromNode, GraphNode toNode) {
		return fromNode.removeNeighbor(toNode);
	}

	@Override
	public Boolean setEdgeValue(GraphNode fromNode, GraphNode toNode, Integer newWeight) {
		fromNode.removeNeighbor(toNode);
		return fromNode.addNeighbor(toNode, newWeight);
	}

	@Override
	public Integer getEdgeValue(GraphNode fromNode, GraphNode toNode) {
		return fromNode.getDistanceToNeighbor(toNode);
	}

	@Override
	public List<GraphNode> getAdjacentNodes(GraphNode node) {
		return node.getNeighbors();
	}

	@Override
	public Boolean nodesAreAdjacent(GraphNode fromNode, GraphNode toNode) {
		return fromNode.getNeighbors().contains(toNode);
	}

	@Override
	public Boolean nodeIsReachable(GraphNode fromNode, GraphNode toNode) {
		
		List<GraphNode> visited = new ArrayList<>();
		List<GraphNode> queue = new ArrayList<>();
		
		queue.add(fromNode);
		while(!queue.isEmpty()) {
			GraphNode current = queue.remove(0);
			if(current.equals(toNode)) {
			return true;
		}
			
		if(!visited.contains(current)) {
			visited.add(current);
			for(GraphNode neighbor : current.getNeighbors()) {
				if(!visited.contains(neighbor)) {
					queue.add(neighbor);
				}
			}
		}
	}
		
		return false;
	}

	@Override
	public Boolean hasCycles() {
		
		return null;
	}

	@Override
	public List<GraphNode> getNodes() {
		return nodeList;
	}

	@Override
	public GraphNode getNode(String nodeValue) {
		for (GraphNode node : nodeList) {
			if (node.getValue().equals(nodeValue)) {
				return node;
			}
		}
		return null;
	}

	@Override
	public int fewestHops(GraphNode fromNode, GraphNode toNode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int shortestPath(GraphNode fromNode, GraphNode toNode) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
