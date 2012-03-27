package com.pojo.system;

import java.util.List;

public class Menu {
	private Object node;
	private List<Object> childNodes;
	public Menu() {
	}
	public Menu(Object node) {
		this.node = node;
	}
	public Menu(Object node, List<Object> childNodes) {
		this.node = node;
		this.childNodes = childNodes;
	}
	public Object getNode() {
		return node;
	}
	public void setNode(Object node) {
		this.node = node;
	}
	public List<Object> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<Object> childNodes) {
		this.childNodes = childNodes;
	}
	
	
}
