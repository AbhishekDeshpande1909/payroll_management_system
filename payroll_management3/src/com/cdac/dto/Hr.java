package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR")
public class Hr {
	@Id
	@GeneratedValue
	@Column(name = "hr_id")
	private int hrId;
	
	@Column(name = "hr_name")
	private String hrName;
	
	@Column(name = "hr_pass")
	private String hrPass;

	public Hr() {
	}

	public Hr(int hrId, String hrName, String hrPass) {
		super();
		this.hrId = hrId;
		this.hrName = hrName;
		this.hrPass = hrPass;
	}

	public int getHrId() {
		return hrId;
	}

	public void setHrId(int hrId) {
		this.hrId = hrId;
	}

	public String getHrName() {
		return hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	public String getHrPass() {
		return hrPass;
	}

	public void setHrPass(String hrPass) {
		this.hrPass = hrPass;
	}

	@Override
	public String toString() {
		return "Hr [hrId=" + hrId + ", hrName=" + hrName + ", hrPass=" + hrPass + "]";
	}


	

}
