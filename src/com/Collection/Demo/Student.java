package com.Collection.Demo;

import java.util.HashSet;
import java.util.Set;

/*
 * 学生类
 */
public class Student {
	private String id;
	private String name;
	public Set<Course> courses;// set是Collection子接口

	public Student(String id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.courses = new HashSet<Course>();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}
