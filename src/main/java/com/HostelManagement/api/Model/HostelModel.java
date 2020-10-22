package com.HostelManagement.api.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="mst_user")
@Data
public class HostelModel {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer UserId;
	public String FirstName;
	public String LastName;
	public String Email;
	public String UserPassWord;
	public Integer IsDeleted;
	@Temporal(TemporalType.DATE)
	public Date CreatedDateTime;
	@Temporal(TemporalType.DATE)
	public Date UpdatedDateTime;
	
}
