package com.aasutosh.pojo;

public class Student {
	private Integer studentId;

	private String studentName;

	public Integer getStudentId() {
		return studentId;
	}

	public Student setStudentId(Integer studentId) {
		this.studentId = studentId;
		return this;
	}

	public String getStudentName() {
		return studentName;
	}

	public Student setStudentName(String studentName) {
		this.studentName = studentName;
		return this;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d \t Name : %s \t\t", studentId,studentName);
	}
}
