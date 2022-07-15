package com.example.beandefinition;

/**
 * @author lidongmeng
 * Created on 2022-07-14
 */
public class Root {
	private String name;
	private String description;
	private Boolean isRoot;

	public Root() {
	}

	public Root(String name, String description, Boolean isRoot) {
		this.name = name;
		this.description = description;
		this.isRoot = isRoot;
	}

	@Override
	public String toString() {
		return "Root{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", isRoot=" + isRoot +
				'}';
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
}
