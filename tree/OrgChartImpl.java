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
			
	

	@Override
	public void removeEmployee(Employee firedPerson) {
		 if (root == null) {
			 System.out.println("Tree is empty");
			 return;
		 }
		
		//special case if the fired person is the root
		if (root.data.equals(firedPerson)) {
	        if (!root.children.isEmpty()) {

	        	root = root.children.get(0);

	        	for (int i = 1; i < root.children.size(); i++) {
	                root.addChild(root.children.get(i));
	            }
	        } else {
	            root = null; 
	        }
	        nodes.remove(0);
	        return;
	    }
		
		
		
		 for (GenericTreeNode<Employee> parent : nodes) {
		        for (int i = 0; i < parent.children.size(); i++) {
		            GenericTreeNode<Employee> child = parent.children.get(i);
		            
		            if (child.data.equals(firedPerson)) {
		            	//found fired Person
		                parent.children.addAll(child.children);
		                parent.children.remove(i);
		                nodes.remove(child);
		                return;
		                
		            }
		        }
		    }
	
	}

	@Override
	public void showOrgChartDepthFirst() {
		
		if(root != null) {
			Stack<GenericTreeNode<Employee>> stack = new Stack<>();
			stack.push(root);
			
			while(!stack.isEmpty()) {
				GenericTreeNode<Employee> current = stack.pop();
				System.out.println("- " + current.data + " "  );
				
				for(int i = current.children.size() -1; i >= 0; i--) {
					stack.push(current.children.get(i));
				}
			}
		}
			
			
		
	}

	@Override
	public void showOrgChartBreadthFirst() {
		
		int count = 0;
		int printed = 0;
		Queue<GenericTreeNode<Employee>> q = new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			
			int levelSize = q.size();
			for(int i = 0; i< levelSize; i++) {
				GenericTreeNode<Employee> temp = q.poll();
				
				
				System.out.print(temp.data + " - ");
			
			for(GenericTreeNode<Employee> y: temp.children) {
				q.add(y);
			}
		}
		System.out.println();
	}
	}
}