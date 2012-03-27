package com.pojo;

import java.io.Serializable;

public class Grade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Student student;
	private Course course;
	private Double midScore;
	private Double finalScore;
	private String memo;
	
	
	private Double totalScore;
	
	public Grade() {
	}
	public Grade(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Double getMidScore() {
		return midScore;
	}
	public void setMidScore(Double midScore) {
		this.midScore = midScore;
	}
	public Double getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(Double finalScore) {
		this.finalScore = finalScore;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}
	
}
