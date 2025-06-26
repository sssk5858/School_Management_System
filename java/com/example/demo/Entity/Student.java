package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="Student2")
public class Student {
	public Student(int pin, String name, int marks) {
		super();
		this.pin = pin;
		this.name = name;
		this.marks = marks;
	}

	@Id
	private int pin;

	private String name;
	
	private int marks;

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [pin=" + pin + ", name=" + name + ", marks=" + marks + "]";
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
