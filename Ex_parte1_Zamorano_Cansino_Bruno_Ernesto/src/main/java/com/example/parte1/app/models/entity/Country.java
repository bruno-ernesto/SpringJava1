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
@Table(name="Country")
public class Country implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String code_C;
	@NotEmpty
	private String name_C;
	@ManyToOne
	@JoinColumn(name="id")
	private Employee employee;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode_C() {
		return code_C;
	}
	public void setCode_C(String code_C) {
		this.code_C = code_C;
	}
	public String getName_C() {
		return name_C;
	}
	public void setName_C(String name_C) {
		this.name_C = name_C;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", code_C=" + code_C + ", name_C=" + name_C + ", employee=" + employee + "]";
	}
	
	
	
}
