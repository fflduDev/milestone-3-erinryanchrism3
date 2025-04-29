package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

public class DiGraphImpl implements DiGraph{

	private List<GraphNode> nodeList = new ArrayList<>();
	private Map<GraphNode, List<GraphEdge>> adjacencyList = new HashMap<>();

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean nodeIsReachable(GraphNode fromNode, GraphNode toNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean hasCycles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GraphNode> getNodes() {
		return nodeList;
	}

	@Override
	public GraphNode getNode(String nodeValue) {
		// TODO Auto-generated method stub
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
