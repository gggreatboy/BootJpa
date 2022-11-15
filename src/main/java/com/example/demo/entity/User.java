package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user_table")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//用户名
	@NotEmpty(message = "用户名不能为空")
    @Size(min = 1, max = 20)
    @Column(name="username",nullable = false) 
	private String username;
	//密码
	@NotEmpty(message = "密码不能为空")
    @Size(min = 1, max = 20)
    @Column(name="userpwd",nullable = true) 
	private String userpwd;

	//爱好
    @Column(name="favor") 
	private String favor;
    @Column(name="gender",nullable = true) 
	private String gender;
    //描述
    @Size(min = 0, max = 150)
    @Column(name="describe1") 
	private String describe;
    //籍贯
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    //可选属性optional=false,表示籍贯不能为空。
    @JoinColumn(name="native_id")//设置在user表中的关联字段(外键)
    @JsonIgnore
    private NativePlace nativeplace;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getFavor() {
		return favor;
	}
	public void setFavor(String favor) {
		this.favor = favor;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public NativePlace getNativeplace() {
		return nativeplace;
	}
	public void setNativeplace(NativePlace nativep) {
		this.nativeplace = nativep;
	}
	
}
