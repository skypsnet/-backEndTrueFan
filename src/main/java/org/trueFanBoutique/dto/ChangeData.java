package org.trueFanBoutique.dto;

public class ChangeData {

		private Long phone;
	    private Long nphone;
	    private String password;
	    private String npassword;
	    
	

	    public ChangeData(Long phone, Long nphone, String password, String npassword) {
			this.phone = phone;
			this.nphone = nphone;
			this.password = password;
			this.npassword = npassword;
		}//constructor 1

	    public ChangeData() {
		}//constructor 2

		public Long getPhone() {
			return phone;
		}//getPhone

		public void setPhone(Long phone) {
			this.phone = phone;
		}//setPhone

		public Long getNphone() {
			return nphone;
		}//getNphone

		public void setNphone(Long nphone) {
			this.nphone = nphone;
		}//setNphone

		public String getPassword() {
			return password;
		}//getPassword

		public void setPassword(String password) {
			this.password = password;
		}//setPassword
		
		public String getNpassword() {
			return npassword;
		}//getNpassword

		public void setNpassword(String npassword) {
			this.npassword = npassword;
		}//setNpassword

		@Override
		public String toString() {
			return "ChangeData [phone=" + phone + ", nphone=" + nphone + ", password=" + password + ", npassword="
					+ npassword + "]";
		}
	  
}//class ChangePassword
