package com.example.beandefinition;

/**
 * @author lidongmeng
 * Created on 2022-07-14
 */
public class Child {
	private String name;
	private String description;
	private Boolean isRoot;
	private String parentName;

	public Child() {
	}

	public Child(String name, String description, Boolean isRoot, String parentName) {
		this.name = name;
		this.description = description;
		this.isRoot = isRoot;
		this.parentName = parentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsRoot() {
		return isRoot;
	}

	public void setIsRoot(boolean root) {
		isRoot = root;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Override
	public String toString() {
		return "Child{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", isRoot=" + isRoot +
				", parentName='" + parentName + '\'' +
				'}';
	}
}
