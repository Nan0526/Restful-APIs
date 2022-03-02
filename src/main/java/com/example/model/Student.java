package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name = "Student")
public class Student {
		@Id
		@GeneratedValue
		
		private int stuId;
		public int getStuId() {
			return stuId;
		}
		public void setStuId(int stuId) {
			this.stuId = stuId;
		}
		public String getStuName() {
			return stuName;
		}
		public void setStuName(String stuName) {
			this.stuName = stuName;
		}
		public double getStuGra() {
			return stuGra;
		}
		public void setStuGra(double stuGra) {
			this.stuGra = stuGra;
		}
		private String stuName;
		private double stuGra;
		
		//constructor
		public Student() {
			
		}
		@Override
		public String toString() {
			return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuGra=" + stuGra + "]";
		}
		
		
		
}

