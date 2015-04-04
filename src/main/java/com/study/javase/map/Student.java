package com.study.javase.map;

public class Student implements Comparable<Student>{
	String name;
	int score;
	public Student(String name, int score){
		this.score = score;
		this.name = name;
	}
	@Override
	public int compareTo(Student student) {
		if(this.score>student.score){
			return 1;
		}else if(this.score<student.score){
			return -1;
		}
		return 0;
	}
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("name:").append(name);
		sb.append(" ");
		sb.append("score:").append(score);
		return sb.toString();
	}

	
}
