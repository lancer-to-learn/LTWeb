package vn.group.model;

public class AccountModel {
		private int id;
		private String user;
		private String pass;
		private String phone;
		private String email;
		private int role;
		private String image;
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public String getPhone() {
			return phone;
		}
	
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getRole() {
			return role;
		}
		public void setRole(int role) {
			this.role = role;
		}
		public AccountModel() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AccountModel(int id, String user, String pass, String phone, String email, int role, String image) {
			super();
			this.id = id;
			this.user = user;
			this.pass = pass;
			this.phone = phone;
			this.email = email;
			this.role = role;
			this.image = image;
		}

		
}
