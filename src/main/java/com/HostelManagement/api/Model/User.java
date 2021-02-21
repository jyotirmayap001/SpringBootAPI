package com.HostelManagement.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="mstuser")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userid")
	public Integer userid;
	
	@Column(name="firstname")
	public String firstname;
	
	@Column(name="lastname")
	public String lastname;
	
	@Column(name="email")
	public String email;
	
	@Column(name="userpassword")
	public String userpassword;
	
	@Column(name="isdeleted")
	public Integer isdeleted;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createddatetime")
	public Date createddatetime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="deleteddatetime")
	public Date deleteddatetime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updateddatetime")
	public Date updateddatetime;

	
	
	public User() {
		
	}
	
	
	
	
	public User(Integer userid, String firstname, String lastname, String email, String userpassword,
			Integer isdeleted, Date createddatetime, Date deleteddatetime, Date updateddatetime) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.userpassword = userpassword;
		this.isdeleted = isdeleted;
		this.createddatetime = createddatetime;
		this.deleteddatetime = deleteddatetime;
		this.updateddatetime = updateddatetime;
	}

	
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public Integer getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Integer isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Date getCreateddatetime() {
		return createddatetime;
	}

	public void setCreateddatetime(Date createddatetime) {
		this.createddatetime = createddatetime;
	}

	public Date getDeleteddatetime() {
		return deleteddatetime;
	}

	public void setDeleteddatetime(Date deleteddatetime) {
		this.deleteddatetime = deleteddatetime;
	}

	public Date getUpdateddatetime() {
		return updateddatetime;
	}

	public void setUpdateddatetime(Date updateddatetime) {
		this.updateddatetime = updateddatetime;
	}




	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", userpassword=" + userpassword + ", isdeleted=" + isdeleted + ", createddatetime=" + createddatetime
				+ ", deleteddatetime=" + deleteddatetime + ", updateddatetime=" + updateddatetime + "]";
	}
	
	
	
	
	
	
}
