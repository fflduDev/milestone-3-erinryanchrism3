package tree;

import java.util.ArrayList;
import java.util.List;

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
				GenericTreeNode<Employee> thisMngr = findEmployee(manager);
				if(thisMngr != null) {
					GenericTreeNode<Employee> newNode = new GenericTreeNode<Employee>(newPerson);
					nodes.add(newNode);
					thisMngr.addChild(newNode);
				}
		
	}

	@Override
	public void removeEmployee(Employee firedPerson) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOrgChartDepthFirst() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOrgChartBreadthFirst() {
		// TODO Auto-generated method stub
		
	}
	public GenericTreeNode<Employee> findEmployee(Employee e){
		
		
		return root;
		
	}