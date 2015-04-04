package com.study.javase.map;

public class StudentDetail {
	Student s;
	public StudentDetail(Student s){
		this.s = s;
	}
	@Override
	public String toString(){
		return s.name + " 's detial info";
	}
}
