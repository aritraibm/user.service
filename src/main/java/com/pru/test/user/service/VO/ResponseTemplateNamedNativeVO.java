package com.pru.test.user.service.VO;

import org.springframework.stereotype.Component;

import com.pru.test.user.service.entity.User;


public class ResponseTemplateNamedNativeVO {

	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public ResponseTemplateNamedNativeVO(User user) {
		super();
		this.user = user;
	}
	public ResponseTemplateNamedNativeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseTemplateVO [user=" + user + "]";
	}
	
	
	
}
