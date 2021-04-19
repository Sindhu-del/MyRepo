package com.te.springmvc.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="employee_info")
public class EmpBean implements Serializable{
	
	@Id
	private Integer id;
	@Column
	private String name;
	@Column
	private Date dob;
	@Column
	private String password;
	
	

}
