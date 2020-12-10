package com.cg.vms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

@Entity
@Table(name = "User_Table")
public class User {

		@Id
		@Column(name = "user_id",length = 15)
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long userId;
		@Column(name = "user_name" , length = 15)
		@NotNull
		private String userName;
		@Column(name = "email_id" , length = 30)
		@NotNull
		private String emailId;
		@Column(name = "password", length = 15)
		@NotNull
		@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[@#$&*]).{8,15}$", message = "Password must cointain capital, small letters and numbers and contain atleast One Special Character")
		private String password;
		@Column(name = "phone_number", length = 15)
		@NotNull
		private String phoneNumber;
		
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public User() {
			super();
		}
		public User(@NotNull String userName, @NotNull String emailId,
				@NotNull @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[@#$&*]).{8,15}$", message = "Password must cointain capital, small letters and numbers and contain atleast One Special Character") String password,
				@NotNull String phoneNumber) {
			super();
			this.userName = userName;
			this.emailId = emailId;
			this.password = password;
			this.phoneNumber = phoneNumber;
		}
		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", password="
					+ password + ", phoneNumber=" + phoneNumber + "]";
		}
		
		
		
		

}
