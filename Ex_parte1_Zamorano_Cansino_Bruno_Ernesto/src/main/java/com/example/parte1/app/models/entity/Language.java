package com.example.parte1.app.models.entity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Language")
public class Language implements Serializable  {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String code_L;
	@NotEmpty
	private String name_L;
	@ManyToOne
	@JoinColumn(name="id")
	private Employee employee;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode_L() {
		return code_L;
	}
	public void setCode_L(String code_L) {
		this.code_L = code_L;
	}
	public String getName_L() {
		return name_L;
	}
	public void setName_L(String name_L) {
		this.name_L = name_L;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Language [id=" + id + ", code_L=" + code_L + ", name_L=" + name_L + ", employee=" + employee + "]";
	}
	
	
	
}
