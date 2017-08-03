package com.caozhenjieproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name = "girl_order")
public class GirlOrder {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;
	
	private String eat;
	
	private String tools;
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Girl girl;
	

	

	public Girl getGirl() {
		return girl;
	}



	public void setGirl(Girl girl) {
		this.girl = girl;
	}



	public String getEat() {
		return eat;
	}



	public void setEat(String eat) {
		this.eat = eat;
	}



	public String getTools() {
		return tools;
	}



	public void setTools(String tools) {
		this.tools = tools;
	}



	
	

	
	
	
	
	

}
