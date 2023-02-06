package com.example.demo.bindings;




public class ActivateAccount {
	
	
	public ActivateAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActivateAccount(String registrationMail, String newpassword, String temporaryPassword,
			String confirmPassword) {
		super();
		this.registrationMail = registrationMail;
		this.newpassword = newpassword;
		this.temporaryPassword = temporaryPassword;
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "ActivateAccount [registrationMail=" + registrationMail + ", newpassword=" + newpassword
				+ ", temporaryPassword=" + temporaryPassword + ", confirmPassword=" + confirmPassword + "]";
	}
	private String registrationMail;
	private String newpassword;
	private String temporaryPassword;
	private String confirmPassword;
	
	
	public String getRegistrationMail() {
		return registrationMail;
	}
	public void setRegistrationMail(String registrationMail) {
		this.registrationMail = registrationMail;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getTemporaryPassword() {
		return temporaryPassword;
	}
	public void setTemporaryPassword(String temporaryPassword) {
		this.temporaryPassword = temporaryPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


}
