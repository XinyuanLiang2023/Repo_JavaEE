package com.example.accessingdatamysql;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@NotEmpty(message="姓名不能为空，请重新输入")
	@Size(min=2, max=30,message="姓名长度应为2到30，请重新输入")
	private String name;

	@NotEmpty(message="邮箱不能为空，请重新输入")
	@Email(message = "不是一个合法的邮箱地址，请重新输入")
	private String email;

	public Integer getId() {
		return id;
	  }
	
	  public void setId(Integer id) {
		this.id = id;
	  }
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "User(Name: " + this.name + ", Email: " + this.email + ")";
	}
}
