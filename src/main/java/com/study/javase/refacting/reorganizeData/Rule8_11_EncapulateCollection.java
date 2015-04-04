package com.study.javase.refacting.reorganizeData;

import java.util.HashSet;
import java.util.Set;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * 对Collection不直接进行访问，而需要通过方法
 * @author BULL
 *
 */
public class Rule8_11_EncapulateCollection {

}

class Person{
	private Set<Course> courseSet = new HashSet<Course>();
	public void addCourse(Course course){
		this.courseSet.add(course);
	}
	public void removeCourse(Course course){
		this.courseSet.remove(course);
	}
	
	public Set<Course> getCourses(){
		return Collections.unmodifiableSet(courseSet);
	}
	
}
class Course{
	private String name;
	private boolean important;
	
	public Course(String name, boolean important){
		this.name = name;
		this.important = important;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isImportant() {
		return important;
	}
	public void setImportant(boolean important) {
		this.important = important;
	}
	
}