package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class OrgChartImpl implements OrgChart{

	//Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();
	private GenericTreeNode<Employee> root;

	@Override
	public void addRoot(Employee e) {
		root = new GenericTreeNode(e);
		nodes.add(root);
	}

	@Override
	public void clear() {
		 nodes = new ArrayList<>();
		 root = null;
	}

	@Override
	public void addDirectReport(Employee manager, Employee newPerson) {
		for(int i=0; i<nodes.size(); i++) {
			GenericTreeNode<Employee> currentEmployee = nodes.get(i);
			if(currentEmployee.data.equals(manager)) {
				GenericTreeNode<Employee> newE = new GenericTreeNode(newPerson);
				currentEmployee.addChild(newE);
				nodes.add(newE);
				break;
			}
		}
		
	}
				/*GenericTreeNode<Employee> thisMngr = findEmployee(manager);
				if(thisMngr != null) {
					GenericTreeNode<Employee> newNode = new GenericTreeNode<Employee>(newPerson);
					nodes.add(newNode);
					thisMngr.addChild(newNode);
				}*/
		
	

	@Override
	public void removeEmployee(Employee firedPerson) {
		// TODO Auto-generated method stub
		for(int i = 0; i < nodes.size(); i++) {
			GenericTreeNode<Employee> child = nodes.get(i);
			if(child.data.equals(firedPerson)) {
				GenericTreeNode<Employee> parent = nodes.get(i-1);
				ArrayList<GenericTreeNode<Employee>> grandchildren = child.children;
				
				.addAll(grandchildren);
				
				nodes.remove(i);
				
			}
		}
	}

	@Override
	public void showOrgChartDepthFirst() {
		// TODO Auto-generated method stub
		
		if(root != null) {
			Stack<GenericTreeNode<Employee>> stack = new Stack<>();
			stack.push(root);
			
			while(!stack.isEmpty()) {
				GenericTreeNode<Employee> current = stack.pop();
				System.out.println(current.data);
				
				for(int i = current.children.size() -1; i >= 0; i--) {
					stack.push(current.children.get(i));
				}
			}
		}
			
			
		
	}

	@Override
	public void showOrgChartBreadthFirst() {
		Queue<GenericTreeNode<Employee>> q = new LinkedList<>();
		List<GenericTreeNode<Employee>> exploredEmployees =new ArrayList<>();
		q.add(root);
		while(!q.isEmpty()) {
			GenericTreeNode<Employee> temp = q.poll();
			System.out.println(temp.data.getName());
			for(GenericTreeNode<Employee> y: temp.children) {
				q.add(y);
			}
		}
		
	}
	
}