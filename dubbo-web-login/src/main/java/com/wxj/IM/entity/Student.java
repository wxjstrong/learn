package com.wxj.IM.entity;

public class Student {

	String name;
	int     age;
	String  classLevel;
	
	
	
	public  Student(String name,int age,String classLevel){
		this.name=name;
		this.age=age;
		this.classLevel=classLevel;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}

	
	
	
	
	
	
	
	
	
}
