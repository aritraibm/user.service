package com.pru.test.user.service.VO;

import org.springframework.stereotype.Component;

import com.pru.test.user.service.entity.User;


public class ResponseTemplateVO {

	private User user;
	private Department dept;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public ResponseTemplateVO(User user, Department dept) {
		super();
		this.user = user;
		this.dept = dept;
	}
	public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseTemplateVO [user=" + user + ", dept=" + dept + "]";
	}
	
	
	
}
